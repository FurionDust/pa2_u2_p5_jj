package com.uce.edu.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmpleadoRepositoryImpl implements IEmpleadoRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public void insertar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.entityManager.persist(empleado);
	}


	@Override
	public Empleado seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Empleado.class, id);
	}


	@Override
	public void actualizar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.entityManager.merge(empleado);
	}


	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Empleado empl = this.seleccionar(id);
		this.entityManager.remove(empl);
	}


	@Override
	public Empleado seleccionarPorSalario(BigDecimal salario) {
		// TODO Auto-generated method stub
		TypedQuery<Empleado> myQuery = this.entityManager.createQuery("SELECT e FROM Empleado e WHERE e.salario =:salario",Empleado.class);
		myQuery.setParameter("salario", salario);
		return myQuery.getSingleResult();
	}


	@Override
	public Empleado seleccionarPorFecha(LocalDateTime fechaIngreso) {
		// TODO Auto-generated method stub
		Query myQuery =this.entityManager.createNativeQuery("SELECT * FROM empleado e WHERE e.empl_fecha_ingreso <=:fecha",Empleado.class);
		myQuery.setParameter("fecha", fechaIngreso);
		return (Empleado) myQuery.getSingleResult();
	}

}
