package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IAvionRepository;
import com.uce.edu.repository.modelo.Avion;

@Service
public class AvionServiceImpl implements IAvionService{

	@Autowired
	private IAvionRepository avionRepository;
	
	@Override
	public Avion buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.avionRepository.seleccionar(id);
	}

	@Override
	public void guardar(Avion avion) {
		// TODO Auto-generated method stub
		this.avionRepository.insertar(avion);
	}

	@Override
	public void actualizar(Avion avion) {
		// TODO Auto-generated method stub
		this.avionRepository.actualizar(avion);
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.avionRepository.eliminar(id);
	}

	@Override
	public Avion buscarPorNumeroVuelo(Integer numeroVuelo) {
		// TODO Auto-generated method stub
		return this.avionRepository.seleccionarPorNumeroVuelo(numeroVuelo);
	}

	@Override
	public Avion buscarPorRuta(String ruta) {
		// TODO Auto-generated method stub
		return this.avionRepository.seleccionarPorRuta(ruta);
	}

	@Override
	public Avion buscarPorAerolinea(String aerolinea) {
		// TODO Auto-generated method stub
		return this.avionRepository.seleccionarPorAerolinea(aerolinea);
	}

}
