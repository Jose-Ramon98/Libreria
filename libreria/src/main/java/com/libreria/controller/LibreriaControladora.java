package com.libreria.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

@GetMapping({"libreria",("")})
@PostMapping("/libreria")
public String mostrarLibreria(Model model) {

	List<Libros> lista = libreria.findAll();	

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
    libreria.save(libro);
    return "redirect:/libreria";
}

@GetMapping("/libros/{id}/editar")
public String mostrarFormularioEditar(@PathVariable("id") Integer id, Model model, RedirectAttributes flash) {
    Libros libro = libreria.findOne(id);
   
    model.addAttribute("libro", libro);
    model.addAttribute("titulo", "Editar Libro");
    return "editar-libro";
}
@PostMapping("/libros/{id}/editar")
public String guardarEdicion(@PathVariable("id") Integer id, @ModelAttribute("libro") Libros libro, Model model) {
    Libros libroActualizado = libreria.findOne(id);
    if (libroActualizado == null) {
        model.addAttribute("error", "El ID del libro no existe en la BBDD!");
        return "editar-libro";
    }
    libroActualizado.setTitulo(libro.getTitulo());
    libroActualizado.setAutor(libro.getAutor());
    libroActualizado.setDescripcion(libro.getDescripcion());
    libroActualizado.setPromocionado(libro.getPromocionado());
    libroActualizado.setPrecio(libro.getPrecio());
    libreria.save(libroActualizado);
    return "redirect:/libreria";
}


@PostMapping("/libros/{id}/eliminar")
public String eliminar(@PathVariable(value = "id")Integer id, RedirectAttributes flash) {
	
	if(id>0) {
		libreria.delete(id);
		flash.addFlashAttribute("success", "Libro eliminado con éxito!");
	}
	
	return "redirect:/libreria";
}

@PostMapping("/stock")
public String agregarStock(@ModelAttribute("libro") Libros libro, Model model) {
    
	libro.setStock(20); // Inicialmente se establece un stock de 20 copias
    libreria.save(libro);
    return "redirect:/libreria";
}

@PostMapping("/libros/{id}/comprar")
public String comprarLibro(@PathVariable("id") Integer id, Model model) {
    Libros libro = libreria.findOne(id);
    if (libro != null && libro.getStock() > 0) {
        libro.setStock(libro.getStock() - 1); 
        libreria.save(libro);
        return "redirect:/libreria";
    } else {
    	model.addAttribute("error", "No hay existencias de este libro para comprar");
        List<Libros> lista = libreria.findAll(); // Obtener la lista de libros
        model.addAttribute("vacantes", lista); // Agregar la lista a la vista
        return "tabla";
       
    }
}

@PostMapping("/libros/{id}/devolver")
public String devolverLibro(@PathVariable("id") Integer id, Model model) {
    Libros libro = libreria.findOne(id);
    if (libro != null) {
        libro.setStock(libro.getStock() + 1);
        libreria.save(libro);
        return "redirect:/libreria";
    } else {
        model.addAttribute("error", "No se puede devolver este libro porque no está registrado en la librería");
        return "error";
    }
}




@GetMapping("/mapa")
public String mapa(){
return "mapa";
   
}
}




