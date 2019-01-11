package es.indra.ejercicio6;

public class ejercicio6 {

	public static void main(String[] args) {
		Libro l1 = new Libro("20-2569-9965-12", "Platero y yo", "Yo", 135);
		Libro l2 = new Libro("36-5895-1425-69", "Vikingos Veganos", "Vikingos", 2);

		System.out.println(l1.toString());
		System.out.println(l2.toString());
		if (l1.numeroDePaginas > l2.numeroDePaginas) {
			System.out.println("El libro con mas páginas es: " + l1.titulo + " de ISBN: " + l1.isbn);
		} else if (l1.numeroDePaginas < l2.numeroDePaginas) {
			System.out.println("El libro con mas páginas es: " + l2.titulo + " de ISBN: " + l2.isbn);
		} else {
			System.out.println("Los dos libros tienen el mismo numero de paginas");
		}
	}

}
