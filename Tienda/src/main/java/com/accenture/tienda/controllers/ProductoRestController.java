package com.accenture.tienda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.tienda.resources.Producto;
import com.accenture.tienda.services.ComprasService;
import com.accenture.tienda.services.MantenimientoService;

@RestController
@RequestMapping(path = "/Producto")
public class ProductoRestController {

	@Autowired
	private MantenimientoService servicioMantenimiento;
	@Autowired
	private ComprasService servicioCompras;

	/**
	 * Buscar un producto por un texto concreto
	 * 
	 * @param texto
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Producto>> getByTextoOrPopularidad(@RequestParam(required=false) String texto, @RequestParam(required=false) Integer popularidad) {
		
		ResponseEntity<List<Producto>> respuesta;
		List<Producto> productos = null;
		
		if(popularidad == null && texto == null) {
			respuesta = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		} else if(popularidad != null ) {
			productos = servicioCompras.buscarByPopularidad(popularidad);
		} else {
			productos = servicioCompras.buscarByTexto(texto);
		}

		if (productos != null) {
			respuesta = new ResponseEntity<List<Producto>>(productos, HttpStatus.OK);
		} else {
			respuesta = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return respuesta;
	}

	/**
	 * Devuelve un producto por id de producto
	 * 
	 * @return
	 */
	@RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> getById(@PathVariable Long id) {
		ResponseEntity<Producto> respuesta;
		Producto producto = servicioCompras.obtenerDetalle(id);
		if (producto != null) {
			respuesta = new ResponseEntity<Producto>(producto, HttpStatus.OK);
		} else {
			respuesta = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return respuesta;
	}

	/**
	 * Se agrega un producto nuevo a la base de datos
	 * 
	 * @param producto
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> altaProducto(@RequestBody Producto producto) {
		servicioMantenimiento.altaProducto(producto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
