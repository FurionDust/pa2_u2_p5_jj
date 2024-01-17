package com.uce.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.service.ICiudadanoService;

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
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5JjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Empleado empl = this.ciudadanoService.buscarPorCedula("1719608729");
		System.out.println(empl);
		
		Ciudadano ciud = this.ciudadanoService.buscarPorCedulaCiu("1719608729");
		System.out.println(ciud);
	}
}
