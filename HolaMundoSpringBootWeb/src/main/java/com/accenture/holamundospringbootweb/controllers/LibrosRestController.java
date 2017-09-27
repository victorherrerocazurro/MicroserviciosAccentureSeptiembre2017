package com.accenture.holamundospringbootweb.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.holamundospringbootweb.recursos.Autor;
import com.accenture.holamundospringbootweb.recursos.Libro;
import com.accenture.holamundospringbootweb.services.LibrosServicio;

@RestController
@RequestMapping("/Libros")
public class LibrosRestController {

	@Autowired
	private LibrosServicio servicio;
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Libro getLibroById(@PathVariable long id) {

		// Debemos invocar el servicio
		Libro libro = servicio.consultarLibroById(id);

		return libro;
	}
	
	@RequestMapping(path = "/{id}/Autor", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Autor getAutorDeLibroByIdLibro(@PathVariable long id) {
		return servicio.consultarAutorDeLibroByIdLibro(id);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Libro>> getLibrosByTitulo(@RequestParam(name="title") String titulo) {
		
		List<Libro> resultados = null;
		
		if(titulo != null) {
			//Funcionalidad de consultar por titulo
			resultados = servicio.consultarLibrosByTitulo(titulo);
		} else {
			//Funcionalidad de consultar todos
		}
		
		return new ResponseEntity<List<Libro>>(resultados,HttpStatus.OK);
		
	}
	
	//Este método no es compatible con el anterior por coincidir en el RequestMapping
//	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<Libro>> getLibros() {
//		return null;
//	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> postLibro(@RequestBody Libro libro) {

		try {
			// Debemos invocar el servicio
			long id = servicio.altaLibro(libro);

			HttpHeaders headers = new HttpHeaders();

			headers.setLocation(new URI("http://localhost:8280/Libros/" + id));

			HttpStatus status = HttpStatus.CREATED;

			return new ResponseEntity<>(headers, status);

		} catch (URISyntaxException e) {
			e.printStackTrace();

			HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

			return new ResponseEntity<>(status);
		}

	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> putLibro(@RequestBody Libro libro) {

		int numeroRegistrosModificados = servicio.modificarLibro(libro);

		if (numeroRegistrosModificados == 1) {
			HttpStatus status = HttpStatus.OK;

			return new ResponseEntity<>(status);
		} else {
			HttpStatus status = HttpStatus.NOT_MODIFIED;

			return new ResponseEntity<>(status);
		}
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteLibroById(@PathVariable long id) {
		// int numeroRegistrosBorrados = servicio.borrarLibroById(id);

		int numeroRegistrosBorrados = servicio.borrarLibroById(id);

		if (numeroRegistrosBorrados == 1) {
			HttpStatus status = HttpStatus.OK;

			return new ResponseEntity<>(status);
		} else {
			HttpStatus status = HttpStatus.NOT_MODIFIED;

			return new ResponseEntity<>(status);
		}
	}

}
