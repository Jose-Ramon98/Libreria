package com.libreria.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Libros {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idpsicologia")
	private Integer id;
	private String titulo;
	public Libros(Integer id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;

	}
	public Libros() {
		super();
	}
	private String autor;
	private String descripcion;
	private Integer promocionado;


	
	
	
	public Libros(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Libros [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", descripcion=" + descripcion
				+ ", promocionado=" + promocionado + "]";
	}
	public Integer getPromocionado() {
		return promocionado;
	}
	public void setPromocionado(Integer promocionado) {
		this.promocionado = promocionado;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	}
