package com.accenture.holamundospringbootweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.accenture.holamundospringbootweb.controllers.HolaMundoController;

@SpringBootApplication
//Activa la interpretacion de la anotacion @Bean
//@Configuration
//Permite encontrar clases anotadas con @ controller, @Component, @Repository o @Service
//@ComponentScan(basePackages="com.accenture.holamundospringbootweb")
//Por refereir en el pom.xml el starter-web, tambien se añade esta anotacion
//@EnableWebMvc
public class HolaMundoSpringBootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(HolaMundoSpringBootWebApplication.class, args);
	}
	
	//Permite definir Beans en el contexto de Spring
//	@Bean
//	public HolaMundoController miBeanController() {
//		return new HolaMundoController();
//	}
	
	
	
}
