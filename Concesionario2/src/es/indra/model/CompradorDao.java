package es.indra.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.indra.model.entities.Comprador;
import es.indra.model.support.Dao;
import es.indra.model.support.DaoException;
import es.indra.model.support.DatosConexion;

public class CompradorDao implements Dao<String, Comprador> {

	private Connection getConexion() throws SQLException {

		Connection co = DriverManager.getConnection(DatosConexion.URL, DatosConexion.USUARIO_BD,
				DatosConexion.PASSWORD_BD);
		return co;
	}

	@Override
	public void create(Comprador entity) throws DaoException {
		try {
			Connection co = getConexion();
			PreparedStatement ps = co.prepareStatement("INSERT INTO COMPRADOR VALUES (?,?,?,?,?) ");
			ps.setString(1, entity.getDni());
			ps.setString(2, entity.getNombre());
			ps.setString(3, entity.getApellidos());
			ps.setString(4, entity.getTelefono());
			ps.setString(5, entity.getDireccion());
			ps.executeUpdate();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error creando objeto en BBDD");
			throw new DaoException();
		}

	}

	@Override
	public void update(Comprador entity) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String key) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public Comprador find(String key) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comprador> findAll() throws DaoException {
		try {
			Connection co = getConexion();
			Statement instruccion = co.createStatement();

			String query = "SELECT * FROM COMPRADOR";
			ResultSet resultados = instruccion.executeQuery(query);

			ArrayList<Comprador> listado = new ArrayList<Comprador>();

			while (resultados.next()) {
				String nif = resultados.getString(1);
				String nombre = resultados.getString(2);
				String apellidos = resultados.getString(3);
				String telefono = resultados.getString(4);
				String direccion = resultados.getString(5);

				Comprador comprador = new Comprador(nif, nombre, apellidos, telefono, direccion, "");
				listado.add(comprador);
			}

			co.close();
			return listado;
		} catch (SQLException e) {
			System.out.println("Error creando objeto en BBDD");
			throw new DaoException();
		}
	}

}
