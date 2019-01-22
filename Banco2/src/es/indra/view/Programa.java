package es.indra.view;

import java.io.IOException;
import java.util.Scanner;

import es.indra.controller.Banco;
import es.indra.model.entities.Clientes;
import es.indra.model.entities.Cuentas;

public class Programa {
	private static Scanner ENTRADA;
	private static Banco banco = null;

	public static void init() throws ClassNotFoundException, IOException {
		ENTRADA = new Scanner(System.in);
		banco = new Banco();
	}

	public static void main(String[] args) {
		try {
			init();
		} catch (ClassNotFoundException | IOException e1) {
			System.out.println("Error al iniciar de disco. Inicializamos el banco");
			banco = new Banco();
		}

		System.out.println("BIENVENIDO AL BANCO");
		int opcion = 0;
		try {
			do {
				System.out.println("Introduzca la operacion que desea realizar");
				System.out.println("1.- Introducir Cliente");
				System.out.println("2.- Crear Cuenta");
				System.out.println("3.- Realizar ingresos en una cuenta de un cliente");
				System.out.println("4.- Sacar dinero de una cuenta de un cliente");
				System.out.println("5.- Forzar revision mensual");
				System.out.println("6.- Estado de la cuenta");
				System.out.println("0.- Salir");
				opcion = ENTRADA.nextInt();
				ENTRADA.nextLine();
				switch (opcion) {
				case 1:
					aniadirCliente();
					break;
				case 2:
					creaCuenta();
					break;
				case 3:
					realizarIngreso();
					break;
				case 4:
					retirarDinero();
					break;
				case 5:
					forzarRevisionMensual();
					break;
				case 6:
					verEstadoCuenta();
					break;
				case 0:
					System.out.println("Fin del Programa");
					break;
				default:
					break;
				}
			} while (opcion != 0);
		} catch (Exception e) {
			System.out.println("Error al guardar en fichero");
			e.printStackTrace();
		}
	}

	public static void aniadirCliente() {
		System.out.println("Introduzca los datos del cliente: ");

		System.out.println("Introduzca DNI: ");
		String dni = ENTRADA.nextLine();
		System.out.println("Introduzca Nombre: ");
		String nombre = ENTRADA.nextLine();
		System.out.println("Introduzca Apellidos: ");
		String apellidos = ENTRADA.nextLine();
		System.out.println("Introduzca Telefono: ");
		String telefono = ENTRADA.nextLine();
		System.out.println("Introduzca Direccion: ");
		String direccion = ENTRADA.nextLine();

		Clientes cliente = new Clientes(dni, nombre, apellidos, direccion, telefono);
		banco.introducirCliente(cliente);
	}

	public static void creaCuenta() {
		System.out.println("Introduzca los datos de la cuenta: ");

		System.out.println("Introduzca numero de cuenta: ");
		String nc = ENTRADA.nextLine();
		System.out.println("Introduzca saldo de la cuenta: ");
		Double saldo = ENTRADA.nextDouble();
		ENTRADA.nextLine();
		System.out.println("Introduzca dni del cliente: ");
		String dni = ENTRADA.nextLine();
		System.out.println("Introduzca tipo de cuenta: ");
		String tipoDeCuenta = ENTRADA.nextLine();

		Cuentas cuenta = new Cuentas(nc, saldo, dni, tipoDeCuenta);
		banco.crearCuenta(cuenta);
	}

	public static void realizarIngreso() {
		System.out.println("Introduzca el numero de la cuenta en la que quiere ingresar: ");
		String codigo = ENTRADA.nextLine();

		Cuentas cu = banco.obtenerCuentas(codigo);
		if (cu == null) {
			System.out.println("No se ha podido encontrar la cuenta");
			return;
		}

		System.out.println("Introduzca DNI del cliente: ");
		String dni = ENTRADA.nextLine();

		Clientes cli = banco.obtenerCliente(dni);

		if (cli == null) {
			System.out.println("No se ha podido encontrar el cliente");
			return;
		}

		System.out.println("Introduzca la cantidad a ingresar: ");
		Double cantidad = ENTRADA.nextDouble();
		ENTRADA.nextLine();
		Cuentas operacion = banco.realizarIngreso(dni, codigo, cantidad);
	}

	public static void retirarDinero() {
		System.out.println("Introduzca el numero de la cuenta de la que quiere retirar: ");
		String codigo = ENTRADA.nextLine();

		Cuentas cu = banco.obtenerCuentas(codigo);
		if (cu == null) {
			System.out.println("No se ha podido encontrar la cuenta");
			return;
		}

		System.out.println("Introduzca DNI del cliente: ");
		String dni = ENTRADA.nextLine();

		Clientes cli = banco.obtenerCliente(dni);

		if (cli == null) {
			System.out.println("No se ha podido encontrar el cliente");
			return;
		}

		System.out.println("Introduzca la cantidad a retirar: ");
		Double cantidad = ENTRADA.nextDouble();
		ENTRADA.nextLine();
		Cuentas operacion = banco.sacarDinero(dni, codigo, cantidad);
	}

	public static void forzarRevisionMensual() {
		System.out.println("Introduzca el numero de la cuenta en la que quiere forzar la revision: ");
		String codigo = ENTRADA.nextLine();

		Cuentas cu = banco.obtenerCuentas(codigo);
		if (cu == null) {
			System.out.println("No se ha podido encontrar la cuenta");
			return;
		}

		System.out.println("Introduzca DNI del cliente: ");
		String dni = ENTRADA.nextLine();

		Clientes cli = banco.obtenerCliente(dni);

		if (cli == null) {
			System.out.println("No se ha podido encontrar el cliente");
			return;
		}

		Cuentas operacion = banco.forzarRevisionMensual(dni, codigo);
	}

	public static void verEstadoCuenta() {
		System.out.println("Introduzca el numero de la cuenta en la que quiere revisar: ");
		String codigo = ENTRADA.nextLine();

		Cuentas cu = banco.obtenerCuentas(codigo);
		if (cu == null) {
			System.out.println("No se ha podido encontrar la cuenta");
			return;
		} else {
			System.out.println(cu.toString());
		}
	}
}
