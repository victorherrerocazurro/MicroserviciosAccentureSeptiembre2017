package com.accenture.holamundospringbootweb.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoController {

		@RequestMapping("/pepito")
		//@ResponseBody
		public String holaMundo() {
			return "Hola ";
		}
	
}