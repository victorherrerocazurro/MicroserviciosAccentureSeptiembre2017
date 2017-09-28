package com.accenture.serviciopago.resources;

public class Cobro {
	private long idClienteServicioPago;
	private double precio;
	private Tarjeta tarjeta;
	
	public long getIdClienteServicioPago() {
		return idClienteServicioPago;
	}
	public void setIdClienteServicioPago(long idClienteServicioPago) {
		this.idClienteServicioPago = idClienteServicioPago;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Tarjeta getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
	public Cobro(long idClienteServicioPago, double precio, Tarjeta tarjeta) {
		super();
		this.idClienteServicioPago = idClienteServicioPago;
		this.precio = precio;
		this.tarjeta = tarjeta;
	}
	public Cobro() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Cobro [idClienteServicioPago=" + idClienteServicioPago + ", precio=" + precio + ", tarjeta=" + tarjeta
				+ "]";
	}
	
	
}
