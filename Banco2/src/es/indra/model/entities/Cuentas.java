package es.indra.model.entities;

import java.io.Serializable;

public class Cuentas implements Serializable {
	public static Double COMISION_DEFECTO = 0.6;
	public static Double INTERES_CUENTA_CORRIENTE = 0.1;
	public static Double INTERES_CUENTA_VIVIENDA = 0.2;
	public static Double INTERES_FONDO_INVERSION = 0.34;

	private String numeroDeCuenta;
	private Double saldo;
	private String cliente;
	private String tipoDeCuenta;
	private Double comision;
	private Double intereses;

	public Cuentas(String numeroDeCuenta, Double saldo, String cliente, String tipoDeCuenta) {
		super();
		setNumeroDeCuenta(numeroDeCuenta);
		this.saldo = saldo;
		this.cliente = cliente;
		this.tipoDeCuenta = tDecuenta(tipoDeCuenta);
		this.comision = COMISION_DEFECTO;
		this.intereses = interes(tipoDeCuenta);
	}

	public Cuentas() {
		super();
	}

	public String tDecuenta(String tcuenta) {
		String tc = null;
		if (tcuenta.equalsIgnoreCase("CC") || tcuenta.equalsIgnoreCase("CuentaCorriente")) {
			tc = "CC";
			return tc;
		} else if (tcuenta.equalsIgnoreCase("CV") || tcuenta.equalsIgnoreCase("CuentaVivienda")) {
			tc = "CV";
			return tc;
		} else if (tcuenta.equalsIgnoreCase("FI") || tcuenta.equalsIgnoreCase("FondoInversion")) {
			tc = "FI";
			return tc;
		} else {
			tc = "CC";
			return tc;
		}
	}

	public Double interes(String tcuenta) {
		Double i = 0.0;
		if (tcuenta.equalsIgnoreCase("CC")) {
			i = INTERES_CUENTA_CORRIENTE;
			return i;
		} else if (tcuenta.equalsIgnoreCase("CV")) {
			i = INTERES_CUENTA_VIVIENDA;
			return i;
		} else {
			i = INTERES_FONDO_INVERSION;
			return i;
		}
	}

	public Double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String getCliente() {
		return this.cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getTipoDeCuenta() {
		return this.tipoDeCuenta;
	}

	public void setTipoDeCuenta(String tipoDeCuenta) {
		this.tipoDeCuenta = tDecuenta(tipoDeCuenta);
	}

	public Double getComision() {
		return this.comision;
	}

	public void setComision(Double comision) {
		this.comision = comision;
	}

	public String getNumeroDeCuenta() {
		return this.numeroDeCuenta;
	}

	public void setNumeroDeCuenta(String numeroDeCuenta) {
		this.numeroDeCuenta = numeroDeCuenta;
	}

	public double ingresarDinero(Double cantidad) {
		Double s = getSaldo() + cantidad;
		setSaldo(s);
		System.out.println("El saldo actual de la cuenta tras el ingreso es: " + getSaldo());
		return s;
	}

	public Double getIntereses() {
		return this.intereses;
	}

	public void setIntereses(Double intereses) {
		this.intereses = intereses;
	}

	public Double sacarDinero(Double cantidad) {
		Double s = getSaldo() - cantidad;
		if (getTipoDeCuenta().equalsIgnoreCase("CV")) {
			System.out.println("No se puede retirar esa cantidad de dinero de esta cuenta");
		} else if (getTipoDeCuenta().equalsIgnoreCase("CC") && cantidad > getSaldo()) {
			System.out.println("No se puede retirar esa cantidad de dinero de esta cuenta");
		} else if (getTipoDeCuenta().equalsIgnoreCase("FI") && s < -500.0) {
			System.out.println("No se puede retirar esa cantidad de dinero de esta cuenta");
		} else {
			setSaldo(s);
		}

		System.out.println("El saldo actual de la cuenta tras la retirada es: " + getSaldo());
		return s;
	}

	public Double revisionMensual() {
		Double s = 0.0;
		s = getSaldo() + this.intereses - this.comision;
		setSaldo(s);
		System.out.println("La revision mensual da: " + s + " €");
		return s;
	}

	@Override
	public String toString() {
		return "Cuentas [numeroDeCuenta=" + this.numeroDeCuenta + ", saldo=" + this.saldo + ", cliente=" + this.cliente
				+ ", tipoDeCuenta=" + this.tipoDeCuenta + ", comision=" + this.comision + ", intereses="
				+ this.intereses + "]";
	}
}
