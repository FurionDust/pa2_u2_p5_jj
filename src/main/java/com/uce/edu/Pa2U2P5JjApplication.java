package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Avion;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.IAvionService;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;
import com.uce.edu.service.IEstudianteService;
import com.uce.edu.service.IHabitacionService;

@SpringBootApplication
public class Pa2U2P5JjApplication implements CommandLineRunner {

	// 1. Query || Query cuando tengamos que elegir entre un query y un typed, es mejor typed 
	//1.1 TypedQuery
	//1.2 NamedQuery || Cuando un query es necesario ser utilizado desde varias partes 
		//Declarar de una manera centralizada el query y se va a reutilizar desde las diferentes partes que se necesita a traves de un nombre
		//
	// Native(SQL PURO) 
	// Criteria API (SQL dinámico)
	@Autowired
	private ICiudadanoService ciudadanoService;
	@Autowired
	private IAlumnoService alumnoService;
	@Autowired
	private IEmpleadoService empleadoService;
	@Autowired
	private IEstudianteService estudianteService;
	@Autowired
	private IHabitacionService habitacionService;
	@Autowired
	private IAvionService avionService;	
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5JjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Ciudadano ciu = this.ciudadanoService.buscarPorApellido("Jimenez");
		System.out.println(ciu);
		//select c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_nombre from ciudadano c1_0 where c1_0.ciud_nombre=?
		Ciudadano ciu1 = this.ciudadanoService.buscarPorCriteria("Cristian", "Yepez", "1719608722");
		System.out.println(ciu1);
		// select c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_nombre from ciudadano c1_0 where c1_0.ciud_apellido=?
		Ciudadano ciu2 = this.ciudadanoService.buscarPorCriteria("Romina", "Guevara", "0519608728");
		System.out.println(ciu2);
		//select c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_nombre from ciudadano c1_0 where c1_0.ciud_cedula=?
		Ciudadano ciu3 = this.ciudadanoService.buscarPorCriteria("Romina", "Guevara", "0519608729");
		System.out.println(ciu3);
		
		System.out.println("Criteria API Query And Or");
		//select c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_nombre from ciudadano c1_0 where c1_0.ciud_nombre=? or c1_0.ciud_apellido=?
		Ciudadano ciu4 = this.ciudadanoService.buscarPorCriteriaAndOr("Cristian", "Yepez11", "1719608722");
		System.out.println(ciu4);
		//select c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_nombre from ciudadano c1_0 where c1_0.ciud_nombre=? and c1_0.ciud_apellido=?
		Ciudadano ciu5 = this.ciudadanoService.buscarPorCriteriaAndOr("Romina", "Guevara", "0519608728");
		System.out.println(ciu5);
		
	}
}
