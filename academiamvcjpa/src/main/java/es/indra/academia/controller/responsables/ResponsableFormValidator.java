package es.indra.academia.controller.responsables;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import es.indra.academia.model.entities.ResponsableAlumno;
import es.indra.academia.model.service.ResponsableService;

@Component
public class ResponsableFormValidator {
	@Autowired
	private ResponsableService responsableService;

	public boolean supports(Class<?> clazz) {
		return ResponsableForm.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		ResponsableForm form = (ResponsableForm) target;
		if (form.getNif() != null && !form.getNif().equals("")) {
			List<ResponsableAlumno> listado = this.responsableService.buscarNif(form.getNif());
			if (listado != null && !listado.isEmpty()) {
				ResponsableAlumno responsable = listado.get(0);
				if (form.getId() == null || (!responsable.getId().equals(form.getId()))) {
					errors.rejectValue("nif", "nif.unico");
				}

			}
		}
	}
}
