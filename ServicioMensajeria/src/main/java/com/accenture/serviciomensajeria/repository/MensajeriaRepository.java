package com.accenture.serviciomensajeria.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.serviciomensajeria.resources.Transporte;

public interface MensajeriaRepository extends JpaRepository<Transporte, Serializable> {
	
}
