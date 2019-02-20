package es.indra.academia.controller.alumnos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.indra.academia.authentication.MyUserDetails;
import es.indra.academia.configuration.Configuracion;
import es.indra.academia.model.entities.Alumno;
import es.indra.academia.model.entities.ResponsableAlumno;
import es.indra.academia.model.service.AlumnoJpaService;
import es.indra.academia.model.service.ResponsableJpaService;
import es.indra.academia.model.support.DaoException;
import es.indra.academia.model.support.ServiceException;

@Controller
@RequestMapping("/admin/alumnos")
public class AlumnoController {
	@Autowired
	AlumnoJpaService alumnoService;
	@Autowired
	ResponsableJpaService responsableService;
	@Autowired
	AlumnoFormValidator validador;
	private Logger log = LogManager.getLogger(AlumnoController.class);

	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e, Model model) {
		model.addAttribute("error", e.getMessage());
		// logger.error(e);
		return "error";
	}

	@RequestMapping(value = "/listado.html", method = RequestMethod.GET)
	public String listado(Model model) throws ServiceException, DaoException {
		MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = user.getUsername(); // get logged in username

		this.log.info("listado Alumnos");
		List<Alumno> listado = this.alumnoService.buscarTodos();
		model.addAttribute("listado", listado);
		return "alumnos/listado";
	}

	@RequestMapping(value = "/nuevo.html", method = RequestMethod.GET)
	public String nuevo(Model model) throws ServiceException, DaoException {
		model.addAttribute("alumno", new AlumnoForm(new Alumno()));
		
		List<ResponsableAlumno> listado = this.responsableService.buscarTodos();
		model.addAttribute("listado", listado);
		return "alumnos/nuevo";
	}
	

	@Transactional
	@RequestMapping(value = "/nuevo.html", method = RequestMethod.POST)
	public String nuevoPost(@Valid @ModelAttribute("alumno") AlumnoForm form, BindingResult result)
			throws ServiceException, DaoException {
		ArrayList<String> errores = new ArrayList<String>();
		this.validador.validate(form, result);
		if (result.hasErrors()) {
			return "alumnos/nuevo";

		} else {
			Alumno a=form.obtenerAlumno();
			ResponsableAlumno al=a.getResponsableAlumno();
			a.setResponsableAlumno(null);
			this.alumnoService.crear(a);
			a.setResponsableAlumno(al);
			this.alumnoService.modificar(a);
			
			return "redirect:/admin/alumnos/listado.html?mensaje=correcto";

		}

	}

	@RequestMapping(value = "/modificar.html", method = RequestMethod.GET)
	public String modificar(@RequestParam("id") Long id, Model model) throws ServiceException, DaoException {
		Alumno alumno = this.alumnoService.buscar(id);
		
		if (id == null) {
			return "redirect:/admin/alumnos/listado.html?mensaje=errorId";

		} else {
			if (alumno != null) {
				
					List<ResponsableAlumno> listado = this.responsableService.buscarTodos();
					model.addAttribute("listado", listado);
					AlumnoForm form = new AlumnoForm(alumno);
					model.addAttribute("formulario", form);
				
				return "alumnos/modificar";
				
			} else {
				return "redirect:/admin/alumnos/listado.html?mensaje=errorId";
			}

		}

	}

	@Transactional
	@RequestMapping(value = "/modificar.html", method = RequestMethod.POST)
	public String modificarPost(@ModelAttribute("formulario") AlumnoForm alumno, Model model)
			throws ServiceException, DaoException {
		ArrayList<String> errores = new ArrayList<String>();

		// alumno.validar(errores);
		if (errores.size() > 0) {

			model.addAttribute("errores", errores);

			return "alumnos/modificar";
		} else {
			Alumno a=this.alumnoService.buscar(alumno.getId());
			alumno.actualizar(a);
			
			this.alumnoService.modificar(a);

			return "redirect:/admin/alumnos/listado.html?mensaje=correcto";
		}

	}

	@RequestMapping(value = "/eliminar.html", method = RequestMethod.GET)
	public String eliminar(@RequestParam("id") Long id, Model model) throws ServiceException, DaoException {

		if (id == null) {
			return "redirect:/admin/alumnos/listado.html?mensaje=errorId";
		} else {
			Alumno alumno = this.alumnoService.buscar(id);
			if (alumno != null) {
				this.alumnoService.eliminarById(id);
				return "redirect:/admin/alumnos/listado.html?mensaje=correcto";
			} else {
				return "redirect:/admin/alumnos/listado.html?mensaje=errorId";
			}

		}

	}

}
