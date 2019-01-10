package es.indra.ejercicio2;

public class Persona {
	static char HOMBRE = 'H';
	static char MUJER = 'M';
	static int PESOMENOR = -1;
	static int PESOIDEAL = 0;
	static int PESOMAYOR = 1;

	protected String nombre;
	protected Integer edad;
	protected String DNI;
	protected Character sexo;
	protected Float peso;
	protected Float altura;

	public Persona() {
		super();
		this.nombre = "";
		this.edad = 0;
		this.sexo = HOMBRE;
		this.DNI = generaDNI(null);
		this.peso = Float.valueOf(0);
		this.altura = Float.valueOf(0);
	}

	public Persona(String nombre, Integer edad, Character sexo) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.DNI = generaDNI(null);
		this.peso = Float.valueOf(0);
		this.altura = Float.valueOf(0);
	}

	public Persona(String nombre, Integer edad, Character sexo, Float peso, Float altura) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.DNI = generaDNI(null);
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return this.edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Character getSexo() {
		return this.sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	public Float getPeso() {
		return this.peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public Float getAltura() {
		return this.altura;
	}

	public void setAltura(Float altura) {
		this.altura = altura;
	}

	public int calcularIMC() {
		if (this.peso >= 0 && this.altura >= 0) {
			Integer imc = (int) (this.peso / (Math.pow(this.altura, 2)));

			if (imc < 20) {
				return PESOMENOR;
			} else if (imc >= 20 && imc <= 25) {
				return PESOIDEAL;
			} else {
				return PESOMAYOR;
			}
		} else {
			return -1;
		}
	}

	public boolean esMayorDeEdad() {
		if (this.edad >= 18) {
			return true;
		} else {
			return false;
		}
	}

	private void comprobarSexo(char sexo) {
		if (sexo == HOMBRE || sexo == MUJER) {
			System.out.println("Sexo valido");
		} else {
			System.out.println("Sexo NO valido");
		}
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + this.nombre + ", edad=" + this.edad + ", DNI=" + this.DNI + ", sexo=" + this.sexo
				+ ", peso=" + this.peso + ", altura=" + this.altura + "]";
	}

	private static final char[] LETRAS_NIF = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J',
			'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' };

	public static String generaDNI(String seed) {
		if (seed != null) {
			try {
				Integer.parseInt(seed);
			} catch (NumberFormatException ex) {
				return "KO";
			}
		} else {
			seed = "";
		}
		String numeroDNI = String.valueOf(Math.random()).concat(seed);
		String fullDNI = numeroDNI.substring(numeroDNI.length() - 8);

		int dniInt = Integer.valueOf(fullDNI);
		fullDNI = fullDNI + LETRAS_NIF[dniInt % 23];
		return fullDNI;
	}

	public static String calculaLetra(String nif) {
		if (nif.length() != 8) {
			return ("Nif Inválido");
		}
		return generaDNI(nif).substring(8);
	}

	public static String validaNif(String nif) {
		if (nif.substring(0, 8).length() == 8) {
			return nif.equalsIgnoreCase(generaDNI(nif.substring(0, 8))) ? "OK" : "KO";
		} else {
			return ("Nif Inválido");
		}
	}
}
