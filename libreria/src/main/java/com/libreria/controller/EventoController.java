package com.libreria.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.libreria.interfaz.EventosImpl;
import com.libreria.interfaz.IEventos;
import com.libreria.modelo.Eventos;


@Controller
@RequestMapping("/events")
public class EventoController {

    private final IEventos eventosDao;

    public EventoController(@Qualifier("eventoa") IEventos eventosDao) {
        this.eventosDao = eventosDao;
    }

    @GetMapping("/eventos")
    public String eventos() {
        return "eventos";
    }

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public String listar(Model model) {
        model.addAttribute("titulo", "Inscripcion");
        List<Eventos> eventosList = eventosDao.findAll();
        if (!eventosList.isEmpty()) {
            Eventos eventos = eventosList.get(0);
            model.addAttribute("eventos", eventos);
        }
        return "listar";
    }


    @GetMapping("/eventosCrear")
    public String crear(Map<String, Object> model){
        Eventos eventos = new Eventos();
        model.put("eventos", eventos);      
        return "eventos";
    }

    @PostMapping("/eventosCrear")
    public String guardar(@Valid Eventos eventos, BindingResult result, RedirectAttributes ra, Model model) {
        ra.addFlashAttribute("msgExito", "Se he inscrito correctamente");
        if(result.hasErrors()) {
            model.addAttribute("titulo", "Formulario cliente");
            return "eventos";
        }
        eventosDao.save(eventos);
        return "redirect:/eventos";
    }
}