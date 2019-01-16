package es.indra.model;

import java.io.Serializable;
import java.util.TreeMap;

public class Banco implements Serializable {
	private TreeMap<String, Clientes> clientes;
	private TreeMap<String, Cuentas> cuentas;

	public Banco() {
		super();
		this.clientes = new TreeMap<String, Clientes>();
		this.cuentas = new TreeMap<String, Cuentas>();
	}

	public TreeMap<String, Clientes> getClientes() {
		return this.clientes;
	}

	public void setClientes(TreeMap<String, Clientes> clientes) {
		this.clientes = clientes;
	}

	public TreeMap<String, Cuentas> getCuentas() {
		return this.cuentas;
	}

	public void setCuentas(TreeMap<String, Cuentas> cuentas) {
		this.cuentas = cuentas;
	}

	public Clientes obtenerCliente(String dni) {
		return this.clientes.get(dni);
	}

	public Cuentas obtenerCuentas(String numero) {
		return this.cuentas.get(numero);
	}

	public Boolean introducirCliente(Clientes c) {
		this.clientes.put(c.getDni(), c);
		return true;
	}

	public Boolean crearCuenta(Cuentas c) {
		this.cuentas.put(c.getNumeroDeCuenta(), c);
		return true;
	}

	public Cuentas realizarIngreso(String dni, String codigo, Double cantidad) {
		Clientes cli = this.clientes.get(dni);
		Cuentas cue = this.cuentas.get(codigo);
		if (cli != null && cue != null && cue.getCliente().equals(cli)) {
			cue.ingresarDinero(cantidad);
			return cue;
		} else {
			return null;
		}
	}

	public Cuentas sacarDinero(String dni, String codigo, Double cantidad) {
		Clientes cli = this.clientes.get(dni);
		Cuentas cue = this.cuentas.get(codigo);
		if (cli != null && cue != null && cue.getCliente().equals(cli)) {
			cue.sacarDinero(cantidad);
			return cue;
		} else {
			return null;
		}
	}

	public Cuentas forzarRevisonMensual(String dni, String codigo) {
		Clientes cli = this.clientes.get(dni);
		Cuentas cue = this.cuentas.get(codigo);
		if (cli != null && cue != null && cue.getCliente().equals(cli)) {
			cue.revisionMensual();
			return cue;
		} else {
			return null;
		}
	}
}
