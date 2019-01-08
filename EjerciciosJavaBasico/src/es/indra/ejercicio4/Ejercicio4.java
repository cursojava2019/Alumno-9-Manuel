/**
 * 
 */
package es.indra.ejercicio4;

import java.util.Scanner;

/**
 * @author CursoJAVA
 *
 */
public class Ejercicio4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada=new Scanner(System.in);
		System.out.println("Introduce un numero positivo: ");
		int num= entrada.nextInt();
		if(num>0) {
			int digitos=Integer.toString(num).length();
			if(digitos==1) {
				System.out.println("El numero solo tiene "+digitos+" digito");
			}
			else {
				System.out.println("El numero tiene "+digitos+" digitos");
			}
		}
		else {
			System.out.println("Debes Introducir un numero positivo");
		}

		entrada.close();
	}

}
