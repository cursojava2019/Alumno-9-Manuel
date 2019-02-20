package es.indra.academia.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.indra.academia.model.dao.AlumnoJpaDao;
import es.indra.academia.model.entities.Alumno;
import es.indra.academia.model.support.DaoException;
import es.indra.academia.model.support.jpa.JpaDao;
import es.indra.academia.model.support.jpa.ServiceJpa;

@Service
public class AlumnoJpaService extends ServiceJpa<Long, Alumno> {
	@Autowired
	private AlumnoJpaDao dao;

	@Override
	public JpaDao<Long, Alumno> getDao() {
		return this.dao;
	}

	/*public List<Alumno> buscaralumno (String nif) throws DaoException{
		List<Alumno> a= this.dao.buscarNif2(nif);
		return a;
	}*/
	
}
