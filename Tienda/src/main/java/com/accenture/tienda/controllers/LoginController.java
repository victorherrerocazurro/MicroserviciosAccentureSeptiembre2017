package com.accenture.tienda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accenture.tienda.resources.Persona;
import com.accenture.tienda.services.ComprasService;

@Controller
public class LoginController {
	
	@Autowired
	private ComprasService servicio;
	
	/**
	 * Devuelve la persona identificada en el sistema
	 * 
	 * @return
	 */
	@RequestMapping(path = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Persona> login(@RequestBody Persona persona) {
		ResponseEntity<Persona> respuesta;
		Persona resultado = servicio.identificar(persona.getNombre(), persona.getPassword());
		if (resultado != null) {// existe el usuario
			respuesta = new ResponseEntity<>(resultado, HttpStatus.OK);
		} else {
			respuesta = new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);
		}
		return respuesta;
	}
}
