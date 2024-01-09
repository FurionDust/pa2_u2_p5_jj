package com.uce.edu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Autor2;
import com.uce.edu.repository.modelo.AutorLibro;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;
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

		Libro2 lib1 = new Libro2();
		lib1.setFechaPublicacion(LocalDateTime.now());
		lib1.setTitulo("Harry Potter 2");
		
		Autor2 autor1 = new Autor2();
		autor1.setNacionalidad("Colombiano 2");
		autor1.setNombre("José Jiménez 2");
		
		Autor2 autor2 = new Autor2();
		autor2.setNacionalidad("Ecuatoriano 2");
		autor2.setNombre("Alejandro Loor 2");
		
		Set<Autor2> autores = new HashSet<Autor2>();
		autores.add(autor1);
		autores.add(autor2);
		
		AutorLibro autorLibro1 = new AutorLibro();
		autorLibro1.setLibro2(lib1);
		autorLibro1.setAutor2(autor1);
		autorLibro1.setFecha(LocalDateTime.now());

		AutorLibro autorLibro2 = new AutorLibro();
		autorLibro2.setLibro2(lib1);
		autorLibro2.setAutor2(autor2);
		autorLibro2.setFecha(LocalDateTime.now());
		
		List<AutorLibro> lista = new ArrayList<>();
		lista.add(autorLibro1);
		lista.add(autorLibro2);
		
		lib1.setAutoresLibros(lista);

		//this.iLibroService.guardar(lib1);
		Libro libro = this.iLibroService.buscarPorNombre("Java");
		System.out.println(libro);
	}
}
