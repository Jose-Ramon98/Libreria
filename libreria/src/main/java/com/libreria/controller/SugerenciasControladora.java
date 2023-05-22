package com.libreria.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.libreria.interfaz.sugerencias.SugerenciasImpl;
import com.libreria.modelo.sugerencias.Sugerencias;

@Controller 
@RequestMapping("/registro")
public class SugerenciasControladora {
	@Qualifier("sugerenciasImplJpa")// si hay varias inyecciones de dependencia debemos especificar cada una, asi spring sabra a cual nos referimos, en este caso esta se llama clienteJpa
	private final SugerenciasImpl sugerenciasDao;

    SugerenciasControladora(SugerenciasImpl sugerenciasDao) {
        this.sugerenciasDao = sugerenciasDao;
    }//IClienteDao quiere decir que implementamos la interfaz la interfaz se llama asi
     
	@RequestMapping(value="listar", method = RequestMethod.GET)//podriamos usar el getMApping estaria exactamente igual de bien, es solo para variar
	public String listar(Model model) {
		model.addAttribute("titulo","Listado de clientes");
		model.addAttribute("sugerencia", sugerenciasDao.findAll());
		return "listar";
	
	
	}
	
	@RequestMapping(value="/form",method = RequestMethod.GET)
	public String crear(Map<String, Object> model){// podriamos usar Model que seria exactamente lo mismo, pero para variar vamos a usar Map
	
		Sugerencias sugerencias = new Sugerencias();
		model.put("sugerencias", sugerencias);
		model.put("titulo", "Nos interesa su opinión");
			
	return "form";
	
	
	}
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String guardar(@Valid Sugerencias sugerencias,BindingResult result,RedirectAttributes ra,Model model) {
		
		ra.addFlashAttribute("msgExito", "La sugerencia ha sido enviada con éxito a nuestra base de datos.");
		if(result.hasErrors()) {//Con esto impide que te salga la pantalla con error 404
			model.addAttribute("titulo", "Formulario cliente");
			return "form";
		}

	
	sugerenciasDao.save(sugerencias);

	return "redirect:/registro/form";

}
}