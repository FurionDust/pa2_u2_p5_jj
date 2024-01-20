package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Avion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AvionRepositoryImpl implements IAvionRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Avion seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Avion.class, id);
	}

	@Override
	public void insertar(Avion avion) {
		// TODO Auto-generated method stub
		this.entityManager.persist(avion);
	}

	@Override
	public void actualizar(Avion avion) {
		// TODO Auto-generated method stub
		this.entityManager.merge(avion);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Avion avion = this.seleccionar(id);
		this.entityManager.remove(avion);
	}

	@Override
	public Avion seleccionarPorNumeroVuelo(Integer numeroVuelo) {
		// TODO Auto-generated method stub
		TypedQuery<Avion> myQuery = this.entityManager.createQuery("SELECT a FROM Avion a WHERE a.numeroVuelo =:numeroVuelo", Avion.class);
		myQuery.setParameter("numeroVuelo", numeroVuelo);
		return myQuery.getSingleResult();
	}

	@Override
	public Avion seleccionarPorRuta(String ruta) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM avion a WHERE a.avi_ruta =:ruta",Avion.class);
		myQuery.setParameter("ruta", ruta);
		return (Avion) myQuery.getSingleResult();
	}

	@Override
	public Avion seleccionarPorAerolinea(String aerolinea) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM avion a WHERE a.avi_aerolinea =:aerolinea",Avion.class);
		myQuery.setParameter("aerolinea", aerolinea);
		return (Avion) myQuery.getSingleResult();
	}

}
