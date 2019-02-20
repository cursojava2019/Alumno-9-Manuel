package es.indra.academia.model.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.indra.academia.model.dao.ProfesorJpaDao;
import es.indra.academia.model.entities.Profesor;
import es.indra.academia.model.support.DaoException;
import es.indra.academia.model.support.jpa.JpaDao;
import es.indra.academia.model.support.jpa.ServiceJpa;

@Service
public class ProfesorJpaService extends ServiceJpa<Long, Profesor> {
	@Autowired
	private ProfesorJpaDao dao;
	private Logger log = LogManager.getLogger(ProfesorJpaService.class);
	@Override
	public JpaDao<Long, Profesor> getDao() {
		return this.dao;
	}

	public List<Profesor> buscarNif(String nif) {
		try {
			return this.dao.buscarNif(nif);
		} catch (DaoException e) {
			this.log.error("Error buscando NIF", e);
			return null;
		}
	}
}
