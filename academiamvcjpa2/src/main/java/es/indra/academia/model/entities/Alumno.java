package es.indra.academia.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Calendar;
import java.util.List;


/**
 * The persistent class for the alumno database table.
 * 
 */
@Entity
@NamedQuery(name="Alumno.findAll", query="SELECT a FROM Alumno a")
public class Alumno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String apellido1;

	private String apellido2;

	private String correo;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechaAlta;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechaBaja;

	private String nif;

	private String nombre;

	private String observaciones;

	private Boolean repetidor;

	private String telefono;

	//bi-directional many-to-many association to Clase
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="alumno_clase"
		, joinColumns={
			@JoinColumn(name="id_alumno")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_clase")
			}
		)
	private List<Clase> clases;

	//bi-directional many-to-one association to ResponsableAlumno
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="responsable")
	private ResponsableAlumno responsable;

	public Alumno() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Calendar getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Calendar fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Calendar getFechaBaja() {
		return this.fechaBaja;
	}

	public void setFechaBaja(Calendar fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public String getNif() {
		return this.nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Boolean getRepetidor() {
		return this.repetidor;
	}

	public void setRepetidor(Boolean repetidor) {
		this.repetidor = repetidor;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Clase> getClases() {
		return this.clases;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}

	public ResponsableAlumno getResponsable() {
		return this.responsable;
	}

	public void setResponsable(ResponsableAlumno responsable) {
		this.responsable = responsable;
	}

}