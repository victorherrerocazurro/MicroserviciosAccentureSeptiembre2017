package com.accenture.tienda.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tienda.repository.ProductoRepository;
import com.accenture.tienda.resources.Producto;

@Service
public class MantenimientoServiceImpl implements MantenimientoService {

	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public long altaProducto(Producto producto) {
		return productoRepository.save(producto).getIdProducto();
	}
}
