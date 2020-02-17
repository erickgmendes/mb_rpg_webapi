package com.erickgm.sharpsword.application.mappers;

import java.util.ArrayList;
import java.util.List;

import com.erickgm.sharpsword.application.dto.response.ClasseDtoResponse;
import com.erickgm.sharpsword.domain.entities.Classe;

public class ClasseMapper {

	public static ClasseDtoResponse mapToDtoResponse(Classe classe) {
		ClasseDtoResponse response = new ClasseDtoResponse();

		response.setId(classe.getId());
		response.setNome(classe.getNome());

		return response;
	}

	public static List<ClasseDtoResponse> mapToListDtoResponse(List<Classe> classes) {

		List<ClasseDtoResponse> listaResponse = new ArrayList<ClasseDtoResponse>();

		for (Classe classe : classes) {
			ClasseDtoResponse response = mapToDtoResponse(classe);
			listaResponse.add(response);
		}

		return listaResponse;
	}

}
