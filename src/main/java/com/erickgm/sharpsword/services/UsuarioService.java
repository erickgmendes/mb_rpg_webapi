package com.erickgm.sharpsword.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erickgm.sharpsword.domain.entities.Usuario;
import com.erickgm.sharpsword.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}

	public Usuario obterUsuarioPeloId(long id) {
		return usuarioRepository.findById(id);
	}
}
