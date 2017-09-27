package com.accenture.holamundospringbootweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.accenture.holamundospringbootweb.services.AdvancedLibrosServicio;
import com.accenture.holamundospringbootweb.services.LibrosServicio;

@Configuration
public class ServiceConfiguracion {

	@Bean
	public LibrosServicio libroServicio() {
		return new AdvancedLibrosServicio();
	}
	
}
