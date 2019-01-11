package es.indra.ejercicio5;

import java.util.ArrayList;

public class ejercicio5 {

	public static void main(String[] args) {
		ArrayList<Videojuego> listaVideojuego = new ArrayList<Videojuego>(5);
		ArrayList<Serie> listaSerie = new ArrayList<Serie>(5);
		ArrayList<Entregable> listaConjunta = new ArrayList<Entregable>();

		listaVideojuego.add(new Videojuego());
		listaVideojuego.add(new Videojuego());
		listaVideojuego.add(new Videojuego());
		listaVideojuego.add(new Videojuego("Patata", 2));
		listaVideojuego.add(new Videojuego("Dark Solus", 70, "dificil", "FromSotoware"));

		listaSerie.add(new Serie());
		listaSerie.add(new Serie());
		listaSerie.add(new Serie());
		listaSerie.add(new Serie("La historia de la patata", "Potatuela"));
		listaSerie.add(new Serie("Strnbager Zings", 3, "miedo", "hollywood"));

		listaConjunta.addAll(listaVideojuego);
		listaConjunta.addAll(listaSerie);

		listaVideojuego.get(4).entregar();
		listaVideojuego.get(3).entregar();

		listaSerie.get(2).entregar();
		listaSerie.get(1).entregar();

		int contS = 0;
		for (Serie s : listaSerie) {
			if (s.isEntregado() == true) {
				contS++;
			}
		}
		System.out.println("Numero de series entregadas: " + contS);

		int contVJ = 0;
		for (Videojuego vj : listaVideojuego) {
			if (vj.isEntregado() == true) {
				contVJ++;
			}
		}
		System.out.println("Numero de videojuegos entregadas: " + contVJ);

		Serie mayorS = listaSerie.get(listaSerie.size() - 1);
		for (int i = listaSerie.size() - 2; i >= 1; i--) {
			if (listaSerie.get(i).numeroDeTemporadas > mayorS.numeroDeTemporadas) {
				mayorS = listaSerie.get(i);
			}
		}
		System.out.println("La serie con mas temporadas es: " + mayorS.toString());

		Videojuego mayorVJ = listaVideojuego.get(listaVideojuego.size() - 1);
		for (int i = listaVideojuego.size() - 2; i >= 1; i--) {
			if (listaVideojuego.get(i).horasEstimadas > mayorVJ.horasEstimadas) {
				mayorVJ = listaVideojuego.get(i);
			}
		}
		System.out.println("el videojuego con mas horas es: " + mayorVJ.toString());

	}

}
