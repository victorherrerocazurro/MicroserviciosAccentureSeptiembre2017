package com.accenture.holamundospringbootweb.services;

import java.util.List;

import com.accenture.holamundospringbootweb.recursos.Autor;
import com.accenture.holamundospringbootweb.recursos.Libro;

//Requisitos funcionales
public interface LibrosServicio {

	Libro consultarLibroById(long id);

	Autor consultarAutorDeLibroByIdLibro(long idLibro);

	List<Libro> consultarLibrosByTitulo(String titulo);

	long altaLibro(Libro libro);

	int modificarLibro(Libro libro);

	int borrarLibroById(long id);

}