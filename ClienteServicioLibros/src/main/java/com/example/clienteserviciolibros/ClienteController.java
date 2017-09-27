package com.example.clienteserviciolibros;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClienteController {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(path="/obtenerSaludo")
	public String obtenerMensajeSaludoDelServidor(String nombre) throws RestClientException, URISyntaxException {
		//Invocar al servicio remoto, para obtener el saludo
		
		String saludo = restTemplate.getForObject(new URI("http://localhost:8280/pepito"), String.class);
		
		return saludo + nombre;
	}
	
}
