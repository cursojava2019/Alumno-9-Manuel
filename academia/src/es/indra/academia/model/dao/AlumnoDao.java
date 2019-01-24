package es.indra.academia.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import es.indra.academia.configuration.Configuracion;
import es.indra.academia.model.entities.Alumno;
import es.indra.academia.model.support.Dao;
import es.indra.academia.model.support.DaoException;

public class AlumnoDao implements Dao<Long, Alumno> {

	@Override
	public void create(Alumno entity) throws DaoException {

		try {
			Connection conexion = Configuracion.getInstance().obtenerConexionBD();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
		// TODO Auto-generated method stub
		return null;
	}

}
