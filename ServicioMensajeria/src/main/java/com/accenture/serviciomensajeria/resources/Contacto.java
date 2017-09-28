package com.accenture.serviciomensajeria.resources;

public class Contacto {
	private String direccion;
	private String nombre;
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Contacto(String direccion, String nombre) {
		super();
		this.direccion = direccion;
		this.nombre = nombre;
	}
	public Contacto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
