package es.indra.academia.controller.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import es.indra.academia.model.entities.ResponsableAlumno;
import es.indra.academia.model.service.ResponsableJpaService;
import es.indra.academia.model.support.DaoException;
import es.indra.academia.model.support.ServiceException;

@Component
public class ResponsableAlumnoConverter implements Converter<String, ResponsableAlumno> {

	@Autowired
	private ResponsableJpaService responsableService;
	
	@Override
	public ResponsableAlumno convert(String source) {
		ResponsableAlumno responsable = null;
		try {
			Long id = Long.parseLong(source);

			responsable = null;

			responsable = this.responsableService.buscar(id);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			return null;
		}

		return responsable;
	}

}