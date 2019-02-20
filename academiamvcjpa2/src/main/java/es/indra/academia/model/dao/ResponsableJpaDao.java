package es.indra.academia.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import es.indra.academia.configuration.Configuracion;
import es.indra.academia.model.entities.Alumno;
import es.indra.academia.model.entities.ResponsableAlumno;
import es.indra.academia.model.support.DaoException;
import es.indra.academia.model.support.jpa.AbstracJpaDao;

@Repository
public class ResponsableJpaDao extends AbstracJpaDao<Long, ResponsableAlumno> {

	private static final String CAMPOS = "nif,nombre,apellido1,apellido2,telefono,correo";
	
	@Override
	protected Class<ResponsableAlumno> getClase() {
		return ResponsableAlumno.class;
	}

	public List<ResponsableAlumno> findResponsableAlumnosPatron(String patron) {
		String queryString = "SELECT o From responsable_alumno o Where WHERE LOWER(o.nif) like LOWER('%" + patron
				+ "%') OR LOWER(o.nombre) like LOWER('%" + patron + "%') OR LOWER(o.apellido1) like LOWER('%" + patron
				+ "%')  OR LOWER(o.apellido2) like LOWER('%" + patron + "%') ;";

		Query query = this.entityManager.createQuery(queryString);
		return query.getResultList();
	}
	
	
	private ResponsableAlumno obtenerResponsableAlumno(ResultSet resultado) throws SQLException {

		Long id = resultado.getLong(1);
		String nif = resultado.getString(2);
		String nombre = resultado.getString(3);
		String apellido1 = resultado.getString(4);
		String apellido2 = resultado.getString(5);
		String telefono = resultado.getString(6);
		String correo = resultado.getString(7);
		
		

		ResponsableAlumno responsablealumno = new ResponsableAlumno();
		responsablealumno.setId(id);
		responsablealumno.setNif(nif);
		responsablealumno.setNombre(nombre);
		responsablealumno.setApellido1(apellido1);
		responsablealumno.setApellido2(apellido2);
		responsablealumno.setTelefono(telefono);
		responsablealumno.setCorreo(correo);

		return responsablealumno;
	}
	
	public List<ResponsableAlumno> buscarNif(String nif) throws DaoException {

		ResponsableAlumno responsablealumno = null;
		try {
			Connection co = Configuracion.getInstance().obtenerConexionBD();
			String query = "SELECT id," + CAMPOS + " FROM responsable_alumno WHERE nif=?";
			PreparedStatement instruccion = co.prepareStatement(query);

			instruccion.setString(1, nif);
			ResultSet resultados = instruccion.executeQuery();
			ArrayList<ResponsableAlumno> listado = new ArrayList<ResponsableAlumno>();
			if (resultados.next()) {
				responsablealumno = obtenerResponsableAlumno(resultados);
				listado.add(responsablealumno);
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
