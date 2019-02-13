package es.indra.academia.model.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import es.indra.academia.model.entities.ResponsableAlumno;
import es.indra.academia.model.support.jpa.AbstracJpaDao;

@Repository
public class ResponsableJpaDao extends AbstracJpaDao<Long, ResponsableAlumno> {

	@Override
	protected Class<ResponsableAlumno> getClase() {
		return ResponsableAlumno.class;
	}

	List<ResponsableAlumno> findResponsableAlumnoPatron(String patron) {
		String queryString = "SELECT o From RESPONSABLE_ALUMNO o Where WHERE LOWER(o.nif) like LOWER('%" + patron
				+ "%') OR LOWER(o.nombre) like LOWER('%" + patron + "%') OR LOWER(o.apellido1) like LOWER('%" + patron
				+ "%')  OR LOWER(o.apellido2) like LOWER('%" + patron + "%') ;";

		Query query = this.entityManager.createQuery(queryString);
		return query.getResultList();
	}

}
