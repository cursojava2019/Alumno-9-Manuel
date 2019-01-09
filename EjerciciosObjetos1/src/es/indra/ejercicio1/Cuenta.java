package es.indra.ejercicio1;

public class Cuenta {
	protected String titular;
	protected Double cantidad;

	public Cuenta(String titular) {
		super();
		this.titular = titular;
		this.cantidad = Double.valueOf(0);
	}

	public Cuenta(String titular, Double cantidad) {
		super();
		this.titular = titular;
		this.cantidad = cantidad;
	}

	public String getTitular() {
		return this.titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Cuenta [titular=" + this.titular + ", cantidad=" + this.cantidad + "]";
	}

	public void ingresar(Double cantidadSuma) {
		if (cantidadSuma >= 0) {
			this.cantidad += cantidadSuma;
		}
	}

	public void retirar(Double cantidadResta) {
		this.cantidad -= cantidadResta;
		if (this.cantidad <= 0) {
			this.cantidad = Double.valueOf(0);
		}
	}

}
