package com.accenture.serviciomensajeria.services;

import com.accenture.serviciomensajeria.resources.Transporte;

public interface MensajeriaServicioInterface {

	/**
	 * Este método se encarga de crear un nuevo transporte de un producto
	 * @param transporte, informacion del cliente de la empresa de transporte, donde se recoge el producto,
	 * donde se entrega el producto
	 * @return idTransporte
	 */
	
	long altaTransporte(Transporte transporte);

}
