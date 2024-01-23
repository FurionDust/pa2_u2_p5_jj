package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Avion;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.IAutorService;
import com.uce.edu.service.IAvionService;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;
import com.uce.edu.service.IEstudianteService;
import com.uce.edu.service.IHabitacionService;
import com.uce.edu.service.IHotelService;
import com.uce.edu.service.ILibroService;

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
	@Autowired
	private ILibroService iLibroService;
	@Autowired
	private IAutorService autorService;
	@Autowired
	private IHotelService hotelService;
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5JjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//1
		System.out.println("-------------------------------------------");
		Avion av = this.avionService.buscarCriteria("Avianca", "11:00am", "15:30pm");
		System.out.println(av);
		System.out.println("-------------------------------------------");
		//2
		Libro lb = this.iLibroService.buscarPorCriteria("Harry Potter");
		System.out.println(lb);
		System.out.println("-------------------------------------------");
		//3
		Autor aut = this.autorService.buscarPorCriteria("Alejandro Loor", "Ecuatoriano");
		System.out.println(aut);
		System.out.println("-------------------------------------------");
		//4
		Empleado empl = this.empleadoService.buscarPorCriteria(new BigDecimal(450));
		System.out.println(empl);
		System.out.println("-------------------------------------------");
		//5
		Hotel hot = this.hotelService.buscarPorCriteriaAndOr("La posada", "Villaflora");
		System.out.println(hot);
	}
}
