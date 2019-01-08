/**
 * 
 */
package es.indra.ejercicio1;

import java.util.Scanner;

/**
 * @author CursoJAVA
 *
 */
public class Ejercicio1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduzca un numero para ver si es divisible por 2: ");
		int leido=entrada.nextInt();
		if(leido%2==0) {
			System.out.println("El numero leido "+leido+" es divisible por 2");	
		}
		else {
			System.out.println("El numero leido "+leido+" NO es divisible por 2");
		}
		entrada.close();
	}

}
