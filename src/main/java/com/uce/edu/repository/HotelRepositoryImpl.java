package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Hotel seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Hotel.class, id);
	}

	@Override
	public void insertar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.persist(hotel);
	}

	@Override
	public void actualizar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.merge(hotel);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Hotel hotel = this.seleccionar(id);
		this.entityManager.remove(hotel);
	}

	@Override
	public Hotel seleccionarPorCriteriaAndOr(String nombre, String direccion) {
		// 0.Creamos una instancia de la interfaz CriteriaBuilder a partir de un Entity
		// Manager
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();
		// 1.-Determianmos el tipo de retorno que va a tener mi Consulta
		CriteriaQuery<Hotel> myCriteriaQuery = myCriteriaBuilder.createQuery(Hotel.class);
		// 2.-Construir el SQL
		// 2.1 Determinamos elfrom utilizando una interfaz conocida como (Root)
		// Nota: no necesariamnete el from es igual al tipo de retorno
		// SELECT c.empleado FROM Ciudadano c WHERE c.empleado.nombre = :dato
		Root<Hotel> myFrom = myCriteriaQuery.from(Hotel.class);// FROM Ciudadano
		// 2.2 Construir las condiciones del (WHERE)

		Predicate condicionTotal = null;

		Predicate condicionNombre = myCriteriaBuilder.equal(myFrom.get("nombre"), nombre);

		Predicate condicionDireccion = myCriteriaBuilder.equal(myFrom.get("direccion"), direccion);

		if (direccion.startsWith("Villa")) {
			condicionTotal = myCriteriaBuilder.or(condicionNombre, condicionDireccion);

		} else if (direccion.startsWith("Car")) {
			condicionTotal = myCriteriaBuilder.and(condicionNombre, condicionDireccion);
		}
		// 3. Construimos el SQL final
		myCriteriaQuery.select(myFrom).where(condicionTotal);

		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(myCriteriaQuery);

		return myQuery.getSingleResult();
	}

}
