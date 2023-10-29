package com.dev.estacionafacil.service;

import java.util.List;

import com.dev.estacionafacil.model.Usuario;

public interface UsuarioService {
	
	public List<Usuario> getAll();
	
	public Usuario getByEmail(String email);
	
	public void salvar(Usuario usuario);
	
	public void excluir(Usuario usuario);

}
