package com.uce.edu.service;

import com.uce.edu.repository.modelo.Ciudadano;

public interface ICiudadanoService {

	public Ciudadano seleccionar(Integer id);
	
	public void insertar(Ciudadano ciudadano);
}
