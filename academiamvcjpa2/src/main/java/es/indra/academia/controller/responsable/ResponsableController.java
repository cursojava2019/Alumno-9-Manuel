package es.indra.academia.controller.responsable;

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
import es.indra.academia.model.entities.Alumno;
import es.indra.academia.model.entities.ResponsableAlumno;
import es.indra.academia.model.service.ResponsableJpaService;
import es.indra.academia.model.support.DaoException;
import es.indra.academia.model.support.ServiceException;

@Controller
@RequestMapping("/admin/responsable")
public class ResponsableController {
	@Autowired
	ResponsableJpaService responsableService;

	@Autowired
	ResponsableFormValidator validador;
	private Logger log = LogManager.getLogger(ResponsableController.class);

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

		this.log.info("listado Responsable");
		List<ResponsableAlumno> listado = this.responsableService.buscarTodos();
		model.addAttribute("listado", listado);
		return "responsable/listado";
	}

	@RequestMapping(value = "/nuevo.html", method = RequestMethod.GET)
	public String nuevo(Model model) {
		model.addAttribute("responsable", new ResponsableForm(new ResponsableAlumno()));
		return "responsable/nuevo";
	}

	@RequestMapping(value = "/nuevo.html", method = RequestMethod.POST)
	public String nuevoPost(@Valid @ModelAttribute("responsable") ResponsableForm form, BindingResult result)
			throws ServiceException, DaoException {
		ArrayList<String> errores = new ArrayList<String>();
		this.validador.validate(form, result);
		if (result.hasErrors()) {
			return "responsable/nuevo";

		} else {

			this.responsableService.crear(form.obtenerResponsable());
			return "redirect:/admin/responsable/listado.html?mensaje=correcto";

		}

	}

	@RequestMapping(value = "/modificar.html", method = RequestMethod.GET)
	public String modificar(@RequestParam("id") Long id, Model model) throws ServiceException, DaoException {
		if (id == null) {
			return "redirect:/admin/responsable/listado.html?mensaje=errorId";

		} else {
			ResponsableAlumno responsablealumno = this.responsableService.buscar(id);
			if (responsablealumno != null) {
				ResponsableForm form = new ResponsableForm(responsablealumno);
				model.addAttribute("formulario", form);
				return "responsable/modificar";

			} else {
				return "redirect:/admin/responsable/listado.html?mensaje=errorId";
			}

		}

	}

	@RequestMapping(value = "/modificar.html", method = RequestMethod.POST)
	public String modificarPost(@ModelAttribute("formulario") ResponsableForm responsablealumno, Model model)
			throws ServiceException, DaoException {
		ArrayList<String> errores = new ArrayList<String>();

		// alumno.validar(errores);
		if (errores.size() > 0) {

			model.addAttribute("errores", errores);

			return "responsable/modificar";
		} else {

			this.responsableService.modificar(responsablealumno.obtenerResponsable());

			return "redirect:/admin/responsable/listado.html?mensaje=correcto";
		}

	}

	@RequestMapping(value = "/eliminar.html", method = RequestMethod.GET)
	public String eliminar(@RequestParam("id") Long id, Model model) throws ServiceException, DaoException {

		if (id == null) {
			return "redirect:/admin/responsable/listado.html?mensaje=errorId";
		} else {
			ResponsableAlumno responsablealumno = this.responsableService.buscar(id);
			if (responsablealumno != null) {
				this.responsableService.eliminarById(id);
				return "redirect:/admin/responsable/listado.html?mensaje=correcto";
			} else {
				return "redirect:/admin/responsable/listado.html?mensaje=errorId";
			}

		}

	}
	
	@RequestMapping(value = "/detalles.html", method = RequestMethod.GET)
	public String detalles(@RequestParam("id") Long id, Model model) throws ServiceException, DaoException {
		if (id == null) {
			return "redirect:/admin/responsable/listado.html?mensaje=errorId";

		} else {
			ResponsableAlumno responsablealumno = this.responsableService.buscar(id);
			if (responsablealumno != null) {
				List<Alumno> listado = responsablealumno.getAlumnos();
				model.addAttribute("listado", listado);
				return "responsable/detalles";

			} else {
				return "redirect:/admin/responsable/detalles.html?mensaje=errorId";
			}

		}

	}
	

}
