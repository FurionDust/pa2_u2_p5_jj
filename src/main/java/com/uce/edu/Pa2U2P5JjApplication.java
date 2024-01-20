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
	// Criteria API
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

		System.out.println("Typed Query");
		//1
		Ciudadano ciud1 = this.ciudadanoService.buscarPorNombre("Alejandro");
		System.out.println(ciud1);
		//2
		Alumno alum1 = this.alumnoService.buscarPorNombre("José");
		System.out.println(alum1);
		//3
		Empleado empl = this.empleadoService.buscarPorSalario(new BigDecimal(450));
		System.out.println(empl);
		//4 
		List<Estudiante> est = this.estudianteService.buscarPorFecha(LocalDateTime.of(2021, 1,1,7,15));
		for(Estudiante estu :est) {
			System.out.println(estu);	
		}
		//5
		Avion avi = this.avionService.buscarPorNumeroVuelo(1);
		System.out.println(avi);

		System.out.println("Native Query");
		//1
		Ciudadano ciud2 = this.ciudadanoService.buscarPorApellido("Yepez");
		System.out.println(ciud2);
		//2
		Alumno alum2 =this.alumnoService.buscarPorFecha(LocalDateTime.of(2023, 1,19,18,37));
		System.out.println(alum2);
		//3
		Empleado empl2 =this.empleadoService.buscarPorFecha(LocalDateTime.of(2023, 1,19,18,37));
		System.out.println(empl2);
		//4
		Avion av2 = this.avionService.buscarPorRuta("Quito-California");
		System.out.println(av2);
		//5
		Avion av3 = this.avionService.buscarPorAerolinea("Iveria");
		System.out.println(av3);
	}
}
