package com.accenture.serviciomensajeria.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.serviciomensajeria.resources.Transporte;
import com.accenture.serviciomensajeria.services.MensajeriaServicioInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
public class MensajeriaController {

	@Autowired
	private MensajeriaServicioInterface servicio;

	@RequestMapping(path = "/transporte", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Long> altaTransporte(@RequestBody Transporte transporte) {
		return new ResponseEntity<Long>(servicio.altaTransporte(transporte), HttpStatus.OK);
	}
}
