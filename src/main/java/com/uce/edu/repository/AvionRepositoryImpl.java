package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Avion;
import com.uce.edu.repository.modelo.Ciudadano;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AvionRepositoryImpl implements IAvionRepository {

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
		TypedQuery<Avion> myQuery = this.entityManager
				.createQuery("SELECT a FROM Avion a WHERE a.numeroVuelo =:numeroVuelo", Avion.class);
		myQuery.setParameter("numeroVuelo", numeroVuelo);
		return myQuery.getSingleResult();
	}

	@Override
	public Avion seleccionarPorRuta(String ruta) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM avion a WHERE a.avi_ruta =:ruta",
				Avion.class);
		myQuery.setParameter("ruta", ruta);
		return (Avion) myQuery.getSingleResult();
	}

	@Override
	public Avion seleccionarPorAerolinea(String aerolinea) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM avion a WHERE a.avi_aerolinea =:aerolinea",
				Avion.class);
		myQuery.setParameter("aerolinea", aerolinea);
		return (Avion) myQuery.getSingleResult();
	}

	@Override
	public Avion seleccionarCriteria(String aerolinea, String horaSalida, String horaLlegada) {
		// TODO Auto-generated method stub
		// 0.Creamos una instancia de la interfaz CriteriaBuilder a partir de un EntityManager
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();
		// 1.-Determianmos el tipo de retorno que va a tener mi Consulta
		CriteriaQuery<Avion> myCriteriaQuery = myCriteriaBuilder.createQuery(Avion.class);
		// 2.-Construir el SQL
		// 2.1 Determinamos elfrom utilizando una interfaz conocida como (Root)
		// Nota: no necesariamnete el from es igual al tipo de retorno
		// SELECT c.empleado FROM Ciudadano c WHERE c.empleado.nombre = :dato
		Root<Avion> myFrom = myCriteriaQuery.from(Avion.class);// FROM Ciudadano
		// 2.2 Construir las condiciones del (WHERE)

		Predicate condicionGenerica = null;

		if (horaSalida.startsWith("15")) {
			condicionGenerica = myCriteriaBuilder.equal(myFrom.get("horaLlegada"), horaLlegada);

		} else if (horaSalida.startsWith("11")) {
			condicionGenerica = myCriteriaBuilder.equal(myFrom.get("aerolinea"), aerolinea);

		} else {
			condicionGenerica = myCriteriaBuilder.equal(myFrom.get("horaSalida"), horaSalida);
		}
		// 3. Construimos el SQL final
		myCriteriaQuery.select(myFrom).where(condicionGenerica);

		TypedQuery<Avion> myQuery = this.entityManager.createQuery(myCriteriaQuery);

		return myQuery.getSingleResult();
	}

}
