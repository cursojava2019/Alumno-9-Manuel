package es.indra.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.indra.model.entities.Cuentas;
import es.indra.model.support.Dao;
import es.indra.model.support.DaoException;
import es.indra.model.support.DatosConexion;

public class CuentasDao implements Dao<String, Cuentas> {

	private Connection getConexion() throws SQLException {

		Connection co = DriverManager.getConnection(DatosConexion.URL, DatosConexion.USUARIO_BD,
				DatosConexion.PASSWORD_BD);
		return co;
	}

	@Override
	public void create(Cuentas entity) throws DaoException {
		try {
			Connection co = getConexion();
			PreparedStatement ps = co.prepareStatement("INSERT INTO CUENTA VALUES (?,?,?,?,?,?) ");
			ps.setString(1, entity.getNumeroDeCuenta());
			ps.setDouble(2, entity.getSaldo());
			ps.setString(3, entity.getTipoDeCuenta());
			ps.setDouble(4, entity.getComision());
			ps.setDouble(5, entity.getIntereses());
			ps.setString(6, entity.getCliente());
			ps.executeUpdate();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error creando objeto en BBDD");
			throw new DaoException();
		}
	}

	@Override
	public void update(Cuentas entity) throws DaoException {
		try {
			Connection co = getConexion();
			PreparedStatement ps = co.prepareStatement("UPDATE CUENTA SET saldo=? WHERE numerodecuenta=? ");
			ps.setDouble(1, entity.getSaldo());
			ps.setString(2, entity.getNumeroDeCuenta());
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
			PreparedStatement ps = co.prepareStatement("DELETE FROM CUENTA WHERE numerodecuenta=? ");
			ps.setString(1, key);
			ps.executeUpdate();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error borrando objeto en BBDD");
			throw new DaoException();
		}
	}

	@Override
	public Cuentas find(String key) throws DaoException {
		Cuentas cliente = null;
		try {
			Connection co = getConexion();
			String query = "SELECT * FROM CUENTA WHERE numerodecuenta=?";
			PreparedStatement instruccion = co.prepareStatement(query);

			instruccion.setString(1, key);
			ResultSet resultados = instruccion.executeQuery();
			if (resultados.next()) {
				cliente = obtenerCuenta(resultados);
			}
			co.close();
			return cliente;
		} catch (SQLException e) {
			System.out.println("Error al buscar el objeto en BBDD");
			throw new DaoException();
		}
	}

	@Override
	public List<Cuentas> findAll() throws DaoException {
		try {
			Connection co = getConexion();
			Statement instruccion = co.createStatement();

			String query = "SELECT * FROM CUENTA";
			ResultSet resultados = instruccion.executeQuery(query);

			ArrayList<Cuentas> listado = new ArrayList<Cuentas>();

			while (resultados.next()) {

				Cuentas vehiculo = obtenerCuenta(resultados);
				listado.add(vehiculo);
			}

			co.close();
			return listado;
		} catch (SQLException e) {
			System.out.println("Error al buscar en BBDD");
			throw new DaoException();
		}
	}

	private Cuentas obtenerCuenta(ResultSet resultado) throws SQLException {
		String ndc = resultado.getString(1);
		Double saldo = resultado.getDouble(2);
		String tipoCuenta = resultado.getString(3);
		String clienteDni = resultado.getString(6);
		Cuentas cuenta = new Cuentas(ndc, saldo, clienteDni, tipoCuenta);
		return cuenta;
	}
}
