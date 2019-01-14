package es.indra.ejercicio8;

import java.util.ArrayList;

public class Aula {
	protected Integer id;
	protected Integer numeroMaximoDeEstudiantes;
	protected String destinada;
	protected Profesor profesor;
	protected ArrayList<Estudiante> estudiantes;

	public Aula(Integer id, Integer numeroMaximoDeEstudiantes, String destinada, Profesor profesor,
			ArrayList<Estudiante> estudiantes) {
		super();
		this.id = id;
		this.numeroMaximoDeEstudiantes = numeroMaximoDeEstudiantes;
		this.destinada = destinada;
		this.profesor = profesor;
		this.estudiantes = estudiantes;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroMaximoDeEstudiantes() {
		return this.numeroMaximoDeEstudiantes;
	}

	public void setNumeroMaximoDeEstudiantes(Integer numeroMaximoDeEstudiantes) {
		this.numeroMaximoDeEstudiantes = numeroMaximoDeEstudiantes;
	}

	public String getDestinada() {
		return this.destinada;
	}

	public void setDestinada(String destinada) {
		this.destinada = destinada;
	}

	public Boolean darClase() {
		Boolean seDaClase = null;

		if (this.profesor.falta == false && this.profesor.materia.equalsIgnoreCase(this.destinada)
				&& this.estudiantes.size() > (this.numeroMaximoDeEstudiantes / 2)
				&& this.estudiantes.size() <= (this.numeroMaximoDeEstudiantes)) {
			seDaClase = true;
		} else {
			seDaClase = false;
		}
		return seDaClase;
	}

	public void notasDeClase() {
		if (darClase() == true) {
			for (Estudiante e : this.estudiantes) {
				System.out
						.println(e.nombre + " tienes un " + e.Calificacion + " en la asignatura de " + this.destinada);
			}
		}
	}

}
