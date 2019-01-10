package es.indra.ejercicio4;

public class Electrodomestico {
	static final Color COLOR_BASE = Color.BLANCO;
	static final Float PRECIO_DEFECTO = Float.valueOf(100);
	static final Float PESO_DEFECTO = Float.valueOf(5);
	static final Character CLASIFICACION_DEFECTO = 'F';

	protected Float precioBase;
	protected Color color;
	protected Character clasificacion;
	protected Float Peso;

	public Electrodomestico() {
		super();
		this.precioBase = PRECIO_DEFECTO;
		this.color = COLOR_BASE;
		this.clasificacion = CLASIFICACION_DEFECTO;
		this.Peso = PESO_DEFECTO;
	}

	public Electrodomestico(Float precioBase, Float peso) {
		// quitando el super() y añadiendo this(), llamamos al constructor por defecto.
		this();
		this.precioBase = precioBase;
		this.Peso = peso;
	}

	public Electrodomestico(Float precioBase, String color, Character clasificacion, Float peso) {
		super();
		this.precioBase = precioBase;
		comprobarColor(color);
		comprobarConsumoEnergetico(clasificacion);
		this.Peso = peso;
	}

	public Float getPrecioBase() {
		return this.precioBase;
	}

	public void setPrecioBase(Float precioBase) {
		this.precioBase = precioBase;
	}

	public String getColor() {
		return this.color.toString();
	}

	public void setColor(String color) {
		comprobarColor(color);
	}

	public Character getClasificacion() {
		return this.clasificacion;
	}

	public void setClasificacion(Character clasificacion) {
		comprobarConsumoEnergetico(clasificacion);
	}

	public Float getPeso() {
		return this.Peso;
	}

	public void setPeso(Float peso) {
		this.Peso = peso;
	}

	public void comprobarConsumoEnergetico(char clasi) {
		if (clasi == 'A' || clasi == 'B' || clasi == 'C' || clasi == 'D' || clasi == 'E' || clasi == 'F') {
			this.clasificacion = clasi;
		} else {
			this.clasificacion = CLASIFICACION_DEFECTO;
		}
	}

	private void comprobarColor(String color) {
		if (color.equalsIgnoreCase(Color.ROJO.toString()) || color.equalsIgnoreCase(Color.AZUL.toString())
				|| color.equalsIgnoreCase(Color.BLANCO.toString()) || color.equalsIgnoreCase(Color.GRIS.toString())
				|| color.equalsIgnoreCase(Color.NEGRO.toString())) {
			this.color = Color.valueOf(color);
		} else {
			this.color = COLOR_BASE;
		}
	}

	public Float precioFinal() {
		Float precioFinal = Float.valueOf(0);
		switch (this.clasificacion) {
		case 'A':
			precioFinal += 100;
			break;
		case 'B':
			precioFinal += 80;
			break;
		case 'C':
			precioFinal += 60;
			break;
		case 'D':
			precioFinal += 50;
			break;
		case 'E':
			precioFinal += 30;
			break;
		case 'F':
			precioFinal += 20;
			break;
		default:
			precioFinal += 20;
			break;
		}

		if (this.Peso <= 19) {
			precioFinal += 10;
		} else if (this.Peso > 19 && this.Peso <= 49) {
			precioFinal += 50;
		} else if (this.Peso > 49 && this.Peso <= 79) {
			precioFinal += 80;
		} else {
			precioFinal += 100;
		}
		return precioFinal;
	}

}
