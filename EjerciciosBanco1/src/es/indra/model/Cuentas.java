package es.indra.model;

public class Cuentas {
	private Double saldo;
	private Clientes cliente;
	private String tipoDeCuenta;

	public Cuentas(Double saldo, Clientes cliente, String tipoDeCuenta) {
		super();
		this.saldo = saldo;
		this.cliente = cliente;
		this.tipoDeCuenta = tipoDeCuenta;
	}

	public Cuentas() {
		super();
	}

}
