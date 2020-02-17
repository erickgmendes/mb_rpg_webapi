package com.erickgm.sharpsword.application.mappers;

import java.util.ArrayList;
import java.util.List;

import com.erickgm.sharpsword.application.dto.response.EquipamentoDtoResponse;
import com.erickgm.sharpsword.domain.entities.Equipamento;

public class EquipamentoMapper {

	public static EquipamentoDtoResponse mapToDtoResponse(Equipamento equipamento) {
		EquipamentoDtoResponse response = new EquipamentoDtoResponse();

		response.setId(equipamento.getId());
		response.setNome(equipamento.getNome());
		response.setCusto(equipamento.getCusto());
		response.setPeso(equipamento.getPeso());
		response.setDescricao(equipamento.getDescricao());

		return response;
	}

	public static List<EquipamentoDtoResponse> mapToListDtoResponse(List<Equipamento> equipamentos) {

		List<EquipamentoDtoResponse> listaResponse = new ArrayList<EquipamentoDtoResponse>();

		for (Equipamento equipamento : equipamentos) {
			EquipamentoDtoResponse response = mapToDtoResponse(equipamento);
			listaResponse.add(response);
		}

		return listaResponse;
	}
}