package es.indra.ejercicio4;

public class Lavadora extends Electrodomestico {
	static final Float CARGA_DEFECTO = new Float(5);
	protected Float carga;

	public Lavadora() {
		super();
		this.carga = CARGA_DEFECTO;
	}

	public Lavadora(Float precioBase, Float peso) {
		super(precioBase, peso);
		this.carga = CARGA_DEFECTO;
	}

	public Lavadora(Float precioBase, String color, Character clasificacion, Float peso, Float carga) {
		super(precioBase, color, clasificacion, peso);
		this.carga = carga;
	}

	public Float getCarga() {
		return this.carga;
	}

	public void setCarga(Float carga) {
		this.carga = carga;
	}

	@Override
	public Float precioFinal() {
		Float precioFinal = super.precioFinal();
		if (this.carga > 30) {
			precioFinal += 50;
		}
		return precioFinal;
	}

}
