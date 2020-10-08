package com.todouno.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.todouno.app.models.Service.IUsuarioService;
import com.todouno.app.models.entity.Usuario;

@Controller
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@RequestMapping(value = "/registrar")
	public String crear(Model model) {
		
		Usuario usuario = new Usuario(); 
		model.addAttribute("titulo", "Registro Usuario");
		model.addAttribute("usuario", usuario);
		return "registrar";
	}
	
	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	public String registrar(@Valid Usuario usuario, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Registro Usuario");
			return "registrar";
		}
		
		usuarioService.save(usuario);
		return "redirect:login";
	}
}
