/**
 *
 */
package es.indra.ejercicio3;

import java.util.Scanner;

/**
 * @author CursoJAVA
 *
 */
public class ejercicio3 {
	private static Scanner ENTRADA;

	public static void inicializar() {
		ENTRADA = new Scanner(System.in);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		inicializar();

		System.out.println("Introduce longitud del array de passwords: ");
		Integer l = ENTRADA.nextInt();
		System.out.println("Introduce longitud de las passwords: ");
		Integer lp = ENTRADA.nextInt();
		Password[] array1 = new Password[l];
		Boolean[] arrdebool = new Boolean[l];
		for (int i = 0; i < l; i++) {
			array1[i] = new Password(lp);
			arrdebool[i] = array1[i].esFuerte();
			System.out.println("Contraseña:" + array1[i].getContraseña() + " Valor Booleano: " + arrdebool[i]);
		}
	}

}
