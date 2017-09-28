package com.accenture.tienda.resources;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "idpedido")
	private Long idPedido;
	private Long idProducto;
	private Long idPersona;
	private String estado;
	@Column(name = "idtransporte")
	private Long idTransporte;

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", idProducto=" + idProducto + ", idPersona=" + idPersona + ", estado="
				+ estado + ", idTransporte=" + idTransporte + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPedido == null) ? 0 : idPedido.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (idPedido == null) {
			if (other.idPedido != null)
				return false;
		} else if (!idPedido.equals(other.idPedido))
			return false;
		return true;
	}

	public Pedido(Long idPedido, Long idProducto, Long idPersona, String estado, Long idTransporte) {
		super();
		this.idPedido = idPedido;
		this.idProducto = idProducto;
		this.idPersona = idPersona;
		this.estado = estado;
		this.idTransporte = idTransporte;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public Pedido() {
		super();
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getIdTransporte() {
		return idTransporte;
	}

	public void setIdTransporte(Long idTransporte) {
		this.idTransporte = idTransporte;
	}

}
