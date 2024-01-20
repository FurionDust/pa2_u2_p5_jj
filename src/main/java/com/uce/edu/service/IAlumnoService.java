package com.uce.edu.service;

import java.time.LocalDateTime;

import com.uce.edu.repository.modelo.Alumno;

public interface IAlumnoService {

	// CRUD
	public Alumno seleccionar(Integer id);

	public void insertar(Alumno alumno);

	public void actualizar(Alumno alumno);

	public void eliminar(Integer id);
	
	public Alumno buscarPorNombre(String nombre);
	
	public Alumno buscarPorFecha(LocalDateTime fechaMatricula);
}
