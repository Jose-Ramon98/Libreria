package com.libreria.interfaz;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.libreria.entity.ILibreriaDao;
import com.libreria.modelo.Libros;

@Service
public class LibreriaImpl implements ILibreria{
	
	
 private List<Libros> lista = null;

@Autowired
private ILibreriaDao libreriadao;

 @Override
 @Transactional(readOnly = true)
public List<Libros> findAll() {
	
	return (List<Libros>) libreriadao.findAll();
	}
 @Override
 @Transactional
	public void save(Libros libros) { // este override me obliga a ponerlo por la interfaz
		libreriadao.save(libros);// con esto decimos que lo guarde en la lista vacante, escrita arriba
		
	}

@Override
@Transactional(readOnly = true)
public Libros findOne(Integer id) {
	
	return libreriadao.findById(id).orElse(null);
}
@Override
@Transactional
public void delete(Integer id) {
	libreriadao.deleteById(id);
	
}
@Override
public Libros buscarPorid(Integer idVacante) {
	// TODO Auto-generated method stub
	return null;
}
 
 
 
	
}