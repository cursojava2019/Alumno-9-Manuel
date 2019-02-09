package es.indra.academia.model.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import es.indra.academia.model.dao.ResponsableDao;
import es.indra.academia.model.entities.ResponsableAlumno;
import es.indra.academia.model.support.Dao;
import es.indra.academia.model.support.DaoException;
import es.indra.academia.model.support.Service;

@org.springframework.stereotype.Service
public class ResponsableAlumnoService extends Service<Long, ResponsableAlumno> {
	@Autowired
	private ResponsableDao dao;
	private Logger log = LogManager.getLogger(ResponsableAlumnoService.class);

	@Override
	protected Dao<Long, ResponsableAlumno> getDao() {
		return this.dao;
	}

	public List<ResponsableAlumno> findResponsableAlumnoPatron(String patron) {
		try {
			return this.dao.findResponsableAlumno(patron);
		} catch (DaoException e) {
			e.printStackTrace();
			return new ArrayList<ResponsableAlumno>();
		}

	}

	@Override
	protected Logger getLog() {
		return this.log;

	}

	public List<ResponsableAlumno> buscarNif(String nif) {
		try {
			return this.dao.buscarNif(nif);
		} catch (DaoException e) {
			this.log.error("Error buscando NIF", e);
			return null;
		}
	}
}
