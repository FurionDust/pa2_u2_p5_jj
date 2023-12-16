package com.uce.edu;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.IEstudianteService;

@SpringBootApplication
public class Pa2U2P5JjApplication implements CommandLineRunner {

	@Autowired
	private IEstudianteService estudianteService;
	
	@Autowired
	private IAlumnoService alumnoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5JjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
/*
		Estudiante est1 = new Estudiante();
		est1.setCedula("1719608729");
		est1.setNombre("Alejandro");
		est1.setApellido("Jimenez");
		est1.setFechaNacimiento(LocalDateTime.of(2001, 01, 17, 07, 50));

		this.estudianteService.insertar(est1);

		est1.setNombre("José");

		this.estudianteService.actualizar(est1);
*/
		/*
		Alumno alumno = new Alumno();
		alumno.setNombre("Juan");
	
		this.alumnoService.insertar(alumno);
		*/
		Alumno alum = this.alumnoService.seleccionar(1);
		
		System.out.println(alum);
		
	}

}
