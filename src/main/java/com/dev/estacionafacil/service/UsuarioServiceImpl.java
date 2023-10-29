package com.dev.estacionafacil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.estacionafacil.model.Usuario;
import com.dev.estacionafacil.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public List<Usuario> getAll() {
		return repository.findAll();
	}

	@Override
	public Usuario getByEmail(String email) {
		return repository.findByEmail(email);
	}

	@Override
	public void salvar(Usuario usuario) {
		repository.save(usuario);
	}

	@Override
	public void excluir(Usuario usuario) {
		repository.delete(usuario);
	}

}
