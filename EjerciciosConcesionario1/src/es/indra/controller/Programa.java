package es.indra.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import es.indra.model.Comprador;
import es.indra.model.Concesionario;
import es.indra.model.Vehiculo;
import es.indra.model.Venta;

public class Programa {
	private static Scanner ENTRADA;
	public static final String FICHERO_VENTA = "ventas.txt";
	public static final String NOMBRE_FICHERO_CONCESIONARIO = "concesionario.dat";
	private static Concesionario concesionario = null;

	public static void init() throws ClassNotFoundException, IOException {
		ENTRADA = new Scanner(System.in);
		File file = new File(NOMBRE_FICHERO_CONCESIONARIO);
		try {
			FileInputStream fileInput = new FileInputStream(file);
			ObjectInputStream objectInput = new ObjectInputStream(fileInput);
			concesionario = (Concesionario) objectInput.readObject();
			objectInput.close();
		} catch (FileNotFoundException e) {
			concesionario = new Concesionario();
			System.out.println("El concesionario se inicializa desde cero al no encontrar fichero");
		}

	}

	public static void fin() throws IOException {
		File file = new File(NOMBRE_FICHERO_CONCESIONARIO);
		file.delete();
		file.createNewFile();
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(file);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(concesionario);
			objectOut.flush();
			objectOut.close();
		} catch (IOException e) {
			System.out.println("Error al guardar en disco,todo se ha perdido");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			init();
		} catch (ClassNotFoundException | IOException e1) {
			System.out.println("Error al iniciar de disco. Inicializamos el concesionario");
			concesionario = new Concesionario();
		}

		System.out.println("BIENVENIDO AL CONCESIONARIO");
		int opcion = 0;
		try {
			do {
				System.out.println("Introduzca la operacion que desea realizar");
				System.out.println("1.- Añadir Propietario");
				System.out.println("2.- Añadir Vehiculo");
				System.out.println("3.- Lista Vehiculos disponibles");
				System.out.println("4.- Lista Vehiculos por propietario");
				System.out.println("5.- Introducir Venta");
				System.out.println("0.- Salir");
				opcion = ENTRADA.nextInt();
				ENTRADA.nextLine();
				switch (opcion) {
				case 1:
					aniadirPropietario();
					fin();
					break;
				case 2:
					aniadirVehiculo();
					fin();
					break;
				case 3:
					listarVehiculosDisponibles();
					break;
				case 4:
					listarVehiculosPropietario();
					break;
				case 5:
					crearVenta();
					fin();
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

		try {
			fin();
		} catch (IOException e) {
			System.out.println("NO SE HA PODIDO GUARDAR");
			e.printStackTrace();
		}

	}

	public static void aniadirPropietario() {
		System.out.println("Introduzca los datos del propietario: ");

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
		System.out.println("Introduzca Codigo Postal: ");
		String cp = ENTRADA.nextLine();

		Comprador comprador = new Comprador(dni, nombre, apellidos, telefono, direccion, cp);
		concesionario.aniadirComprador(comprador);
	}

	public static void aniadirVehiculo() {
		System.out.println("Introduzca los datos del vehiculo: ");

		System.out.println("Introduzca Codigo: ");
		Long codigo = ENTRADA.nextLong();
		ENTRADA.nextLine();
		System.out.println("Introduzca año: ");
		Integer anio = ENTRADA.nextInt();
		ENTRADA.nextLine();
		System.out.println("Introduzca Kilometros: ");
		Integer km = ENTRADA.nextInt();
		ENTRADA.nextLine();
		System.out.println("Introduzca Marca: ");
		String marca = ENTRADA.nextLine();
		System.out.println("Introduzca tipo: ");
		String tipo = ENTRADA.nextLine();

		Vehiculo v = new Vehiculo(codigo, marca, tipo, anio, km, false);
		concesionario.aniadirVehiculo(v);
		System.out.println("Vehiculo añadidio correctamente");

	}

	public static void listarVehiculosDisponibles() {
		System.out.println("Listado de Vehiculos");
		List<Vehiculo> listado = concesionario.vehiculosDisponibles();
		for (Vehiculo vehiculo : listado) {
			System.out.println(vehiculo);
		}
	}

	public static void listarVehiculosPropietario() {
		System.out.println("Listado de Propietarios");

		System.out.println("Introduzca DNI del propietario: ");
		String dni = ENTRADA.nextLine();

		Comprador c = concesionario.obtenerComprador(dni);
		if (c != null) {
			List<Vehiculo> listado = concesionario.vehiculosPropietarios(dni);
			for (Vehiculo vehiculo : listado) {
				System.out.println(vehiculo);
			}
		}
	}

	public static void crearVenta() {
		System.out.println("Introduzca Codigo del coche a vender: ");
		Long codigo = ENTRADA.nextLong();
		ENTRADA.nextLine();

		Vehiculo v = concesionario.obtenerVehiculo(codigo);
		if (v == null) {
			System.out.println("No se ha podido encontrar el vehiculo");
			return;
		}

		System.out.println("Introduzca DNI del comprador: ");
		String dni = ENTRADA.nextLine();

		Comprador c = concesionario.obtenerComprador(dni);

		if (c == null) {
			System.out.println("No se ha podido encontrar el comprador");
			return;
		}

		System.out.println("Introduzca PVP de venta: ");
		Double precio = ENTRADA.nextDouble();
		ENTRADA.nextLine();
		Venta venta = concesionario.nuevaVenta(dni, codigo, precio);

		if (venta != null) {
			File file = new File(FICHERO_VENTA);
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			PrintWriter salida;
			try {
				salida = new PrintWriter(file);
				salida.println(venta.toString());
				salida.flush();
				salida.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Venta realizada correctamente");
		} else {
			System.out.println("Error no se ha podido realizar la venta");
		}
	}

}
