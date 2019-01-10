/**
 *
 */
package es.indra.ejercicio2;

import java.util.Scanner;

/**
 * @author CursoJAVA
 *
 */
public class ejercicio2 {

	private static Scanner ENTRADA;

	public static void inicializar() {
		ENTRADA = new Scanner(System.in);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		inicializar();
		System.out.println("Introduce un nombre: ");
		String nombre = ENTRADA.nextLine();
		System.out.println("Introduce una edad: ");
		Integer edad = ENTRADA.nextInt();
		System.out.println("Introduce un sexo: ");
		Character sexo = ENTRADA.next().charAt(0);
		System.out.println("Introduce un peso: ");
		Float peso = ENTRADA.nextFloat();
		System.out.println("Introduce una altura: ");
		Float altura = ENTRADA.nextFloat();

		Persona p1 = new Persona(nombre, edad, sexo, peso, altura);
		Persona p2 = new Persona(nombre, edad, sexo);
		Persona p3 = new Persona();

		p3.setNombre("yo");
		p3.setEdad(20);
		p3.setSexo('H');
		p3.setPeso((float) 60);
		p3.setAltura((float) 160);

		System.out.println("El peso de la persona 1 es: " + p1.calcularIMC());
		System.out.println("El peso de la persona 2 es: " + p2.calcularIMC());
		System.out.println("El peso de la persona 3 es: " + p3.calcularIMC());

		System.out.println("¿Persona 1 es mayor de edad?: " + p1.esMayorDeEdad());
		System.out.println("¿Persona 2 es mayor de edad?: " + p2.esMayorDeEdad());
		System.out.println("¿Persona 3 es mayor de edad?: " + p3.esMayorDeEdad());

		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p3.toString());
	}

}
