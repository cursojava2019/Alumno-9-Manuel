/**
 * 
 */
package es.indra.ejercicio3;

import java.util.Scanner;

/**
 * @author CursoJAVA
 *
 */
public class Ejercicio3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada=new Scanner(System.in);
		System.out.println("Introduce dia de la semana: ");
		String dia= entrada.nextLine();
		String correción=dia.toLowerCase();
		int ds=diasemana(correción);
		switch (ds) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			System.out.println("Dia Laboral");
			break;
		case 6:
		case 7:
			System.out.println("Dia NO Laboral");
			break;
		default:
			System.out.println("Introduce un dia correcto");
			break;
		}
		entrada.close();
	}
	
	public static int diasemana(String dia) {
		int num=0;
		
		if(dia.equals("lunes")) {
			num=1;
		}
		else if(dia.equals("martes")) {
			num=2;
		}
		else if(dia.equals("miercoles")) {
			num=3;
		}
		else if(dia.equals("jueves")) {
			num=4;
		}
		else if(dia.equals("viernes")) {
			num=5;
		}
		else if(dia.equals("sabado")) {
			num=6;
		}
		else if(dia.equals("domingo")) {
			num=7;
		}
		else {
			num=0;
		}
		return num;
	}

}
