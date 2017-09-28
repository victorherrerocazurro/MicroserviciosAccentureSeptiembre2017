package com.accenture.serviciopago.services;

import org.springframework.stereotype.Service;

import com.accenture.serviciopago.resources.Tarjeta;

@Service
public class PagoServicio implements PagoServicioInterface {

	@Override
	public void pagar(long idClienteServicioPago, double precio, Tarjeta tarjeta) {
		//Restar de la tarjeta la cantidad del cobro
//		CuentaCorriente ccOrigen =cuentaCorrienteRepository.findByNumeroTarjeta(tarjeta.getNumeroTarjeta());
//		ccOrigen.sacarDinero(precio);
//		cuentaCorrienteRepository.saveAndFlush(ccOrigen);
		//Acceder a la CC del Cliente para sumar la cantidad del cobro menos el % de comision que se lleva el banco
//		CuentaCorriente ccDestino = cuentaCorrienteRepository.findByIdCliente(idClienteServicioPago);
//		ccDestino.ingresarDinero(precio);
//		cuentaCorrienteRepository.saveAndFlush(ccDestino);
	}



}
