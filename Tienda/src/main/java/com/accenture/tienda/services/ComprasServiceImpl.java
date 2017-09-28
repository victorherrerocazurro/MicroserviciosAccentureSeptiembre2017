package com.accenture.tienda.services;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.accenture.tienda.repository.PedidoRepository;
import com.accenture.tienda.repository.PersonaRepository;
import com.accenture.tienda.repository.ProductoRepository;
import com.accenture.tienda.resources.Cliente;
import com.accenture.tienda.resources.Cobro;
import com.accenture.tienda.resources.Contacto;
import com.accenture.tienda.resources.Pedido;
import com.accenture.tienda.resources.Persona;
import com.accenture.tienda.resources.Producto;
import com.accenture.tienda.resources.Tarjeta;
import com.accenture.tienda.resources.Transporte;

@Service
public class ComprasServiceImpl implements ComprasService {

	private static final int IDENTIFICADOR_DE_LA_TIENDA_ONLINE_EN_EL_BANCO = 1234;
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

	//Orquestacion de servicios
	@Override
	public long comprarProducto(Long idPersona, Long idProducto, Tarjeta tarjeta) {
		try{
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
				Cobro cobro = new Cobro(IDENTIFICADOR_DE_LA_TIENDA_ONLINE_EN_EL_BANCO, producto.getPrecio(), tarjeta);
				ResponseEntity<Void> respuestaDelServicioCobro = restTemplate.postForEntity(new URI("http://localhost:8280/tramitarCobro"), cobro, Void.class);
				if (respuestaDelServicioCobro.getStatusCode().equals(HttpStatus.ACCEPTED)) {
					//Pedir al servicio de Transporte que envie
					Persona persona = personaRepository.findOne(idPersona);
					Transporte transporte = new Transporte(null, new Cliente(), new Contacto(persona.getDireccion(), persona.getNombre()), pedido.getIdPedido(), null);
					ResponseEntity<Long> respuestaDelServicioDeTransporte = restTemplate.postForEntity(new URI("hattp://localhost:8480/Transporte"), transporte, Long.class);
					//Actualizar estado a esperando al transportista
					pedido.setIdTransporte(respuestaDelServicioDeTransporte.getBody());
					pedido.setEstado("Esperando al transportista");
					pedidoRepository.save(pedido);
					//Enviar aviso de preparar producto en el almacen
				} else {
					//Hay que revertir las operaciones iniciadas, en este caso volver el valor de cantidad al producto
				}
				
			}
		} catch(Exception ex) {
			throw new RuntimeException(ex);
		}
		return 0;
	}

}
