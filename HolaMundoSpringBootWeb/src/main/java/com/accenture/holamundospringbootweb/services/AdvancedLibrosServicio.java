package com.accenture.holamundospringbootweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.holamundospringbootweb.persistence.LibroRepository;
import com.accenture.holamundospringbootweb.recursos.Autor;
import com.accenture.holamundospringbootweb.recursos.Libro;

//@Service
public class AdvancedLibrosServicio implements LibrosServicio {

	@Autowired
	private LibroRepository libroRepositorio;

	@Override
	public Libro consultarLibroById(long id) {
		return libroRepositorio.findOne(id);
	}

	@Override
	public Autor consultarAutorDeLibroByIdLibro(long idLibro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Libro> consultarLibrosByTitulo(String titulo) {
		// return libroRepositorio.consultarLibrosPorTitulo(titulo);
		return libroRepositorio.findByTitulo(titulo);
	}

	@Override
	public long altaLibro(Libro libro) {
		return libroRepositorio.save(libro).getId();
	}

	@Override
	public int modificarLibro(Libro libro) {
		Libro guardado = libroRepositorio.save(libro);
		if (guardado != null) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int borrarLibroById(long id) {

		Libro libroABorrar = consultarLibroById(id);

		if (libroABorrar != null) {
			libroRepositorio.delete(id);
			return 1;
		} else {
			return 0;
		}
	}

}
