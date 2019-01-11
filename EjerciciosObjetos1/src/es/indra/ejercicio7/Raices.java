package es.indra.ejercicio7;

public class Raices {
	protected Double a;
	protected Double b;
	protected Double c;

	public Raices(Double a, Double b, Double c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public void obtenerRaices() {

	}

	public void obtenerRaiz() {

	}

	public Double getDiscriminante() {
		Double discriminante = (double) 0;
		discriminante = (Math.pow(this.b, 2) - 4 * this.a * this.c);
		return discriminante;
	}

}
