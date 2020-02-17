package com.erickgm.sharpsword.application.mappers;

import java.util.ArrayList;
import java.util.List;

import com.erickgm.sharpsword.application.dto.response.MunicaoDtoResponse;
import com.erickgm.sharpsword.domain.entities.Municao;

public class MunicaoMapper {

	public static MunicaoDtoResponse mapToDtoResponse(Municao municao) {
		MunicaoDtoResponse response = new MunicaoDtoResponse();

		response.setId(municao.getId());
		response.setNome(municao.getNome());
		response.setCusto(municao.getCusto());
		response.setPeso(municao.getPeso());
		response.setDescricao(municao.getDescricao());
		
		return response;
	}

	public static List<MunicaoDtoResponse> mapToListDtoResponse(List<Municao> municoes) {

		List<MunicaoDtoResponse> listaResponse = new ArrayList<MunicaoDtoResponse>();

		for (Municao municao : municoes) {
			MunicaoDtoResponse response = mapToDtoResponse(municao);
			listaResponse.add(response);
		}

		return listaResponse;
	}
	
}
