package es.indra.ejercicio3;

public class Password {
	protected Integer longitud = 8;
	protected String contraseña;

	public Password() {
		super();
		this.longitud = 8;
		this.contraseña = generarPassword();
	}

	public Password(Integer longitud) {
		super();
		this.longitud = longitud;
		this.contraseña = generarPassword();
	}

	public Boolean esFuerte() {
		int longitud = this.contraseña.length();
		Boolean fuerte = false;
		int ctma = 0;
		int ctmi = 0;
		int ctnu = 0;
		for (int i = 0; i < longitud; i++) {
			char c = this.contraseña.charAt(i);
			if (Character.isUpperCase(c)) {
				ctma++;
			} else if (Character.isLowerCase(c)) {
				ctmi++;
			} else if (Character.isDigit(c)) {
				ctnu++;
			}
		}
		if (ctma >= 2 && ctmi >= 1 && ctnu >= 5) {
			fuerte = true;
		} else {
			fuerte = false;
		}
		return fuerte;
	}

	public String generarPassword() {
		String pswd = "";
		String key = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i < this.longitud; i++) {
			pswd += (key.charAt((int) (Math.random() * key.length())));
		}

		return pswd;
	}

	public Integer getLongitud() {
		return this.longitud;
	}

	public void setLongitud(Integer longitud) {
		this.longitud = longitud;
	}

	public String getContraseña() {
		return this.contraseña;
	}
}
