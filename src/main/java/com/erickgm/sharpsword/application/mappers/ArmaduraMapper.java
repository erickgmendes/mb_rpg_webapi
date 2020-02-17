package com.erickgm.sharpsword.application.mappers;

import java.util.ArrayList;
import java.util.List;

import com.erickgm.sharpsword.application.dto.response.ArmaduraDtoResponse;
import com.erickgm.sharpsword.domain.entities.Armadura;

public class ArmaduraMapper {

	public static ArmaduraDtoResponse mapToDtoResponse(Armadura armadura) {
		ArmaduraDtoResponse dto = new ArmaduraDtoResponse();

		dto.setId(armadura.getId());
		dto.setNome(armadura.getNome());
		dto.setCusto(armadura.getCusto());
		dto.setDefesa(armadura.getDefesa());
		dto.setFn(armadura.getFn());
		dto.setPeso(armadura.getPeso());
		dto.setObservacoes(armadura.getObservacoes());

		return dto;
	}

	public static List<ArmaduraDtoResponse> mapToListDtoResponse(List<Armadura> armaduras) {

		List<ArmaduraDtoResponse> listaResponse = new ArrayList<ArmaduraDtoResponse>();

		for (Armadura armadura : armaduras) {
			ArmaduraDtoResponse response = mapToDtoResponse(armadura);
			listaResponse.add(response);
		}

		return listaResponse;
	}

}