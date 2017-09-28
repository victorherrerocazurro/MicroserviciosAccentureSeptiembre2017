package com.accenture.tienda.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.accenture.tienda.resources.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Serializable> {

	@Query("select producto from Producto producto where producto.name.contains(:texto) or producto.descripcion.contains(:texto)")
	List<Producto> buscarProductoByTexto(String texto);

	List<Producto> findByPopularidad(int popularidad);
}