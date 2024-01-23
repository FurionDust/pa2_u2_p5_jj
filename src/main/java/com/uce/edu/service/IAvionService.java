package com.uce.edu.service;

import com.uce.edu.repository.modelo.Avion;

public interface IAvionService {

	// CRUD
	public Avion buscar(Integer id);

	public void guardar(Avion avion);

	public void actualizar(Avion avion);

	public void eliminar(Integer id);
	
	public Avion buscarPorNumeroVuelo(Integer numeroVuelo);
	
	public Avion buscarPorRuta(String ruta);
	
	public Avion buscarPorAerolinea(String aerolinea);
	
	public Avion buscarCriteria(String aerolinea, String horaSalida, String horaLlegada);
}
