package com.dev.estacionafacil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dev.estacionafacil.model.Usuario;
import com.dev.estacionafacil.service.UsuarioServiceImpl;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioServiceImpl service;

	@GetMapping("/login")
	public String showLoginForm(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "usuarios/login";
	}

	@PostMapping("/login")
	public String processLogin(@ModelAttribute("usuario") Usuario usuario) {
		Usuario usuarioEncontrado = service.getByEmail(usuario.getEmail());
		if (usuarioEncontrado != null && usuarioEncontrado.getSenha().equals(usuario.getSenha())) {
			return "redirect:usuarios/saldo";
		} else {
			return "usuarios/saldo";
		}
	}

	@GetMapping("/cadastro")
	public String showRegisterForm(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "usuarios/cadastro";
	}

	@PostMapping("/cadastro")
	public String processRegistration(@ModelAttribute("usuario") Usuario usuario) {
		service.salvar(usuario);
		return "redirect:/login";
	}

	@GetMapping("/saldo")
	public String showSaldo() {
		return "usuarios/saldo";
	}

	@GetMapping("/vaga")
	public String mostrarVagas() {
		return "estacionamento/vaga";
	}

}
