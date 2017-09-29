package com.accenture.tienda.controllers;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.accenture.tienda.resources.Pedido;
import com.accenture.tienda.services.ComprasService;

@RestController
@RequestMapping(path = "/Pedido")
public class PedidoRestController {

	@Autowired
	private ComprasService servicio;

	/**
	 * Se encargar de generar el pedido asociado al producto y a la persona (La compra)
	 * 
	 * @return
	 * @throws URISyntaxException
	 * @throws RestClientException
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> post(@RequestBody Pedido pedido) {
		ResponseEntity<Void> respuesta;
		//TODO Faltaria recuperar los datos de la tarjeta de credito del usuario para realizar el pago
		servicio.comprarProducto(pedido.getIdPersona(), pedido.getIdProducto(), null);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
