package com.erickgm.sharpsword.application.mappers;

import java.util.ArrayList;
import java.util.List;

import com.erickgm.sharpsword.application.dto.response.HabilidadeDtoResponse;
import com.erickgm.sharpsword.domain.entities.Habilidade;
import com.erickgm.sharpsword.domain.entities.Raca;

public class HabilidadeMapper {

	public static HabilidadeDtoResponse mapToDtoResponse(Habilidade habilidade) {
		HabilidadeDtoResponse response = new HabilidadeDtoResponse();

		response.setId(habilidade.getId());
		response.setNome(habilidade.getNome());
		response.setTipoHabilidade(habilidade.getTipoHabilidade().getNome());
		
		List<String> racas = new ArrayList<String>();
		for (Raca raca : habilidade.getRacas()) {
			racas.add(raca.getNome());
		}		
		response.setRacas(racas);
		
		response.setNivel(habilidade.getNivel());
		response.setDescricao(habilidade.getDescricao());
		response.setEspecial(habilidade.getEspecial());
		response.setDificuldade(habilidade.getDificuldade());
		response.setMana(habilidade.getMana());
		response.setRequisito(habilidade.getRequisito());
		response.setModificador(habilidade.getModificador());
		
		return response;
	}

	public static List<HabilidadeDtoResponse> mapToListDtoResponse(List<Habilidade> habilidades) {

		List<HabilidadeDtoResponse> listaResponse = new ArrayList<HabilidadeDtoResponse>();

		for (Habilidade habilidade : habilidades) {
			HabilidadeDtoResponse response = mapToDtoResponse(habilidade);
			listaResponse.add(response);
		}

		return listaResponse;
	}
	
}
