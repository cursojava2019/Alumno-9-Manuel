package es.indra.ejercicio4;

public class Television extends Electrodomestico {
	public static final Integer RESOLUCION_DEFECTO = new Integer(20);
	public static final Boolean TDT_DEFECTO = false;

	protected Integer resolucion;
	protected Boolean sintonizador;

	public Television() {
		super();
		this.resolucion = RESOLUCION_DEFECTO;
		this.sintonizador = TDT_DEFECTO;
	}

	public Television(Float precioBase, Float peso) {
		super(precioBase, peso);
		this.resolucion = RESOLUCION_DEFECTO;
		this.sintonizador = TDT_DEFECTO;
	}

	public Television(Float precioBase, String color, Character clasificacion, Float peso, Integer resolucion,
			Boolean sintonizador) {
		super(precioBase, color, clasificacion, peso);
		this.resolucion = resolucion;
		this.sintonizador = sintonizador;
	}

	public Integer getResolucion() {
		return this.resolucion;
	}

	public void setResolucion(Integer resolucion) {
		this.resolucion = resolucion;
	}

	public Boolean getSintonizador() {
		return this.sintonizador;
	}

	public void setSintonizador(Boolean sintonizador) {
		this.sintonizador = sintonizador;
	}

	@Override
	public Float precioFinal() {
		Float precioFinal = super.precioFinal();
		if (this.resolucion >= 40) {
			precioFinal = precioFinal * Float.valueOf("1.3");
		}
		if (this.sintonizador) {
			precioFinal += 50;
		}
		return precioFinal;
	}

}
