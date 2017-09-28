package com.accenture.tienda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.tienda.resources.Persona;
import com.accenture.tienda.services.ComprasService;

@RestController
@RequestMapping(path = "/Personas")
public class PersonaRestController {

	@Autowired
	private ComprasService servicio;

	/**
	 * Se encarga de dar de alta a una persona
	 * 
	 * @param idpersona
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> post(@RequestBody Persona persona) {
		servicio.altaPersona(persona);		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
