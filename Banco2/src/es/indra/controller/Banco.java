package es.indra.controller;

import java.io.Serializable;
import java.util.TreeMap;

import es.indra.model.entities.Clientes;
import es.indra.model.entities.Cuentas;
import es.indra.model.service.ClienteService;
import es.indra.model.service.CuentasService;

public class Banco implements Serializable {
	ClienteService clienteService;
	CuentasService cuentaService;
	private TreeMap<String, Clientes> clientes;
	private TreeMap<String, Cuentas> cuentas;

	public Banco() {
		super();
		this.clientes = new TreeMap<String, Clientes>();
		this.cuentas = new TreeMap<String, Cuentas>();
		this.clienteService = new ClienteService();
		this.cuentaService = new CuentasService();
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
		return this.clienteService.find(dni);
	}

	public Cuentas obtenerCuentas(String numero) {
		return this.cuentaService.find(numero);
	}

	public Boolean introducirCliente(Clientes c) {
		this.clienteService.create(c);
		System.out.println("Cliente creado satisfactoriamente");
		return true;
	}

	public Boolean crearCuenta(Cuentas c) {
		this.cuentaService.create(c);
		System.out.println("Cuenta creada satisfactoriamente");
		return true;
	}

	public Boolean borrarCliente(String dni) {
		this.clienteService.delete(dni);
		System.out.println("Cliente borrado satisfactoriamente");
		return true;
	}

	public Boolean borrarCuenta(String codigo) {
		this.cuentaService.delete(codigo);
		System.out.println("Cuenta borrada satisfactoriamente");
		return true;
	}

	public Cuentas realizarIngreso(String dni, String codigo, Double cantidad) {
		Clientes cli = this.clienteService.find(dni);
		Cuentas cue = this.cuentaService.find(codigo);
		if (cli != null && cue != null && cue.getCliente().equals(cli.getDni())) {
			cue.ingresarDinero(cantidad);
			this.cuentaService.update(cue);
			return cue;
		} else {
			System.out.println("La cuenta no pertenece a ese cliente o una de las dos es erronea");
			return null;
		}
	}

	public Cuentas sacarDinero(String dni, String codigo, Double cantidad) {
		Clientes cli = this.clienteService.find(dni);
		Cuentas cue = this.cuentaService.find(codigo);
		if (cli != null && cue != null && cue.getCliente().equals(cli.getDni())) {
			cue.sacarDinero(cantidad);
			this.cuentaService.update(cue);
			return cue;
		} else {
			System.out.println("La cuenta no pertenece a ese cliente o una de las dos es erronea");
			return null;
		}
	}

	public Cuentas forzarRevisionMensual(String dni, String codigo) {
		Clientes cli = this.clienteService.find(dni);
		Cuentas cue = this.cuentaService.find(codigo);
		if (cli != null && cue != null && cue.getCliente().equals(cli.getDni())) {
			cue.revisionMensual();
			this.cuentaService.update(cue);
			return cue;
		} else {
			System.out.println("La cuenta no pertenece a ese cliente o una de las dos es erronea");
			return null;
		}
	}
}
