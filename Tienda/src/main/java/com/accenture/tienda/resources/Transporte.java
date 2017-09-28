package com.accenture.tienda.resources;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "transportes")
public class Transporte implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	private Long idTransporte;
	private Cliente cliente; //En este caso la tienda online
	private Contacto contactoDestino;
	private long idPedido;
	private String estado;

	public Transporte() {
		super();
	}

	public Long getIdTransporte() {
		return idTransporte;
	}

	public void setIdTransporte(Long idTransporte) {
		this.idTransporte = idTransporte;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Contacto getContactoDestino() {
		return contactoDestino;
	}

	public void setContactoDestino(Contacto contactoDestino) {
		this.contactoDestino = contactoDestino;
	}

	public long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Transporte(Long idTransporte, Cliente cliente, Contacto contactoDestino, long idPedido, String estado) {
		super();
		this.idTransporte = idTransporte;
		this.cliente = cliente;
		this.contactoDestino = contactoDestino;
		this.idPedido = idPedido;
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Transporte [idTransporte=" + idTransporte + ", cliente=" + cliente + ", contactoDestino="
				+ contactoDestino + ", idPedido=" + idPedido + ", estado=" + estado + "]";
	}

	
}
