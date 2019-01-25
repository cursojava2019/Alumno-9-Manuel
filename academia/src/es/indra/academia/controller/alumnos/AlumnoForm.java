package es.indra.academia.controller.alumnos;

import java.util.List;

import es.indra.academia.model.entities.Alumno;

public class AlumnoForm extends Alumno {

	public AlumnoForm() {
		super();
		setNif("");
		setNombre("");
		setApellido1("");
		setApellido2("");
		setTelefono("");
		setCorreo("");
		setObservaciones("");
		setRepetidor(false);
	}

	public void validar(List<String> errores) {
		if (getNif() == null || getNif().equals("")) {
			errores.add("El nif es obligatorio");

		}
		if (getNif().length() != 9) {
			errores.add("El formato de NIF no es correcto");

		}
		if (getNombre() == null || getNombre().equals("")) {
			errores.add("El Nombre es obligatorio");

		}
		if (getApellido1() == null || getApellido1().equals("")) {
			errores.add("El Primero Apellido es obligatorio");

		}

	}
}
