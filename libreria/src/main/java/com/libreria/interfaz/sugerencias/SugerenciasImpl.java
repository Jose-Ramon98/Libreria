package com.libreria.interfaz.sugerencias;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.libreria.modelo.sugerencias.Sugerencias;

@Repository("sugerenciasImplJpa")// marcas la clase como compenente de accceso  a datos, lo registra dentro del contenedeor de spring 
public class SugerenciasImpl implements ISugerencias {
	
	

		
		@PersistenceContext// con esto le inyecta el EntityManager(abajo está) segun la configuracion de la unidad de 
		                   //persistencia , operaciones de persistencia como (crear, eliminar...  que en este caso es "em" y es readOnly
		private EntityManager em;// EntityMAnager se llama asi y se importa se encarga de persistir, eliminar, encontrar , actualizar y crear objeto de una bd
	// son consultas de JPA, van a la clase entity (que en este caso es la clase Cliente)
		
		
		
		@SuppressWarnings("unchecked")// esto se hace para quitar las lineas amarillas el warning y te lo pone de forma automatica
		@Transactional(readOnly = true)//Aqui me ha dado un fallo que ya no, he importado otro transactional y no me dejaba usar readOnly
										//Con esta anotacion la marcamos como transactional y solo de lectura, aunque le podriamos poner buscar o eliminar
										// aunque si creas eliminas o algo debes eliminar el readOnly pq ya no solo lees sino que modificas
		@Override
		public List<Sugerencias> findAll() { // esto esta en la interfaz
			 
			return em.createQuery("from Cliente").getResultList();// esto quiere decir que te muestre toda la lista de la clase Cliente(id, nombre email apellido y date)
				
		
		}



		@Override
		@Transactional // sin poner read only
		public void save(Sugerencias sugerencias) {
			em.persist(sugerencias);
			
		}


}
