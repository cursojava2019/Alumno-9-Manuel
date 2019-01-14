package es.indra.ejercicio8;

import java.util.ArrayList;

public class ejercicio8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Profesor p1 = new Profesor("Juan", 26, 'H', "fisica");

		Estudiante e1 = new Estudiante("Yo", 24, 'H', 4);
		Estudiante e2 = new Estudiante("Pepe", 26, 'H', 9);
		Estudiante e3 = new Estudiante("Ali", 21, 'M', 5);

		ArrayList<Estudiante> arr1 = new ArrayList<Estudiante>();
		arr1.add(e1);
		arr1.add(e2);
		arr1.add(e3);

		Aula a1 = new Aula(1, 5, "fisica", p1, arr1);

		System.out.println(a1.darClase());
		a1.notasDeClase();
	}

}
