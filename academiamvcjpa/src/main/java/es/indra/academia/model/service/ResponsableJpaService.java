package es.indra.academia.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.indra.academia.model.dao.ResponsableJpaDao;
import es.indra.academia.model.entities.ResponsableAlumno;
import es.indra.academia.model.support.jpa.JpaDao;
import es.indra.academia.model.support.jpa.ServiceJpa;

@Service
public class ResponsableJpaService extends ServiceJpa<Long, ResponsableAlumno> {
	@Autowired
	private ResponsableJpaDao dao;

	@Override
	public JpaDao<Long, ResponsableAlumno> getDao() {
		return this.dao;
	}
}
