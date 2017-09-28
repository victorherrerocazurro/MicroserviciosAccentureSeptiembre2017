package com.accenture.serviciopago.services;

import com.accenture.serviciopago.resources.Tarjeta;

public interface PagoServicioInterface {

	public void pagar(long idClienteServicioPago, double precio, Tarjeta tarjeta);
}
