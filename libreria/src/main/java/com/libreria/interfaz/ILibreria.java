package com.libreria.interfaz;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.libreria.modelo.Libros;



public interface ILibreria {

	List<Libros> buscarTodas();
	Libros buscarPorid(Integer idVacante);
	void guardar(Libros libros);





	
}
