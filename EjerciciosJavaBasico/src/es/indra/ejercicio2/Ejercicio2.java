/**
 * 
 */
package es.indra.ejercicio2;

import java.util.Scanner;

/**
 * @author CursoJAVA
 *
 */
public class Ejercicio2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduzca un primer numero: ");
		int primero=entrada.nextInt();
		System.out.println("Introduzca un segundo numero: ");
		int segundo=entrada.nextInt();
		System.out.println("Empezamos en el numero "+primero);
		for(int i=primero+1;i<segundo;i++) {
			System.out.println("siguiente numero "+i);
		}
		System.out.println("Acabamos en el numero "+segundo);
		entrada.close();
	}

}
