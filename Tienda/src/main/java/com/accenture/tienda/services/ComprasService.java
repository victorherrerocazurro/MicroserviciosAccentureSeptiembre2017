package com.accenture.tienda.services;

import java.util.List;

import com.accenture.tienda.resources.Persona;
import com.accenture.tienda.resources.Producto;
import com.accenture.tienda.resources.Tarjeta;

public interface ComprasService {

	/**
	 * Buscar un porducto, por el texto introducido, buscando en todos los campos del producto
	 * @param texto = texto libre
	 * @return Todos los productos en los que se encuentre en algun campo el texto
	 */
	List<Producto> buscarByTexto(String texto);

	List<Producto> buscarByPopularidad(int popularidad);

	Producto obtenerDetalle(Long id);

	Persona identificar(String nombre, String password);

	long altaPersona(Persona persona);

	long comprarProducto(Long idPersona, Long idProducto, Tarjeta tarjeta);

}