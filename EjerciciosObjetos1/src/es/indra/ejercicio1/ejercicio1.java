/**
 *
 */
package es.indra.ejercicio1;

import java.util.Scanner;

/**
 * @author CursoJAVA
 *
 */
public class ejercicio1 {
	private static Scanner entrada;
	private static Cuenta cuenta;

	public static void inicializar() {
		entrada = new Scanner(System.in);
		cuenta = null;
	}

	public static void main(String[] args) {
		inicializar();
		int opcion = 0;
		do {
			System.out.flush();
			System.out.println("Introduzca la operacion que desea realizar");
			System.out.println("1.- Inicializar Cuenta");
			System.out.println("2.- Añadir saldo a la Cuenta");
			System.out.println("3.- Retirar saldo a la Cuenta");
			System.out.println("0.- Salir");
			opcion = entrada.nextInt();
			entrada.nextLine();
			switch (opcion) {
			case 1:
				inicializarCuenta();
				break;
			case 2:
				aniadirSaldo();
				break;
			case 3:
				retirarSaldo();
				break;
			case 0:
				System.out.println("Fin del Programa");
				break;
			default:
				break;
			}
		} while (opcion != 0);
	}

	private static void retirarSaldo() {
		if (cuenta != null) {
			System.out.println("Introduzca el saldo que desea retirar");
			Double saldo = entrada.nextDouble();
			cuenta.retirar(saldo);
			System.out.println("El resultado de la operación es:" + cuenta.toString());
		} else {
			System.out.println("Debe crear una cuenta primero para realizar esta operacion");
		}
	}

	private static void aniadirSaldo() {
		if (cuenta != null) {
			System.out.println("Introduzca el saldo que desea añadir");
			Double saldo = entrada.nextDouble();
			cuenta.ingresar(saldo);
			System.out.println("El resultado de la operación es:" + cuenta.toString());
		} else {
			System.out.println("Debe crear una cuenta primero para realizar esta operacion");
		}
	}

	private static void inicializarCuenta() {
		// TODO Auto-generated method stub
		System.out.println("Introduzca el nombre del titular");
		String titular = entrada.nextLine();
		System.out.println("Introduzca el saldo");
		Double saldo = entrada.nextDouble();
		cuenta = new Cuenta(titular, saldo);
		System.out.println("El resultado de la operación es:" + cuenta.toString());
	}

}
