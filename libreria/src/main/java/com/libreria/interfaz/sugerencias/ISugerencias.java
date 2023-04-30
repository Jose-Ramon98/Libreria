package com.libreria.interfaz.sugerencias;

import java.util.List;

import com.libreria.modelo.sugerencias.Sugerencias;



public interface ISugerencias {
	public List<Sugerencias> findAll(); //Cliente es la clase entity(pq asi se llama su package) que esta mapeada a la bd
	//findAll retornar todos los datos, creo q que significa que cualquier clase que use esto public List<Cliente> finAll(); significa que esta mapeada a esta interfaz

	public void save(Sugerencias sugerencias);
}
