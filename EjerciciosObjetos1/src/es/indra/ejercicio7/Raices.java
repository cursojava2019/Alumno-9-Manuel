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
		Double resultado1 = Math.sqrt(getDiscriminante());
		Double resultado2 = Math.sqrt(getDiscriminante());

		System.out.println("El resultado de la primera raiz es: " + resultado1);
		System.out.println("El resultado de la segunda raiz es: " + resultado2);
	}

	public void obtenerRaiz() {
		Double resultado = Math.sqrt(getDiscriminante());

		System.out.println("El resultado de la raiz es: " + resultado);
	}

	public Double getDiscriminante() {
		Double discriminante = (double) 0;
		discriminante = ((Math.pow(this.b, 2)) - 4 * this.a * this.c);
		return discriminante;
	}

	public Boolean tieneRaices() {
		Boolean tieneRaiz = null;
		if (getDiscriminante() >= 0) {
			tieneRaiz = true;
		} else {
			tieneRaiz = false;
		}
		return tieneRaiz;
	}

	public Boolean tieneRaiz() {
		Boolean tieneRaiz = null;
		if (getDiscriminante() == 0) {
			tieneRaiz = true;
		} else {
			tieneRaiz = false;
		}
		return tieneRaiz;
	}

	public void calcular() {
		Double resultado1 = (-this.b + Math.sqrt(getDiscriminante())) / (2 * this.a);
		Double resultado2 = (-this.b - Math.sqrt(getDiscriminante())) / (2 * this.a);
		;

		System.out.println("El primer resultado es: " + resultado1);
		System.out.println("El segunda resultado es: " + resultado2);
	}
}
