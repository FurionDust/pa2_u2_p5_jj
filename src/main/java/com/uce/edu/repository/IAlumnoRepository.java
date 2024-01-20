package com.uce.edu.repository;

import java.time.LocalDateTime;

import com.uce.edu.repository.modelo.Alumno;

public interface IAlumnoRepository {
	
	// CRUD
	public Alumno seleccionar(Integer id);

	public void insertar(Alumno alumno);

	public void actualizar(Alumno alumno);

	public void eliminar(Integer id);
	
	public Alumno seleccionarPorNombre(String nombre);
	
	public Alumno seleccionarPorFecha(LocalDateTime fechaMatricula);

}
