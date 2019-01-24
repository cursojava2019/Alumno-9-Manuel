package es.indra.academia.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.indra.academia.configuration.Configuracion;
import es.indra.academia.model.entities.Alumno;
import es.indra.academia.model.support.Dao;
import es.indra.academia.model.support.DaoException;

public class AlumnoDao implements Dao<Long, Alumno> {

	@Override
	public void create(Alumno entity) throws DaoException {

//		try {
//			Connection conexion = Configuracion.getInstance().obtenerConexionBD();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	@Override
	public void update(Alumno entity) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long key) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public Alumno find(Long key) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alumno> findAll() throws DaoException {
		try {
			Connection co = Configuracion.getInstance().obtenerConexionBD();
			Statement instruccion = co.createStatement();

			String query = "SELECT id,nif,nombre,apellido1,apellido2,telefono,correo,repetidor,fechaalta,fechabaja,observaciones FROM ALUMNO";
			ResultSet resultados = instruccion.executeQuery(query);

			ArrayList<Alumno> listado = new ArrayList<Alumno>();

			while (resultados.next()) {

				Alumno alumno = obtenerAlumno(resultados);

				listado.add(alumno);
			}

			co.close();
			return listado;
		} catch (Exception e) {
			System.out.println("Error creando objeto en BBDD");
			e.printStackTrace();
			throw new DaoException();
		}
	}

	private Alumno obtenerAlumno(ResultSet resultado) throws SQLException {

		Long id = resultado.getLong(1);
		String nif = resultado.getString(2);
		String nombre = resultado.getString(3);
		String apellido1 = resultado.getString(4);
		String apellido2 = resultado.getString(5);
		String telefono = resultado.getString(6);

		Alumno alumno = new Alumno();
		alumno.setId(id);
		alumno.setNif(nif);
		alumno.setNombre(nombre);
		alumno.setApellido1(apellido1);
		alumno.setApellido2(apellido2);
		alumno.setTelefono(telefono);
		return alumno;
	}

}
