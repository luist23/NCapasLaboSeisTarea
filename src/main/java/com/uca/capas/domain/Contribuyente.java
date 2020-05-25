package com.uca.capas.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="contribuyente")
public class Contribuyente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="c_contribuyente")
	private Integer codigo;
	
	@Column(name="s_nombre")
	@Size(message = "El nombre no debe tener mas de 30 caracteres", max = 30)
	@NotEmpty(message = "Este campo no puede estar vacio")
	private String nombre;
	
	@Column(name="s_apellido")
	@Size(message = "El apellido no debe tener mas de 30 caracteres", max = 30)
	@NotEmpty(message = "Este campo no puede estar vacio")
	private String apellido;
	
	@Column(name="s_nit")
	@Size(message = "El nit no debe tener mas de 14 caracteres", max = 14)
	@NotEmpty(message = "Este campo no puede estar vacio")
	private String nit;
	
	@Column(name="f_fecha_ingreso")
	private Date fecha;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="c_importancia")
	private Importancia importancia;

	public Contribuyente() {
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	public Importancia getImportancia() {
		return importancia;
	}

	public void setImportancia(Importancia importancia) {
		this.importancia = importancia;
	}
	
	
	

}
