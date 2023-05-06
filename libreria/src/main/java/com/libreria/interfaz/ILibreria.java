package com.libreria.interfaz;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.libreria.modelo.Libros;



public interface ILibreria {

	public List<Libros> findAll();
	public Libros buscarPorid(Integer idVacante);
	public void save(Libros libros);
	public Libros findOne(Integer id);
	public void delete(Integer id);




	
}
