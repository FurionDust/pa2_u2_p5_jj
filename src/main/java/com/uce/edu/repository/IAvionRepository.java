package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Avion;

public interface IAvionRepository {

	// CRUD
	public Avion seleccionar(Integer id);

	public void insertar(Avion avion);

	public void actualizar(Avion avion);

	public void eliminar(Integer id);
	
	public Avion seleccionarPorNumeroVuelo(Integer numeroVuelo);
	
	public Avion seleccionarPorRuta(String ruta);
	
	public Avion seleccionarPorAerolinea(String aerolinea);
	
	public Avion seleccionarCriteria(String aerolinea, String horaSalida, String horaLlegada);


}

