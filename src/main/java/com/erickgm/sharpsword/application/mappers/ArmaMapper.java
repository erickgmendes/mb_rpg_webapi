package com.erickgm.sharpsword.application.mappers;

import java.util.ArrayList;
import java.util.List;

import com.erickgm.sharpsword.application.dto.response.ArmaDtoResponse;
import com.erickgm.sharpsword.domain.entities.Arma;

public class ArmaMapper {

	public static ArmaDtoResponse mapToDtoResponse(Arma arma) {
		ArmaDtoResponse response = new ArmaDtoResponse();

		response.setId(arma.getId());
		response.setTipoArma(arma.getTipoArma().getNome());
		response.setNome(arma.getNome());
		response.setCusto(arma.getCusto());
		response.setDano(arma.getDano());
		response.setTipoDanoArma(arma.getTipoDanoArma().getNome());
		response.setFn(arma.getFn());
		response.setPeso(arma.getPeso());
		response.setTipoDistanciaArma(arma.getTipoDistanciaArma().getNome());
		response.setObservacoes(arma.getObservacoes());

		return response;
	}

	public static List<ArmaDtoResponse> mapToListDtoResponse(List<Arma> armas) {

		List<ArmaDtoResponse> listaResponse = new ArrayList<ArmaDtoResponse>();

		for (Arma arma : armas) {
			ArmaDtoResponse response = mapToDtoResponse(arma);
			listaResponse.add(response);
		}
		
		return listaResponse;
	}

}