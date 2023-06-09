package com.libreria;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login(@RequestParam(value="error", required=false) String error,
			Model model, Principal principal, RedirectAttributes flash){
	 

	    if(principal != null) {
	       flash.addFlashAttribute("error", "No tienes acceso para acceder a esta parte página");
	    }
	    if (error != null) {
	    	model.addAttribute("error","Usuario o contraseña incorrecto, acceso restringido solo para administradores");
	    }

	    return "login";
	}
}
