package com.libreria.entity;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.libreria.modelo.Libros;


public interface ILibreriaDao extends PagingAndSortingRepository<Libros, Integer> {

}
