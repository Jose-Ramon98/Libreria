package com.libreria.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.libreria.interfaz.ILibreria;
import com.libreria.modelo.Libros;



@Controller
public class LibreriaControladora {
	
@Autowired
private ILibreria libreria;


@GetMapping("/")

public String mostrarHome (){
	
	return "index";
}

@GetMapping("libreria")
@PostMapping("/libreria")
public String mostrarLibreria(Model model) {

	List<Libros> lista = libreria.buscarTodas();	

	model.addAttribute("vacantes", lista);//Agregamos una lista de tipos vacantes, obtenida gracias metodo getVacantes
	return "tabla";

}






@GetMapping("/libros/nuevo")
public String mostrarFormularioNuevoLibro(Model model) {
    model.addAttribute("libro", new Libros());
    return "nuevo-libro";
}


@PostMapping("/libros/nuevo")
public String agregarLibro(@ModelAttribute("libro") Libros libro, Model model) {
    libreria.guardar(libro);
    return "redirect:/libreria";
}


}




