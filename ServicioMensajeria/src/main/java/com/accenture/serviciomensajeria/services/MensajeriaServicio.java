package com.accenture.serviciomensajeria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.serviciomensajeria.repository.MensajeriaRepository;
import com.accenture.serviciomensajeria.resources.Transporte;

@Service
public class MensajeriaServicio implements MensajeriaServicioInterface {

	@Autowired
	private MensajeriaRepository repositorio;

	@Override
	public long altaTransporte(Transporte transporte) {
		// dar de alta de transporte
		return repositorio.save(transporte).getIdTransporte();
		
		//Emitir el cobre del transporte
		
		//Avisar al transportista para que recoja el producto

	}

}
