package es.indra.ejercicio5;

public class Serie implements Entregable {
	static final Integer NUMERO_TEMPORADAS_DEFECTO = Integer.valueOf(3);
	static final Boolean ENTREGADO_DEFECTO = false;

	protected String titulo;
	protected Integer numeroDeTemporadas;
	protected Boolean entregado;
	protected String genero;
	protected String creador;

	public Serie() {
		super();
		this.titulo = "Sin Titulo";
		this.numeroDeTemporadas = NUMERO_TEMPORADAS_DEFECTO;
		this.entregado = ENTREGADO_DEFECTO;
		this.genero = "Sin genero";
		this.creador = "Sin creador";
	}

	public Serie(String titulo, String creador) {
		super();
		this.titulo = titulo;
		this.creador = creador;
		this.numeroDeTemporadas = NUMERO_TEMPORADAS_DEFECTO;
		this.entregado = ENTREGADO_DEFECTO;
		this.genero = "Sin genero";
	}

	public Serie(String titulo, Integer numeroDeTemporadas, String genero, String creador) {
		super();
		this.titulo = titulo;
		this.numeroDeTemporadas = numeroDeTemporadas;
		this.genero = genero;
		this.entregado = ENTREGADO_DEFECTO;
		this.creador = creador;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getNumeroDeTemporadas() {
		return this.numeroDeTemporadas;
	}

	public void setNumeroDeTemporadas(Integer numeroDeTemporadas) {
		this.numeroDeTemporadas = numeroDeTemporadas;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCreador() {
		return this.creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	@Override
	public String toString() {
		return "Serie [titulo=" + this.titulo + ", numeroDeTemporadas=" + this.numeroDeTemporadas + ", entregado="
				+ this.entregado + ", genero=" + this.genero + ", creador=" + this.creador + "]";
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
		if (a instanceof Serie) {
			if (((Serie) a).numeroDeTemporadas > this.numeroDeTemporadas) {
				resultado = 2;
			} else if (((Serie) a).numeroDeTemporadas < this.numeroDeTemporadas) {
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
