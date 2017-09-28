package com.accenture.tienda.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.tienda.resources.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Serializable> {

}
