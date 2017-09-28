package com.accenture.tienda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.accenture.tienda.repository.PedidoRepository;
import com.accenture.tienda.repository.PersonaRepository;
import com.accenture.tienda.repository.ProductoRepository;
import com.accenture.tienda.resources.Pedido;
import com.accenture.tienda.resources.Persona;
import com.accenture.tienda.resources.Producto;

@Service
public class ComprasServiceImpl implements ComprasService {

	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<Producto> buscarByTexto(String texto) {
		return productoRepository.buscarProductoByTexto(texto);
	}

	@Override
	public List<Producto> buscarByPopularidad(int popularidad) {
		return productoRepository.findByPopularidad(popularidad);
	}

	@Override
	public Producto obtenerDetalle(Long id) {
		return productoRepository.findOne(id);
	}

	@Override
	public Persona identificar(String nombre, String pass) {
		return personaRepository.obtenerPersonaByNombreAndPass(nombre, pass);
	}

	@Override
	public long altaPersona(Persona persona) {
		return personaRepository.save(persona).getIdPersona();
	}

	@Override
	public long comprarProducto(Long idPersona, Long idProducto) {

		//Comprobar disponibilidad de producto
		Producto producto = productoRepository.findOne(idProducto);
		int cantidadDeProductoAComprarDisponible = producto.getCantidad();
		if(cantidadDeProductoAComprarDisponible > 0) {
			//Reservarlo, descontando la cantidad
			producto.setCantidad(--cantidadDeProductoAComprarDisponible);
			productoRepository.saveAndFlush(producto);
			
			//Insertar en BD un Pedido
			Pedido pedido = new Pedido(null, idProducto, idPersona, "Empaquetando", null);
			pedidoRepository.save(pedido);
			//Pedir al servicio de cobros, que cobre
			restTemplate.
			//Pedir al servicio de Transporte de envie
			
			//Actualizar estado a esperando al transportista
			
			//Enviar aviso de preparar producto en el almacen
		}
		return 0;
	}

}
