package com.erickgm.sharpsword.application.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erickgm.sharpsword.application.dto.request.MunicaoDtoRequest;
import com.erickgm.sharpsword.application.dto.response.MunicaoDtoResponse;
import com.erickgm.sharpsword.application.mappers.MunicaoMapper;
import com.erickgm.sharpsword.domain.entities.Municao;
import com.erickgm.sharpsword.repository.MunicaoRepository;

@Service
public class MunicaoService {

	@Autowired
	private MunicaoRepository municaoRepository;

	public String cargaInicial() {
		List<Municao> itens = new ArrayList<Municao>();

		if (municaoRepository.count() == 0) {

			itens.add(
					new Municao(null, "Balas", 1.0, 0.02, "Esferas de metal ou pedra para fustibalo, Prodd e Funda."));
			itens.add(new Municao(null, "Dardos", 1.0, null, "Agulhas para zarabatana, 200 dessas pesam 1kg."));
			itens.add(new Municao(null, "Flecha Comum", 2.0, 0.05, "Flecha usada em todos os tipos de arco."));
			itens.add(new Municao(null, "Flecha Garateia", 10.0, 0.2,
					"Fecha especial para acoplar uma garatéia na ponta e uma corda"));
			itens.add(
					new Municao(null, "Virote Comum", 2.0, 0.04, "Seta usada em todos os tipos de besta e Plumbata."));
			itens.add(new Municao(null, "Virote Garateia", 10.0, 0.2,
					"Virote especial para acoplar uma garatéia na ponta e uma corda"));

			for (Municao item : itens) {
				municaoRepository.save(item);
			}

			return "Munições carregadas";
		}
		return "Não foi possível carregar Munições";
	}

	public List<MunicaoDtoResponse> listarMunicoes() {
		List<Municao> municoes = municaoRepository.findAll();
		return MunicaoMapper.mapToListDtoResponse(municoes);
	}

	public MunicaoDtoResponse obterMunicaoPeloId(long id) {
		Municao municao =  municaoRepository.findById(id);
		return MunicaoMapper.mapToDtoResponse(municao);
	}

	public MunicaoDtoResponse incluirMunicao(MunicaoDtoRequest dto) {
		if (dto == null) {
			return null;
		}

		Municao municao = municaoRepository.findByNome(dto.getNome());
		if (municao != null) {
			return MunicaoMapper.mapToDtoResponse(municao);
		}

		municao = new Municao(null, dto.getNome(), dto.getCusto(), dto.getPeso(), dto.getDescricao());
		municao = municaoRepository.save(municao);

		return MunicaoMapper.mapToDtoResponse(municao);
	}

	public MunicaoDtoResponse alterarMunicao(long id, MunicaoDtoRequest dto) {
		Municao municao = municaoRepository.findById(id);
		
		municao.modificaValores(dto.getNome(), dto.getCusto(), dto.getPeso(), dto.getDescricao());
		
		municaoRepository.save(municao);
		
		return MunicaoMapper.mapToDtoResponse(municao);
	}

	public boolean excluirMunicao(long id) {
		Municao municao = municaoRepository.findById(id);

		if (municao == null) {
			return false;
		}

		municaoRepository.delete(municao);

		return true;
	}

}