package es.indra.ejercicio8;

public class Profesor extends Persona {
	protected String materia;
	protected Boolean falta;

	public Profesor(String nombre, Integer edad, Character sexo, String materia) {
		super(nombre, edad, sexo);
		this.materia = asignatura(materia);
		this.falta = falta();
	}

	public Boolean falta() {
		Boolean falta = null;

		Integer probabilidad = (int) (Math.random() * 100 + 1);

		if (probabilidad <= 20) {
			falta = true;
		} else {
			falta = false;
		}
		return falta;
	}

	public String asignatura(String materia) {
		String asignatura = "null";
		if (materia.equalsIgnoreCase("matematicas") || materia.equalsIgnoreCase("filosofia")
				|| materia.equalsIgnoreCase("fisica")) {
			asignatura = materia;
		} else {
			asignatura = "matematicas";
		}
		return asignatura;
	}

	public String getMateria() {
		return this.materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public Boolean getFalta() {
		return this.falta;
	}

	public void setFalta(Boolean falta) {
		this.falta = falta;
	}
}
