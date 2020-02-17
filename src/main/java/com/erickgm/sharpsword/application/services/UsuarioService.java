package com.erickgm.sharpsword.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erickgm.sharpsword.application.dto.request.UsuarioDtoRequest;
import com.erickgm.sharpsword.application.dto.response.UsuarioDtoResponse;
import com.erickgm.sharpsword.application.mappers.UsuarioMapper;
import com.erickgm.sharpsword.domain.entities.Usuario;
import com.erickgm.sharpsword.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<UsuarioDtoResponse> listarUsuarios() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		return UsuarioMapper.mapToListDtoResponse(usuarios);
	}

	public UsuarioDtoResponse obterUsuarioPeloId(long id) {
		Usuario usuario =  usuarioRepository.findById(id);
		return UsuarioMapper.mapToDtoResponse(usuario);
	}

	public UsuarioDtoResponse incluirUsuario(UsuarioDtoRequest dto) {
		if (dto == null) {
			return null;
		}

		Usuario usuario = usuarioRepository.findByNome(dto.getNome());
		if (usuario != null) {
			return UsuarioMapper.mapToDtoResponse(usuario);
		}

		usuario = new Usuario(null, dto.getNome(), dto.getLogin(), dto.getSenha());				
		usuario = usuarioRepository.save(usuario);

		return UsuarioMapper.mapToDtoResponse(usuario);
	}

	public UsuarioDtoResponse alterarUsuario(long id, UsuarioDtoRequest dto) {
		Usuario usuario = usuarioRepository.findById(id);
		
		usuario.modificaValores(dto.getNome(), dto.getLogin(), dto.getSenha());		
		
		usuarioRepository.save(usuario);
		
		return UsuarioMapper.mapToDtoResponse(usuario);
	}

	public boolean excluirUsuario(long id) {
		Usuario usuario = usuarioRepository.findById(id);

		if (usuario == null) {
			return false;
		}

		usuarioRepository.delete(usuario);

		return true;
	}

}
