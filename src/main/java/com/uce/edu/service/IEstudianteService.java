package com.uce.edu.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repository.modelo.Estudiante;

public interface IEstudianteService {

	// CRUD
	public Estudiante seleccionar(Integer id);

	public void insertar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void eliminar(Integer id);
	
	public List<Estudiante> buscarPorFecha(LocalDateTime fechaNacimiento);
}
