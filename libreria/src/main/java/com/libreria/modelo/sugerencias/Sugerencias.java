package com.libreria.modelo.sugerencias;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity

@AllArgsConstructor
@NoArgsConstructor 
@Table(name = "sugerencias")
public class Sugerencias {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	

	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String apellido;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	private String sugerencia;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSugerencia() {
		return sugerencia;
	}


	public void setSugerencia(String sugerencia) {
		this.sugerencia = sugerencia;
	}


	public Sugerencias(Integer id, String nombre, String apellido, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}


	public Sugerencias(String nombre, String apellido, String email) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}


	public Sugerencias(Integer id, String nombre, String apellido, String email, String sugerencia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.sugerencia = sugerencia;
	}


	public Sugerencias() {
		super();
	}
	
	
	
	
	
	
	
	
	
}