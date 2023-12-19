package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;
import com.uce.edu.service.IEstudianteService;

@SpringBootApplication
public class Pa2U2P5JjApplication implements CommandLineRunner {

	@Autowired
	private IEstudianteService estudianteService;

	@Autowired
	private IAlumnoService alumnoService;
	
	@Autowired
	private IEmpleadoService empleadoService;
	
	@Autowired
	private ICiudadanoService ciudadanoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5JjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		
		Ciudadano ciud2 = new Ciudadano();
		ciud2.setNombre("Alejandro");
		ciud2.setApellido("Jimenez");
		
		this.ciudadanoService.insertar(ciud2);
		
		ciud2.setApellido("Loor");
		
		this.ciudadanoService.actualizar(ciud2);
		
		Ciudadano ciud3 = this.ciudadanoService.seleccionar(2);
		
		System.out.println(ciud3);
		
		this.ciudadanoService.eliminar(2);
		
		
		Empleado empl = new Empleado();
		empl.setFechaIngreso(LocalDateTime.of(2020, 01, 17, 07, 50));
		empl.setSalario(new BigDecimal(450));
		empl.setCiudadano(ciud2);
	
		this.empleadoService.insertar(empl);
		
		empl.setSalario(new BigDecimal(500));
		
		this.empleadoService.actualizar(empl);
		
		Empleado empl1 = this.empleadoService.seleccionar(2);
		
		System.out.println(empl1);
		
		this.empleadoService.eliminar(2);
		
		

	}

}
