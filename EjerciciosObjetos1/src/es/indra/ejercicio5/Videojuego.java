package es.indra.ejercicio5;

public class Videojuego implements Entregable {
	static final Integer HORAS_ESTIMADAS_DEFECTO = Integer.valueOf(10);
	static final Boolean ENTREGADO_DEFECTO = false;

	protected String titulo;
	protected Integer horasEstimadas;
	protected Boolean entregado;
	protected String genero;
	protected String compa�ia;

	public Videojuego() {
		super();
		this.titulo = "Sin titulo";
		this.horasEstimadas = HORAS_ESTIMADAS_DEFECTO;
		this.entregado = ENTREGADO_DEFECTO;
		this.genero = "Sin genero";
		this.compa�ia = "Sin compa�ia";
	}

	public Videojuego(String titulo, Integer horasEstimadas) {
		super();
		this.titulo = titulo;
		this.horasEstimadas = horasEstimadas;
		this.entregado = ENTREGADO_DEFECTO;
		this.genero = "Sin genero";
		this.compa�ia = "Sin compa�ia";
	}

	public Videojuego(String titulo, Integer horasEstimadas, String genero, String compa�ia) {
		super();
		this.titulo = titulo;
		this.horasEstimadas = horasEstimadas;
		this.genero = genero;
		this.compa�ia = compa�ia;
		this.entregado = ENTREGADO_DEFECTO;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getHorasEstimadas() {
		return this.horasEstimadas;
	}

	public void setHorasEstimadas(Integer horasEstimadas) {
		this.horasEstimadas = horasEstimadas;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCompa�ia() {
		return this.compa�ia;
	}

	public void setCompa�ia(String compa�ia) {
		this.compa�ia = compa�ia;
	}

	@Override
	public String toString() {
		return "Videojuego [titulo=" + this.titulo + ", horasEstimadas=" + this.horasEstimadas + ", entregado="
				+ this.entregado + ", genero=" + this.genero + ", compa�ia=" + this.compa�ia + "]";
	}

	@Override
	public void entregar() {
		this.entregado = true;

	}

	@Override
	public void devolver() {
		this.entregado = true;

	}

	@Override
	public boolean isEntregado() {
		return this.entregado;
	}

	@Override
	public int compareTo(Object a) {
		Integer resultado = new Integer(0);
		if (a instanceof Videojuego) {
			if (((Videojuego) a).horasEstimadas > this.horasEstimadas) {
				resultado = 2;
			} else if (((Videojuego) a).horasEstimadas < this.horasEstimadas) {
				resultado = 0;
			} else {
				resultado = 1;
			}
		} else {
			resultado = -1;
		}
		return resultado;
	}
}
