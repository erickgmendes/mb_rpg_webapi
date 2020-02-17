package com.erickgm.sharpsword.application.mappers;

import java.util.ArrayList;
import java.util.List;

import com.erickgm.sharpsword.application.dto.response.ArmaDtoResponse;
import com.erickgm.sharpsword.application.dto.response.ArmaduraDtoResponse;
import com.erickgm.sharpsword.application.dto.response.EquipamentoDtoResponse;
import com.erickgm.sharpsword.application.dto.response.HabilidadeDtoResponse;
import com.erickgm.sharpsword.application.dto.response.PersonagemDtoResponse;
import com.erickgm.sharpsword.domain.entities.Arma;
import com.erickgm.sharpsword.domain.entities.Armadura;
import com.erickgm.sharpsword.domain.entities.Equipamento;
import com.erickgm.sharpsword.domain.entities.Habilidade;
import com.erickgm.sharpsword.domain.entities.Personagem;

public class PersonagemMapper {

	public static PersonagemDtoResponse mapToDtoResponse(Personagem personagem) {
		if (personagem == null) {
			return null;
		}

		PersonagemDtoResponse response = new PersonagemDtoResponse();
		response.setNome(personagem.getNome());
		response.setUsuario(personagem.getUsuario().getNome());
		response.setRaca(personagem.getRaca().getNome());
		response.setClasse(personagem.getClasse().getNome());
		response.setNivel(personagem.getNivel());
		response.setMotivacao(personagem.getMotivacao());
		response.setXp(personagem.getXp());
		response.setPontosVida(personagem.getPontosVida());
		response.setPontosMana(personagem.getPontosMana());
		response.setForca(personagem.getForca());
		response.setAgilidade(personagem.getAgilidade());
		response.setInteligencia(personagem.getInteligencia());
		response.setVontade(personagem.getVontade());
		response.setCargaBasica(personagem.getCargaBasica());
		response.setCargaPesada(personagem.getCargaPesada());
		response.setCargaMaxima(personagem.getCargaMaxima());
		response.setDeslocamento(personagem.getDeslocamento());
		response.setCorrida(personagem.getCorrida());
		response.setBloqueio(personagem.getBloqueio());
		response.setEsquiva(personagem.getEsquiva());
		response.setDeterminacao(personagem.getDeterminacao());
		response.setBonusDeterminacao(personagem.getBonusDeterminacao());
		response.setBonusArmadura(personagem.getBonusArmadura());
		response.setBonusBloqueio(personagem.getBonusBloqueio());
		response.setBonusEsquiva(personagem.getBonusEsquiva());
		response.setDinheiro(personagem.getDinheiro());

		// Conversão das listas
		List<HabilidadeDtoResponse> habilidadesDtoResponse = new ArrayList<HabilidadeDtoResponse>();
		for (Habilidade habilidade : personagem.getHabilidades()) {
			HabilidadeDtoResponse habilidadeDtoResponse = HabilidadeMapper.mapToDtoResponse(habilidade);
			habilidadesDtoResponse.add(habilidadeDtoResponse);
		}
		response.setHabilidades(habilidadesDtoResponse);

		List<ArmaDtoResponse> armasDtoResponse = new ArrayList<ArmaDtoResponse>();
		for (Arma arma : personagem.getArmas()) {
			ArmaDtoResponse armaDtoResponse = ArmaMapper.mapToDtoResponse(arma);
			armasDtoResponse.add(armaDtoResponse);
		}
		response.setArmas(armasDtoResponse);

		List<ArmaduraDtoResponse> armadurasDtoResponse = new ArrayList<ArmaduraDtoResponse>();
		for (Armadura armadura : personagem.getArmaduras()) {
			ArmaduraDtoResponse armaduraDtoResponse = ArmaduraMapper.mapToDtoResponse(armadura);
			armadurasDtoResponse.add(armaduraDtoResponse);
		}
		response.setArmaduras(armadurasDtoResponse);

		List<EquipamentoDtoResponse> equipamentosDtoResponse = new ArrayList<EquipamentoDtoResponse>();
		for (Equipamento equipamento : personagem.getEquipamentos()) {
			EquipamentoDtoResponse equipamentoDtoResponse = EquipamentoMapper.mapToDtoResponse(equipamento);
			equipamentosDtoResponse.add(equipamentoDtoResponse);
		}
		response.setEquipamentos(equipamentosDtoResponse);

		return response;
	}

	public static List<PersonagemDtoResponse> mapToListDtoResponse(List<Personagem> personagens) {

		List<PersonagemDtoResponse> listaResponse = new ArrayList<PersonagemDtoResponse>();

		for (Personagem personagem : personagens) {
			PersonagemDtoResponse response = mapToDtoResponse(personagem);
			listaResponse.add(response);
		}

		return listaResponse;
	}

}