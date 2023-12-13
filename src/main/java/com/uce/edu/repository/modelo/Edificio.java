package com.uce.edu.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "edificio")
public class Edificio {

	@Id

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_edificio")
	@SequenceGenerator(name = "seq_edificio", sequenceName = "seq_edificio", allocationSize = 1)

	@Column(name = "edif_direccion")
	private String direccion;
	@Column(name = "edif_altura")
	private Double altura;
	@Column(name = "edif_numeroPisos")
	private Integer numeroPisos;
	@Column(name = "edif_propietario")
	private String propietario;
	@Column(name = "edif_fecha")
	private String fechaConstruccion;

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Integer getNumeroPisos() {
		return numeroPisos;
	}

	public void setNumeroPisos(Integer numeroPisos) {
		this.numeroPisos = numeroPisos;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public String getFechaConstruccion() {
		return fechaConstruccion;
	}

	public void setFechaConstruccion(String fechaConstruccion) {
		this.fechaConstruccion = fechaConstruccion;
	}

}
