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
import com.uce.edu.service.IAutorService;
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5JjApplication implements CommandLineRunner {

	@Autowired
	private ILibroService iLibroService;

	@Autowired
	private IAutorService autorService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5JjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		//------------------------------------------------------------//
		//					UN LIBRO CON VARIOS AUTORES				  //
		//------------------------------------------------------------//
		
		
		//Creo un libro
		Libro lib1 = new Libro();
		lib1.setFechaPublicacion(LocalDateTime.now());
		lib1.setTitulo("Harry Potter");
		//Creo sus autores
		Autor autor1 = new Autor();
		autor1.setNacionalidad("Colombiano");
		autor1.setNombre("José Jiménez");
		
		Autor autor2 = new Autor();
		autor2.setNacionalidad("Ecuatoriano");
		autor2.setNombre("Alejandro Loor");
		
		Autor autor3 = new Autor();
		autor3.setNacionalidad("Peruano");
		autor3.setNombre("Juan Quispe");
		
		
		Set<Autor> autores = new HashSet<Autor>();
		autores.add(autor1);
		autores.add(autor2);
		autores.add(autor3);
		
		lib1.setAutores(autores);
		
		Set<Libro> libros1 = new HashSet<Libro>();
		libros1.add(lib1);
		
		autor1.setLibros(libros1);
		autor2.setLibros(libros1);
		autor3.setLibros(libros1);
		
		this.iLibroService.guardar(lib1);

		Libro librover = this.iLibroService.buscar(1);
		System.out.println(librover+" "+autores);
		
		lib1.setTitulo("Maquinita Espacial");
		
		this.iLibroService.actualizar(lib1);
		
		this.iLibroService.eliminar(1);

		
		//------------------------------------------------------------//
		//					UN AUTOR CON VARIOS LIBROS				  //
		//------------------------------------------------------------//
		
		Autor autor4 = new Autor();
		autor4.setNacionalidad("Español");
		autor4.setNombre("Juan Carlos");
		
		Libro lib2 = new Libro();
		lib2.setFechaPublicacion(LocalDateTime.now());
		lib2.setTitulo("La calabaza Mágica");
		
		Libro lib3 = new Libro();
		lib3.setFechaPublicacion(LocalDateTime.now());
		lib3.setTitulo("El principito");
		
		Libro lib4 = new Libro();
		lib4.setFechaPublicacion(LocalDateTime.now());
		lib4.setTitulo("Los miserables");

		Set<Autor> autores4 = new HashSet<Autor>();
		autores4.add(autor4);
		
		lib2.setAutores(autores4);
		lib3.setAutores(autores4);
		lib4.setAutores(autores4);

		
		Set<Libro> libros2 = new HashSet<Libro>();
		libros2.add(lib2);
		libros2.add(lib3);
		libros2.add(lib4);
		
		autor4.setLibros(libros2);
		
		Autor autorver= this.autorService.buscar(4);
		
		System.out.println(autorver);
		
		autor4.setNombre("Leonidas Mera");
		
		this.autorService.actualizar(autor4);
		
		this.autorService.eliminar(4);
	}
}
