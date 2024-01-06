package com.uce.edu;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5JjApplication implements CommandLineRunner {

	@Autowired
	private ILibroService iLibroService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5JjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		Libro lib1 = new Libro();
		lib1.setFechaPublicacion(LocalDateTime.now());
		lib1.setTitulo("Harry Potter");
		
		Autor autor1 = new Autor();
		autor1.setNacionalidad("Colombiano");
		autor1.setNombre("José Jiménez");
		
		Autor autor2 = new Autor();
		autor2.setNacionalidad("Ecuatoriano");
		autor2.setNombre("Alejandro Loor");
		
		Set<Autor> autores = new HashSet<Autor>();
		autores.add(autor1);
		autores.add(autor2);
		
		lib1.setAutores(autores);
		
		Set<Libro> libros = new HashSet<Libro>();
		libros.add(lib1);
		
		autor1.setLibros(libros);
		autor2.setLibros(libros);
		
		this.iLibroService.guardar(lib1);
		
	}
}
