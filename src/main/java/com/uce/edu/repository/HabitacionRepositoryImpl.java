package com.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Habitacion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HabitacionRepositoryImpl implements IHabitacionRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Habitacion seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Habitacion.class, id);
	}

	@Override
	public void insertar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.entityManager.persist(habitacion);
	}

	@Override
	public void actualizar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.entityManager.merge(habitacion);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Habitacion hab = this.seleccionar(id);
		this.entityManager.remove(hab);
	}

	@Override
	public Habitacion seleccionarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Habitacion> myQuery = this.entityManager.createQuery("SELECT h FROM Habitacion h WHERE h.numero =:numero",Habitacion.class);
		myQuery.setParameter("numero", numero);
		return myQuery.getSingleResult();
	}

}
