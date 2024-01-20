package com.uce.edu.repository.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuentaBancaria")
public class CuentaBancaria {

	@Id

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cuentaBancaria")
	@SequenceGenerator(name = "seq_cuentaBancaria", sequenceName = "seq_cuentaBancaria", allocationSize = 1)

	@Column(name = "cb_numero_cuenta")
	private Integer numeroCuenta;
	@Column(name = "cb_saldo")
	private BigDecimal saldo;
	@Column(name = "cb_titular")
	private String titular;
	@Column(name = "cb_tipo")
	private String tipo;
	@Column(name = "cb_cedula")
	private String cedula;

	public Integer getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(Integer numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

}
