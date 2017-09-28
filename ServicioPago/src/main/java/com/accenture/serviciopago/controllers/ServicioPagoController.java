package com.accenture.serviciopago.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.serviciopago.resources.Cobro;
import com.accenture.serviciopago.resources.Tarjeta;
import com.accenture.serviciopago.services.PagoServicio;

@RestController
public class ServicioPagoController {

	@Autowired
	private PagoServicio servicio;

	@RequestMapping(path = "/tramitarCobro", method=RequestMethod.POST)
	public ResponseEntity<Void> pagar(@RequestBody Cobro cobro) {
		servicio.pagar(cobro.getIdClienteServicioPago(), cobro.getPrecio(), cobro.getTarjeta());
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
