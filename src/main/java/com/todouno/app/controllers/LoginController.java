package com.todouno.app.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String cargarLogin(Model model, Principal principal, RedirectAttributes flash) {
		
		if (principal != null) {
			
			flash.addAttribute("info", "Ya iniciado sesión anteriormente");
			return"redirect:/";
			
		}
		model.addAttribute("titulo", "Login");
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String accederLogin(Model model, @RequestParam String email, @RequestParam String password) {
		//model.addAttribute("titulo", "Login");
		return "redirect:/catalogo";
	}

}
