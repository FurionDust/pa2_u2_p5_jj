package com.uce.edu.repository;

import java.time.LocalDateTime;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Alumno;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AlumnoRepository implements IAlumnoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Alumno seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Alumno.class, id);
	}

	@Override
	public void insertar(Alumno alumno) {
		// TODO Auto-generated method stub
		this.entityManager.persist(alumno);
	}

	@Override
	public void actualizar(Alumno alumno) {
		// TODO Auto-generated method stub
		this.entityManager.merge(alumno);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Alumno alum = this.seleccionar(id);
		this.entityManager.remove(alum);
	}

	@Override
	public Alumno seleccionarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Alumno> myQuery = this.entityManager.createQuery("SELECT a FROM Alumno a WHERE a.nombre =:nombre",Alumno.class);
		myQuery.setParameter("nombre", nombre);
		return myQuery.getSingleResult();
	}

	@Override
	public Alumno seleccionarPorFecha(LocalDateTime fechaMatricula) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM alumno a WHERE a.alum_fecha_matricula <=:fecha",Alumno.class);
		myQuery.setParameter("fecha", fechaMatricula);
		return (Alumno) myQuery.getSingleResult();
	}

}
