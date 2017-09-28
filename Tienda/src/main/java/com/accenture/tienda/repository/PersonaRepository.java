package com.accenture.tienda.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accenture.tienda.resources.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Serializable> {

	@Query("select persona from Persona persona where persona.nombre= :nombre and persona.password=:pass")
	Persona obtenerPersonaByNombreAndPass(String nombre, String pass);

}
