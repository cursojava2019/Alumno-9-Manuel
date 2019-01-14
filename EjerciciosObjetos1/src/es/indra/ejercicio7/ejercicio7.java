package es.indra.ejercicio7;

public class ejercicio7 {

	public static void main(String[] args) {
		Raices r1 = new Raices(3.0, -5.0, 1.0);
		System.out.println(r1.getDiscriminante());

		System.out.println(r1.tieneRaices());
		System.out.println(r1.tieneRaiz());

		r1.calcular();
	}

}
