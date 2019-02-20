package es.indra.academia.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import es.indra.academia.configuration.Configuracion;
import es.indra.academia.model.entities.Profesor;
import es.indra.academia.model.support.DaoException;
import es.indra.academia.model.support.jpa.AbstracJpaDao;

@Repository
public class ProfesorJpaDao extends AbstracJpaDao<Long, Profesor> {

	private static final String CAMPOS = "nif,nombre,apellido1,apellido2,telefono,correo,titulacion";
	
	@Override
	protected Class<Profesor> getClase() {
		return Profesor.class;
	}

	List<Profesor> findAlumnosPatron(String patron) {
		String queryString = "SELECT o From Profesor o Where WHERE LOWER(o.nif) like LOWER('%" + patron
				+ "%') OR LOWER(o.nombre) like LOWER('%" + patron + "%') OR LOWER(o.apellido1) like LOWER('%" + patron
				+ "%')  OR LOWER(o.apellido2) like LOWER('%" + patron + "%') ;";

		Query query = this.entityManager.createQuery(queryString);
		return query.getResultList();
	}
	
	
	private Profesor obtenerProfesor(ResultSet resultado) throws SQLException {

		Long id = resultado.getLong(1);
		String nif = resultado.getString(2);
		String nombre = resultado.getString(3);
		String apellido1 = resultado.getString(4);
		String apellido2 = resultado.getString(5);
		String telefono = resultado.getString(6);
		String correo = resultado.getString(7);
		String titulacion = resultado.getString(8);

		Profesor profesor = new Profesor();
		profesor.setId(id);
		profesor.setNif(nif);
		profesor.setNombre(nombre);
		profesor.setApellido1(apellido1);
		profesor.setApellido2(apellido2);
		profesor.setTelefono(telefono);
		profesor.setCorreo(correo);
		profesor.setTitulacion(titulacion);

		return profesor;
	}
	
	public List<Profesor> buscarNif(String nif) throws DaoException {

		Profesor profesor = null;
		try {
			Connection co = Configuracion.getInstance().obtenerConexionBD();
			String query = "SELECT id," + CAMPOS + " FROM PROFESOR WHERE nif=?";
			PreparedStatement instruccion = co.prepareStatement(query);

			instruccion.setString(1, nif);
			ResultSet resultados = instruccion.executeQuery();
			ArrayList<Profesor> listado = new ArrayList<Profesor>();
			if (resultados.next()) {
				profesor = obtenerProfesor(resultados);
				listado.add(profesor);
			}
			co.close();
			return listado;
		} catch (SQLException e) {
			System.out.println("Error creando objeto en BBDD");
			e.printStackTrace();
			throw new DaoException();
		}
	}
	

}
