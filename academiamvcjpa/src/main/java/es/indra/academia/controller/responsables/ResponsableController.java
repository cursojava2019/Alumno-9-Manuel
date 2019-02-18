package es.indra.academia.controller.responsables;

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
import es.indra.academia.model.entities.ResponsableAlumno;
import es.indra.academia.model.service.ResponsableJpaService;
import es.indra.academia.model.support.DaoException;
import es.indra.academia.model.support.ServiceException;

@Controller
@RequestMapping("/admin/responsables")
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

		this.log.info("listado Responsables");
		List<ResponsableAlumno> listado = this.responsableService.buscarTodos();
		model.addAttribute("listado", listado);
		return "responsables/listado";
	}

	@RequestMapping(value = "/nuevo.html", method = RequestMethod.GET)
	public String nuevo(Model model) {
		model.addAttribute("responsable", new ResponsableForm(new ResponsableAlumno()));
		return "responsables/nuevo";
	}

	@RequestMapping(value = "/nuevo.html", method = RequestMethod.POST)
	public String nuevoPost(@Valid @ModelAttribute("responsable") ResponsableForm form, BindingResult result)
			throws ServiceException, DaoException {
		ArrayList<String> errores = new ArrayList<String>();
		this.validador.validate(form, result);
		if (result.hasErrors()) {
			return "responsables/nuevo";

		} else {

			this.responsableService.crear(form.obtenerResponsableAlumno());
			return "redirect:/admin/responsables/listado.html?mensaje=correcto";

		}

	}

	@RequestMapping(value = "/modificar.html", method = RequestMethod.GET)
	public String modificar(@RequestParam("id") Long id, Model model) throws ServiceException, DaoException {
		if (id == null) {
			return "redirect:/admin/responsables/listado.html?mensaje=errorId";

		} else {
			ResponsableAlumno responsable = this.responsableService.buscar(id);
			if (responsable != null) {
				ResponsableForm form = new ResponsableForm(responsable);
				model.addAttribute("formulario", form);
				return "responsables/modificar";

			} else {
				return "redirect:/admin/responsables/listado.html?mensaje=errorId";
			}

		}

	}

	@RequestMapping(value = "/modificar.html", method = RequestMethod.POST)
	public String modificarPost(@ModelAttribute("formulario") ResponsableForm responsable, Model model)
			throws ServiceException, DaoException {
		ArrayList<String> errores = new ArrayList<String>();

		// alumno.validar(errores);
		if (errores.size() > 0) {

			model.addAttribute("errores", errores);

			return "responsables/modificar";
		} else {

			this.responsableService.modificar(responsable.obtenerResponsableAlumno());

			return "redirect:/admin/responsables/listado.html?mensaje=correcto";
		}

	}

	@RequestMapping(value = "/eliminar.html", method = RequestMethod.GET)
	public String eliminar(@RequestParam("id") Long id, Model model) throws ServiceException, DaoException {

		if (id == null) {
			return "redirect:/admin/responsables/listado.html?mensaje=errorId";
		} else {
			ResponsableAlumno responsable = this.responsableService.buscar(id);
			if (responsable != null) {
				this.responsableService.eliminarById(id);
				return "redirect:/admin/responsables/listado.html?mensaje=correcto";
			} else {
				return "redirect:/admin/responsables/listado.html?mensaje=errorId";
			}

		}
	}
}
