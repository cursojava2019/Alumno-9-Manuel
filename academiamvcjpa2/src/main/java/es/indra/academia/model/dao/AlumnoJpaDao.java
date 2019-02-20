package es.indra.academia.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import es.indra.academia.configuration.Configuracion;
import es.indra.academia.model.entities.Alumno;
import es.indra.academia.model.support.DaoException;
import es.indra.academia.model.support.jpa.AbstracJpaDao;

@Repository
public class AlumnoJpaDao extends AbstracJpaDao<Long, Alumno> {

	private static final String CAMPOS = "nif,nombre,apellido1,apellido2,telefono,correo,repetidor,fechaalta,fechabaja,observaciones";
	
	@Override
	protected Class<Alumno> getClase() {
		return Alumno.class;
	}

	List<Alumno> findAlumnosPatron(String patron) {
		String queryString = "SELECT o From Alumno o Where WHERE LOWER(o.nif) like LOWER('%" + patron
				+ "%') OR LOWER(o.nombre) like LOWER('%" + patron + "%') OR LOWER(o.apellido1) like LOWER('%" + patron
				+ "%')  OR LOWER(o.apellido2) like LOWER('%" + patron + "%') ;";

		Query query = this.entityManager.createQuery(queryString);
		return query.getResultList();
	}
	
	
	private Alumno obtenerAlumno(ResultSet resultado) throws SQLException {

		Long id = resultado.getLong(1);
		String nif = resultado.getString(2);
		String nombre = resultado.getString(3);
		String apellido1 = resultado.getString(4);
		String apellido2 = resultado.getString(5);
		String telefono = resultado.getString(6);
		String correo = resultado.getString(7);
		Boolean repetidor = resultado.getBoolean(8);
		Date fechaAlta = resultado.getDate(9);
		Date fechaBaja = resultado.getDate(10);
		String observaciones = resultado.getString(11);

		Alumno alumno = new Alumno();
		alumno.setId(id);
		alumno.setNif(nif);
		alumno.setNombre(nombre);
		alumno.setApellido1(apellido1);
		alumno.setApellido2(apellido2);
		alumno.setTelefono(telefono);
		alumno.setCorreo(correo);
		//alumno.setFechaAlta(fechaAlta);
		//alumno.setFechaBaja(fechaBaja);
		alumno.setRepetidor(repetidor);
		alumno.setObservaciones(observaciones);

		return alumno;
	}
	
	
	
	/*public List<Alumno> buscarNif2(String nif) throws DaoException {
		
		EntityManager em=null; 
		return em.createQuery(
			        "SELECT c FROM Alumno c WHERE c.nif LIKE :nif")
			        .setParameter("nif", nif)
			        .getResultList();
	 }*/
}
