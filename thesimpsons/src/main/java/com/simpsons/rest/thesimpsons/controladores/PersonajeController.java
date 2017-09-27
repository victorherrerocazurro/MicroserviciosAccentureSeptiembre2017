package com.simpsons.rest.thesimpsons.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simpsons.rest.thesimpsons.recursos.Personaje;

@RestController
@RequestMapping(path="/Personajes")
public class PersonajeController {

	//Implementamos la peticion de consulta por Id
	@RequestMapping(path="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Personaje> getPersonajeById(@PathVariable String id) {
		return new ResponseEntity<Personaje>(new Personaje(), HttpStatus.OK);
	}
	
	/**
	 * Metodo que retorna el Personaje que es padre de otro personaje, conociendo el Id del personaje hijo.
	 * @return
	 */
	
	//Implementamos la peticion de consulta del padre por Id del Hijo
	@RequestMapping(path="/{id}/padre", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Personaje> getPadreByIdHijo(@PathVariable String id){
		return null;
	}
	
	//Implementar la peticion de consulta por apellido e
	//Implementar la peticion de consulta de todos los personajes
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Personaje>> getPersonajesByApellido(@RequestParam(required=false) String apellido){
		if(apellido == null) {
			//peticion de consulta de todos los personajes
		} else {
			//peticion de consulta por apellido
		}
		return null;
	}
	
	//Implementar añadir un personaje
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> postPersonaje(@RequestBody Personaje personaje){
		return null;
	}
	
	//Implementar Borrar personaje
	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletePersonajeById(@PathVariable String id) {
		return null;
	}
	
	//Implementar Modificar Personaje
	@RequestMapping(method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> putPersonaje(@RequestBody Personaje personaje) {
		return null;
	}
	
}
