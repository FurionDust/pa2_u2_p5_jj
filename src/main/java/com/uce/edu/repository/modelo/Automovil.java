package com.uce.edu.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "automovil")
public class Automovil {

	@Id

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_automovil")
	@SequenceGenerator(name = "seq_automovil", sequenceName = "seq_automovil", allocationSize = 1)

	@Column(name = "auto_placa")
	private String placa;
	@Column(name = "auto_marca")
	private String marca;
	@Column(name = "auto_modelo")
	private String modelo;
	@Column(name = "auto_color")
	private String color;
	@Column(name = "auto_año")
	private Integer año;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getAño() {
		return año;
	}

	public void setAño(Integer año) {
		this.año = año;
	}

}
