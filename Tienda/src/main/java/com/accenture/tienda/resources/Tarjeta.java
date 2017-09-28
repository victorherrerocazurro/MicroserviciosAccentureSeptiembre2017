package com.accenture.tienda.resources;

public class Tarjeta {

	private long numeroTarjeta;
	private String nombreApellidosTitular;
	private int mes;
	private int anyo;
	private String cvc;
	public long getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(long numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public String getNombreApellidosTitular() {
		return nombreApellidosTitular;
	}
	public void setNombreApellidosTitular(String nombreApellidosTitular) {
		this.nombreApellidosTitular = nombreApellidosTitular;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAnyo() {
		return anyo;
	}
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	public String getCvc() {
		return cvc;
	}
	public void setCvc(String cvc) {
		this.cvc = cvc;
	}
	public Tarjeta(long numeroTarjeta, String nombreApellidosTitular, int mes, int anyo, String cvc) {
		super();
		this.numeroTarjeta = numeroTarjeta;
		this.nombreApellidosTitular = nombreApellidosTitular;
		this.mes = mes;
		this.anyo = anyo;
		this.cvc = cvc;
	}
	public Tarjeta() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Tarjeta [numeroTarjeta=" + numeroTarjeta + ", nombreApellidosTitular=" + nombreApellidosTitular
				+ ", mes=" + mes + ", anyo=" + anyo + ", cvc=" + cvc + "]";
	}
	
}
