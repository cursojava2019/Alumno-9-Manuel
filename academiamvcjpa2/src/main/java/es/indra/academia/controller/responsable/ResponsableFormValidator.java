package es.indra.academia.controller.responsable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.indra.academia.model.entities.ResponsableAlumno;
import es.indra.academia.model.service.ResponsableJpaService;

@Component
public class ResponsableFormValidator implements Validator {
	@Autowired
	private ResponsableJpaService responsableService;

	@Override
	public boolean supports(Class<?> clazz) {
		return ResponsableForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ResponsableForm form = (ResponsableForm) target;
		if (form.getNif() != null && !form.getNif().equals("")) {
			List<ResponsableAlumno> listado = this.responsableService.buscarNif(form.getNif());
			if (listado != null && !listado.isEmpty()) {
				ResponsableAlumno responsablealumno = listado.get(0);
				if (form.getId() == null || (!responsablealumno.getId().equals(form.getId()))) {
					errors.rejectValue("nif", "nif.unico");
				}

			}
		}
	}

}
