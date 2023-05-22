
package com.libreria.interfaz;

import java.util.List;

import com.libreria.modelo.Eventos;

public interface IEventos {
	

    public List<Eventos> findAll(); 
		
	
    public void save(Eventos eventos);
}