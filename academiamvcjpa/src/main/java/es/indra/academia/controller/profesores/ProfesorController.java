package es.indra.academia.controller.profesores;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.indra.academia.authentication.MyUserDetails;
import es.indra.academia.model.entities.Profesor;
import es.indra.academia.model.service.ProfesorJpaService;
import es.indra.academia.model.support.DaoException;
import es.indra.academia.model.support.ServiceException;

@Controller
@RequestMapping("/admin/profesores")
public class ProfesorController {
	@Autowired
	ProfesorJpaService profesorService;

	@Autowired
	ProfesorFormValidator validador;
	private Logger log = LogManager.getLogger(ProfesorController.class);

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

		this.log.info("listado Profesores");
		List<Profesor> listado = this.profesorService.buscarTodos();
		model.addAttribute("listado", listado);
		return "profesores/listado";
	}

	@RequestMapping(value = "/nuevo.html", method = RequestMethod.GET)
	public String nuevo(Model model) {
		model.addAttribute("profesor", new ProfesorForm(new Profesor()));
		return "profesores/nuevo";
	}

	@RequestMapping(value = "/nuevo.html", method = RequestMethod.POST)
	public String nuevoPost(@Valid @ModelAttribute("profesor") ProfesorForm form, BindingResult result)
			throws ServiceException, DaoException {
		ArrayList<String> errores = new ArrayList<String>();
		this.validador.validate(form, result);
		if (result.hasErrors()) {
			return "profesores/nuevo";

		} else {

			this.profesorService.crear(form.obtenerProfesor());
			return "redirect:/admin/profesores/listado.html?mensaje=correcto";

		}

	}

	@RequestMapping(value = "/modificar.html", method = RequestMethod.GET)
	public String modificar(@RequestParam("id") Long id, Model model) throws ServiceException, DaoException {
		if (id == null) {
			return "redirect:/admin/profesores/listado.html?mensaje=errorId";

		} else {
			Profesor profesor = this.profesorService.buscar(id);
			if (profesor != null) {
				ProfesorForm form = new ProfesorForm(profesor);
				model.addAttribute("formulario", form);
				return "profesores/modificar";

			} else {
				return "redirect:/admin/profesores/listado.html?mensaje=errorId";
			}

		}

	}

	@RequestMapping(value = "/modificar.html", method = RequestMethod.POST)
	public String modificarPost(@ModelAttribute("formulario") ProfesorForm profesor, Model model)
			throws ServiceException, DaoException {
		ArrayList<String> errores = new ArrayList<String>();

		// alumno.validar(errores);
		if (errores.size() > 0) {

			model.addAttribute("errores", errores);

			return "profesores/modificar";
		} else {

			this.profesorService.modificar(profesor.obtenerProfesor());

			return "redirect:/admin/profesores/listado.html?mensaje=correcto";
		}

	}

	@RequestMapping(value = "/eliminar.html", method = RequestMethod.GET)
	public String eliminar(@RequestParam("id") Long id, Model model) throws ServiceException, DaoException {

		if (id == null) {
			return "redirect:/admin/profesores/listado.html?mensaje=errorId";
		} else {
			Profesor profesor = this.profesorService.buscar(id);
			if (profesor != null) {
				this.profesorService.eliminarById(id);
				return "redirect:/admin/profesores/listado.html?mensaje=correcto";
			} else {
				return "redirect:/admin/profesores/listado.html?mensaje=errorId";
			}

		}

	}

}
