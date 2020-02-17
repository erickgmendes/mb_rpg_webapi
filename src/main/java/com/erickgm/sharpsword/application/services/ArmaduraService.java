package com.erickgm.sharpsword.application.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erickgm.sharpsword.application.dto.request.ArmaduraDtoRequest;
import com.erickgm.sharpsword.application.dto.response.ArmaduraDtoResponse;
import com.erickgm.sharpsword.application.mappers.ArmaduraMapper;
import com.erickgm.sharpsword.domain.entities.Armadura;
import com.erickgm.sharpsword.repository.ArmaduraRepository;

@Service
public class ArmaduraService {

	@Autowired
	private ArmaduraRepository armaduraRepository;

	public String cargaInicial() {
		List<Armadura> itens = new ArrayList<Armadura>();

		if (armaduraRepository.count() == 0) {

			itens.add(new Armadura(null, "Túnica Pesada", 50, "1", 1, 2.5, null));
			itens.add(new Armadura(null, "Armadura de Couro", 100, "2", 2, 12.0, null));
			itens.add(new Armadura(null, "Armadura Simples", 200, "3", 4, 18, "Pesada"));
			itens.add(new Armadura(null, "Armadura de Batalha", 600, "4", 6, 27, "Pesada"));
			itens.add(new Armadura(null, "Armadura Completa", 2000, "5", 8, 36, "Pesada, Rígida"));
			itens.add(new Armadura(null, "Escudo Pequeno", 50, "+1", 2, 4, "Ocupa uma mão"));
			itens.add(new Armadura(null, "Escudo Médio", 100, "+2", 3, 6, "Ocupa uma mão"));
			itens.add(new Armadura(null, "Escudo de Corpo", 200, "+3", 5, 9, "Ocupa uma mão"));

			for (Armadura item : itens) {
				armaduraRepository.save(item);
			}

			return "Armaduras carregadas";
		}
		return "Não foi possivel carregar Armaduras";
	}

	public List<ArmaduraDtoResponse> listarArmaduras() {
		List<Armadura> armaduras = armaduraRepository.findAll();
		return ArmaduraMapper.mapToListDtoResponse(armaduras);
	}

	public ArmaduraDtoResponse obterArmaduraPeloId(long id) {
		Armadura armadura = armaduraRepository.findById(id);
		return ArmaduraMapper.mapToDtoResponse(armadura);
	}

	public ArmaduraDtoResponse incluirArmadura(ArmaduraDtoRequest dto) {
		if (dto == null) {
			return null;
		}

		Armadura armadura = armaduraRepository.findByNome(dto.getNome());
		if (armadura != null) {
			return ArmaduraMapper.mapToDtoResponse(armadura);
		}

		armadura = new Armadura(null, dto.getNome(), dto.getCusto(), dto.getDefesa(), dto.getFn(), dto.getPeso(),
				dto.getObservacoes());
		armadura = armaduraRepository.save(armadura);

		return ArmaduraMapper.mapToDtoResponse(armadura);
	}

	public ArmaduraDtoResponse alterarArmadura(long id, ArmaduraDtoRequest dto) {
		Armadura armadura = armaduraRepository.findById(id);

		armadura.modificaValores(dto.getNome(), dto.getCusto(), dto.getDefesa(), dto.getFn(), dto.getPeso(),
				dto.getObservacoes());
		armaduraRepository.save(armadura);
		return ArmaduraMapper.mapToDtoResponse(armadura);
	}

	public boolean excluirArmadura(long id) {
		Armadura armadura = armaduraRepository.findById(id);

		if (armadura == null) {
			return false;
		}

		armaduraRepository.delete(armadura);

		return true;
	}

}