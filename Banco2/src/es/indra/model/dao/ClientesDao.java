package es.indra.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.indra.model.entities.Clientes;
import es.indra.model.support.Dao;
import es.indra.model.support.DaoException;
import es.indra.model.support.DatosConexion;

public class ClientesDao implements Dao<String, Clientes> {

	private Connection getConexion() throws SQLException {

		Connection co = DriverManager.getConnection(DatosConexion.URL, DatosConexion.USUARIO_BD,
				DatosConexion.PASSWORD_BD);
		return co;
	}

	@Override
	public void create(Clientes entity) throws DaoException {
		try {
			Connection co = getConexion();
			PreparedStatement ps = co.prepareStatement("INSERT INTO CLIENTE VALUES (?,?,?,?,?) ");
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
	public void update(Clientes entity) throws DaoException {
		try {
			Connection co = getConexion();
			PreparedStatement ps = co
					.prepareStatement("UPDATE CLIENTE SET nombre=?,apellidos=?,telefono=?,direccion=? WHERE dni=? ");
			ps.setString(5, entity.getDni());
			ps.setString(1, entity.getNombre());
			ps.setString(2, entity.getApellidos());
			ps.setString(3, entity.getTelefono());
			ps.setString(4, entity.getDireccion());
			ps.executeUpdate();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error actualizando objeto en BBDD");
			throw new DaoException();
		}
	}

	@Override
	public void delete(String key) throws DaoException {
		try {
			Connection co = getConexion();
			PreparedStatement ps = co.prepareStatement("DELETE FROM CLIENTE WHERE dni=? ");
			ps.setString(1, key);
			ps.executeUpdate();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error borrando objeto en BBDD");
			throw new DaoException();
		}
	}

	@Override
	public Clientes find(String key) throws DaoException {
		Clientes cliente = null;
		try {
			Connection co = getConexion();
			String query = "SELECT * FROM CLIENTE WHERE dni=?";
			PreparedStatement instruccion = co.prepareStatement(query);

			instruccion.setString(1, key);
			ResultSet resultados = instruccion.executeQuery();
			if (resultados.next()) {
				cliente = obtenerCliente(resultados);
			}
			co.close();
			return cliente;
		} catch (SQLException e) {
			System.out.println("Error al buscar el objeto en BBDD");
			throw new DaoException();
		}
	}

	@Override
	public List<Clientes> findAll() throws DaoException {
		try {
			Connection co = getConexion();
			Statement instruccion = co.createStatement();

			String query = "SELECT * FROM CLIENTE";
			ResultSet resultados = instruccion.executeQuery(query);

			ArrayList<Clientes> listado = new ArrayList<Clientes>();

			while (resultados.next()) {

				Clientes vehiculo = obtenerCliente(resultados);
				listado.add(vehiculo);
			}

			co.close();
			return listado;
		} catch (SQLException e) {
			System.out.println("Error al buscar en BBDD");
			throw new DaoException();
		}
	}

	private Clientes obtenerCliente(ResultSet resultado) throws SQLException {
		String nif = resultado.getString(1);
		String nombre = resultado.getString(2);
		String apellidos = resultado.getString(3);
		String telefono = resultado.getString(4);
		String direccion = resultado.getString(5);
		Clientes comprador = new Clientes(nif, nombre, apellidos, telefono, direccion);
		return comprador;
	}
}
