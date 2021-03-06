package com.accenture.holamundospringbootweb.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.accenture.holamundospringbootweb.recursos.Autor;
import com.accenture.holamundospringbootweb.recursos.Libro;

//@Service
public class SimpleLibrosServicio implements LibrosServicio {

	/* (non-Javadoc)
	 * @see com.accenture.holamundospringbootweb.services.LibrosServicio#consultarLibroById(long)
	 */
	@Override
	public Libro consultarLibroById(long id) {
		return new Libro(1, "El Juego de Ender");
	}

	/* (non-Javadoc)
	 * @see com.accenture.holamundospringbootweb.services.LibrosServicio#consultarAutorDeLibroByIdLibro(long)
	 */
	@Override
	public Autor consultarAutorDeLibroByIdLibro(long idLibro) {
		return new Autor();
	}

	/* (non-Javadoc)
	 * @see com.accenture.holamundospringbootweb.services.LibrosServicio#consultarLibrosByTitulo(java.lang.String)
	 */
	@Override
	public List<Libro> consultarLibrosByTitulo(String titulo) {
		return Arrays.asList(new Libro(1, "El Juego de Ender"), new Libro(2, "El Hobbit"));
	}

	/* (non-Javadoc)
	 * @see com.accenture.holamundospringbootweb.services.LibrosServicio#altaLibro(com.accenture.holamundospringbootweb.recursos.Libro)
	 */
	@Override
	public long altaLibro(Libro libro) {
		return 1;
	}

	/* (non-Javadoc)
	 * @see com.accenture.holamundospringbootweb.services.LibrosServicio#modificarLibro(com.accenture.holamundospringbootweb.recursos.Libro)
	 */
	@Override
	public int modificarLibro(Libro libro) {
		return 1;
	}

	/* (non-Javadoc)
	 * @see com.accenture.holamundospringbootweb.services.LibrosServicio#borrarLibroById(long)
	 */
	@Override
	public int borrarLibroById(long id) {
		return 1;
	}
}
