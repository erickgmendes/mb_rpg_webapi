package com.erickgm.sharpsword.application.mappers;

import java.util.ArrayList;
import java.util.List;

import com.erickgm.sharpsword.application.dto.response.UsuarioDtoResponse;
import com.erickgm.sharpsword.domain.entities.Usuario;

public class UsuarioMapper {

	public static UsuarioDtoResponse mapToDtoResponse(Usuario usuario) {
		UsuarioDtoResponse response = new UsuarioDtoResponse();

		response.setId(usuario.getId());
		response.setNome(usuario.getNome());
		response.setLogin(usuario.getLogin());

		return response;
	}

	public static List<UsuarioDtoResponse> mapToListDtoResponse(List<Usuario> usuarios) {

		List<UsuarioDtoResponse> listaResponse = new ArrayList<UsuarioDtoResponse>();

		for (Usuario usuario : usuarios) {
			UsuarioDtoResponse response = mapToDtoResponse(usuario);
			listaResponse.add(response);
		}

		return listaResponse;
	}
	
}