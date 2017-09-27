package com.accenture.holamundospringbootweb.recursos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BOOKS")
public class Libro implements Serializable{
	@Id
	private Long id;
	@Column(name="TITLE")
	private String titulo;
	
	public Libro() {
		super();
	}
	public Libro(long id, String titulo) {
		this.id = id;
		this.titulo = titulo;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
}
