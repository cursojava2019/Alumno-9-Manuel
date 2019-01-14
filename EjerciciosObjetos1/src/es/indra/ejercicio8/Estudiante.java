package es.indra.ejercicio8;

public class Estudiante extends Persona {
	protected Integer Calificacion;
	protected Boolean falta;

	public Estudiante(String nombre, Integer edad, Character sexo, Integer calificacion) {
		super(nombre, edad, sexo);
		this.Calificacion = notas(calificacion);
		this.falta = falta();
	}

	public Boolean falta() {
		Boolean falta = null;

		Integer probabilidad = (int) (Math.random() * 100 + 1);

		if (probabilidad <= 50) {
			falta = true;
		} else {
			falta = false;
		}
		return falta;
	}

	public Integer notas(Integer calificacion) {
		Integer resultado = 0;
		if (resultado < 0) {
			resultado = 0;
		}
		if (resultado > 10) {
			resultado = 10;
		}
		return resultado;
	}

	public Integer getCalificacion() {
		return this.Calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.Calificacion = calificacion;
	}

	public Boolean getFalta() {
		return this.falta;
	}

	public void setFalta(Boolean falta) {
		this.falta = falta;
	}
}
