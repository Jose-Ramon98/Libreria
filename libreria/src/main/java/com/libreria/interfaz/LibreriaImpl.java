package com.libreria.interfaz;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.libreria.modelo.Libros;




@Service
public class LibreriaImpl implements ILibreria{
 private List<Libros> lista = null;


 public LibreriaImpl() {
 
	 lista = new LinkedList<Libros>();
		
		Libros libro1 = new Libros();
		libro1.setId(1);
		libro1.setTitulo("Meditaciones");
		libro1.setAutor("Marco Aurelio");
		libro1.setDescripcion("Libros sobre sobre la corriente filosofica estoica");
		libro1.setPromocionado(1);
		
		
		Libros libro2 = new Libros();
		libro2.setId(2);
		libro2.setTitulo("Crimen y castido");
		libro2.setAutor("Fiodor Dostoiesxky");
		libro2.setDescripcion("Libro mundialmente conocido del escritor Ruso");
		libro2.setPromocionado(1);
		
		Libros libro3 = new Libros();
		libro3.setId(3);
		libro3.setTitulo("Freshwater");
		libro3.setAutor("Virginia Wolf");
		libro3.setDescripcion("Libros sobre sobre la corriente filosofica estoica");
		libro3.setPromocionado(0);
		
		Libros libro4 = new Libros();
		libro4.setId(4);
		libro4.setTitulo("DSM V");
		libro4.setAutor("Sociedad Estado Unidense de psiquiatria");
		libro4.setDescripcion("Libros sobre sobre la corriente filosofica estoica");
		libro4.setPromocionado(0);
		
		/**
		 * 
		 */
		lista.add(libro1);
		lista.add(libro2);
		lista.add(libro3);
		lista.add(libro4);
 }
 
 
 
 
 
 @Override
public List<Libros> buscarTodas() {
	// TODO Auto-generated method stub
	return lista;
}
 @Override
	public void guardar(Libros libros) { // este override me obliga a ponerlo por la interfaz
		lista.add(libros);// con esto decimos que lo guarde en la lista vacante, escrita arriba
		
	}





@Override
public Libros buscarPorid(Integer idVacante) {
	// TODO Auto-generated method stub
	return null;
} 
 
 
	
}