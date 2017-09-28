package com.accenture.serviciopago.services;

import com.accenture.serviciopago.resources.Tarjeta;

public interface PagoServicioInterface {

	/**
	 * 
	 * @param idClienteServicioPago -> En este caso la tienda online
	 * @param precio
	 * @param tarjeta -> Es cliente de la tienda online que compra el producto
	 */
	public void pagar(long idClienteServicioPago, double precio, Tarjeta tarjeta);
}
