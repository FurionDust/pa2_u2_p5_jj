package com.uce.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.uce.edu.repository.modelo.Empleado;

public interface IEmpleadoService {

	// CRUD
	public Empleado seleccionar(Integer id);

	public void insertar(Empleado empleado);

	public void actualizar(Empleado empleado);

	public void eliminar(Integer id);
	
	public Empleado buscarPorSalario(BigDecimal salario);
	
	public Empleado buscarPorFecha(LocalDateTime fechaIngreso);

}
