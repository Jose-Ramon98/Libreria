package com.libreria.interfaz;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.libreria.modelo.Eventos;

@Repository("eventoa")
public class EventosImpl implements  IEventos{

	
	@PersistenceContext
	private EntityManager em;
	
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Eventos> findAll() {
	    return em.createQuery("from Eventos").getResultList();
	}

	@Override
	@Transactional
	public void save(Eventos eventos) {
		em.persist(eventos);
		
	}

}
