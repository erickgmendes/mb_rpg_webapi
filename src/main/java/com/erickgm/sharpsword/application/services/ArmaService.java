package com.erickgm.sharpsword.application.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erickgm.sharpsword.application.dto.request.ArmaDtoRequest;
import com.erickgm.sharpsword.application.dto.response.ArmaDtoResponse;
import com.erickgm.sharpsword.application.mappers.ArmaMapper;
import com.erickgm.sharpsword.domain.entities.Arma;
import com.erickgm.sharpsword.domain.enums.TipoArma;
import com.erickgm.sharpsword.domain.enums.TipoDanoArma;
import com.erickgm.sharpsword.domain.enums.TipoDistanciaArma;
import com.erickgm.sharpsword.repository.ArmaRepository;

@Service
public class ArmaService {

	@Autowired
	private ArmaRepository armaRepository;

	public String cargaInicial() {
		List<Arma> armas = new ArrayList<Arma>();

		if (armaRepository.count() == 0) {
			// Armas Corporais
			armas.add(new Arma(null, TipoArma.CORPORAL, "Soco", 0.0, "For+0", TipoDanoArma.CONTUSAO, "1", 0.0,
					TipoDistanciaArma.CORPO_A_CORPO, null));
			armas.add(new Arma(null, TipoArma.CORPORAL, "Chute", 0.0, "For+0", TipoDanoArma.CONTUSAO, "1", 0.0,
					TipoDistanciaArma.CORPO_A_CORPO, null));
			armas.add(new Arma(null, TipoArma.CORPORAL, "Adaga", 50.0, "For+4", TipoDanoArma.CORTE_PERFURACAO, "1",
					0.25, TipoDistanciaArma.CORPO_A_CORPO, "Arremesso, Canalizador"));
			armas.add(new Arma(null, TipoArma.CORPORAL, "Alabarda", 250.0, "For+11", TipoDanoArma.CORTE, "6", 6.0,
					TipoDistanciaArma.HASTE, "Duas Mãos"));
			armas.add(new Arma(null, TipoArma.CORPORAL, "Azagaia", 50.0, "For+5", TipoDanoArma.PERFURACAO, "2", 1.0,
					TipoDistanciaArma.CORPO_A_CORPO, "Arremesso"));
			armas.add(new Arma(null, TipoArma.CORPORAL, "Bico-de-corvo", 125.0, "For+6", TipoDanoArma.CORTE_PERFURACAO,
					"2", 1.0, TipoDistanciaArma.CORPO_A_CORPO, "Arremesso"));
			armas.add(new Arma(null, TipoArma.CORPORAL, "Bordão", 50.0, "For+5", TipoDanoArma.CONTUSAO, "1", 2.0,
					TipoDistanciaArma.CORPO_A_CORPO, "Duas Mãos, Canalizador"));
			armas.add(new Arma(null, TipoArma.CORPORAL, "Cimitarra", 225.0, "For+9", TipoDanoArma.CORTE_PERFURACAO,
					"5 (3)", 2.5, TipoDistanciaArma.CORPO_A_CORPO, null));
			armas.add(new Arma(null, TipoArma.CORPORAL, "Clava", 75.0, "For+6", TipoDanoArma.CONTUSAO, "3", 1.5,
					TipoDistanciaArma.CORPO_A_CORPO, "Canalizador"));
			armas.add(new Arma(null, TipoArma.CORPORAL, "Claymore", 250.0, "For+11", TipoDanoArma.CORTE_PERFURACAO, "5",
					3.0, TipoDistanciaArma.CORPO_A_CORPO, "Duas Mãos"));
			armas.add(new Arma(null, TipoArma.CORPORAL, "Espada curta", 10.0, "For+6", TipoDanoArma.CORTE_PERFURACAO,
					"2", 1.0, TipoDistanciaArma.CORPO_A_CORPO, null));
			armas.add(new Arma(null, TipoArma.CORPORAL, "Espada Longa", 175.0, "For+8", TipoDanoArma.CORTE_PERFURACAO,
					"4 (2)", 2.0, TipoDistanciaArma.CORPO_A_CORPO, null));
			armas.add(new Arma(null, TipoArma.CORPORAL, "Glaive", 225.0, "For+10", TipoDanoArma.CORTE, "4", 4.0,
					TipoDistanciaArma.HASTE, "Duas Mãos"));
			armas.add(new Arma(null, TipoArma.CORPORAL, "Lança", 100.0, "For+7", TipoDanoArma.PERFURACAO, "3", 2.0,
					TipoDistanciaArma.HASTE, "Duas Mãos, Arremesso"));
			armas.add(new Arma(null, TipoArma.CORPORAL, "Maça Leve", 25.0, "For+5", TipoDanoArma.CONTUSAO, "2", 1.0,
					TipoDistanciaArma.CORPO_A_CORPO, ""));
			armas.add(new Arma(null, TipoArma.CORPORAL, "Maça Pesada", 150.0, "For+8", TipoDanoArma.CONTUSAO, "5 (3)",
					2.5, TipoDistanciaArma.CORPO_A_CORPO, null));
			armas.add(new Arma(null, TipoArma.CORPORAL, "Maça Estrela", 100.0, "For+7", TipoDanoArma.CONTUSAO, "4", 2.0,
					TipoDistanciaArma.CORPO_A_CORPO, "Arremesso"));
			armas.add(new Arma(null, TipoArma.CORPORAL, "Machadinha", 100.0, "For+6", TipoDanoArma.CORTE, "2", 1.0,
					TipoDistanciaArma.CORPO_A_CORPO, "Arremesso"));
			armas.add(new Arma(null, TipoArma.CORPORAL, "Machado de Batalha", 150.0, "For+8", TipoDanoArma.CORTE,
					"5 (3)", 3.0, TipoDistanciaArma.CORPO_A_CORPO, null));
			armas.add(new Arma(null, TipoArma.CORPORAL, "Machado Pesado", 175.0, "For+11", TipoDanoArma.CORTE, "5", 4.0,
					TipoDistanciaArma.CORPO_A_CORPO, "Duas Mãos"));
			armas.add(new Arma(null, TipoArma.CORPORAL, "Mangual", 200.0, "For+9", TipoDanoArma.CONTUSAO, "6 (3)", 3.0,
					TipoDistanciaArma.CORPO_A_CORPO, null));
			armas.add(new Arma(null, TipoArma.CORPORAL, "Marreta", 175.0, "For+11", TipoDanoArma.CONTUSAO, "5", 5.0,
					TipoDistanciaArma.CORPO_A_CORPO, "Duas Mãos"));
			armas.add(new Arma(null, TipoArma.CORPORAL, "Martelo Lucerno", 275.0, "For+11",
					TipoDanoArma.CORTE_PERFURACAO, "7", 5.0, TipoDistanciaArma.HASTE, "Duas Mãos"));
			armas.add(new Arma(null, TipoArma.CORPORAL, "Martelo de guerra", 175.0, "For+8",
					TipoDanoArma.CORTE_PERFURACAO, "4 (2)", 3.0, TipoDistanciaArma.CORPO_A_CORPO, null));
			armas.add(new Arma(null, TipoArma.CORPORAL, "Rapieira", 125.0, "For+7", TipoDanoArma.PERFURACAO, "2", 1.0,
					TipoDistanciaArma.CORPO_A_CORPO, null));
			armas.add(new Arma(null, TipoArma.CORPORAL, "Sabre", 100.0, "For+7", TipoDanoArma.CORTE_PERFURACAO, "3",
					1.0, TipoDistanciaArma.CORPO_A_CORPO, null));
			armas.add(new Arma(null, TipoArma.CORPORAL, "Soqueira", 25.0, "For+2", TipoDanoArma.CONTUSAO, "1", 0.25,
					TipoDistanciaArma.CORPO_A_CORPO, null));
			armas.add(new Arma(null, TipoArma.CORPORAL, "Manopla", 25.0, "For+2", TipoDanoArma.CONTUSAO, "1", 0.25,
					TipoDistanciaArma.CORPO_A_CORPO, null));
			armas.add(new Arma(null, TipoArma.CORPORAL, "Tridente", 175.0, "For+8", TipoDanoArma.PERFURACAO, "5 (3)",
					3.0, TipoDistanciaArma.HASTE, "Arremesso"));

			// Armas de Distância
			armas.add(new Arma(null, TipoArma.DISTANCIA, "Arco Simples", 75.0, "For+4", TipoDanoArma.PERFURACAO, "2",
					0.75, TipoDistanciaArma.MEDIO, "Duas Mãos"));
			armas.add(new Arma(null, TipoArma.DISTANCIA, "Arco Composto", 175.0, "For+6", TipoDanoArma.PERFURACAO, "3",
					1.0, TipoDistanciaArma.LONGO, "Duas Mãos"));
			armas.add(new Arma(null, TipoArma.DISTANCIA, "Arco de Guerra", 250.0, "For+8", TipoDanoArma.PERFURACAO, "4",
					1.5, TipoDistanciaArma.LONGO, "Duas mãos"));
			armas.add(new Arma(null, TipoArma.DISTANCIA, "Arco Recurvo", 250.0, "For+7", TipoDanoArma.PERFURACAO, "2",
					1.5, TipoDistanciaArma.LONGO, "Duas mãos"));
			armas.add(new Arma(null, TipoArma.DISTANCIA, "Besta Leve", 175.0, "10", TipoDanoArma.PERFURACAO, "2", 2.0,
					TipoDistanciaArma.MEDIO, "Duas mãos, Carregar"));
			armas.add(new Arma(null, TipoArma.DISTANCIA, "Besta Pesada", 225.0, "14", TipoDanoArma.PERFURACAO, "5", 3.0,
					TipoDistanciaArma.MEDIO, "Duas Mãos, Carregar"));
			armas.add(new Arma(null, TipoArma.DISTANCIA, "Funda", 50.0, "For+2", TipoDanoArma.CONTUSAO, "1", 0.25,
					TipoDistanciaArma.MEDIO, null));
			armas.add(new Arma(null, TipoArma.DISTANCIA, "Estilingue", 50.0, "For+2", TipoDanoArma.CONTUSAO, "1", 0.25,
					TipoDistanciaArma.MEDIO, null));
			armas.add(new Arma(null, TipoArma.DISTANCIA, "Fustíbalo *", 200.0, "For+6", TipoDanoArma.CONTUSAO, "2", 2.0,
					TipoDistanciaArma.MEDIO,
					"Duas Mãos; * Fustíbalos podem ser usados como cajados em combate corporal."));
			armas.add(new Arma(null, TipoArma.DISTANCIA, "Plumbata", 100.0, "For+4", TipoDanoArma.PERFURACAO, "1", 0.5,
					TipoDistanciaArma.MEDIO, null));
			armas.add(new Arma(null, TipoArma.DISTANCIA, "Prodd", 175.0, "12", TipoDanoArma.CONTUSAO, "4", 3.0,
					TipoDistanciaArma.MEDIO, "Duas Mãos, Carregar"));
			armas.add(new Arma(null, TipoArma.DISTANCIA, "Zarabatana", 25.0, "For+0", TipoDanoArma.PERFURACAO, "1", 0.5,
					TipoDistanciaArma.CURTO, null));

			for (Arma arma : armas) {
				armaRepository.save(arma);
			}

			return "Armas carregadas";
		}
		return "Não foi possível carregar Armas";
	}

	public List<ArmaDtoResponse> listarArmas() {
		List<Arma> armas = armaRepository.findAll();
		return ArmaMapper.mapToListDtoResponse(armas);
	}

	public ArmaDtoResponse obterArmaPeloId(long id) {
		Arma arma = armaRepository.findById(id);
		return ArmaMapper.mapToDtoResponse(arma);
	}

	public ArmaDtoResponse incluirArma(ArmaDtoRequest dto) {
		if (dto == null) {
			return null;
		}

		Arma arma = armaRepository.findByNome(dto.getNome());
		if (arma != null) {
			return ArmaMapper.mapToDtoResponse(arma);
		}

		TipoArma tipoArma = TipoArma.getByNome(dto.getTipoArma());
		TipoDanoArma tipoDanoArma = TipoDanoArma.getByNome(dto.getTipoDanoArma());
		TipoDistanciaArma tipoDistanciaArma = TipoDistanciaArma.getByNome(dto.getTipoDistanciaArma());
		arma = new Arma(null, tipoArma, dto.getNome(), dto.getCusto(), dto.getDano(), tipoDanoArma, dto.getFn(),
				dto.getPeso(), tipoDistanciaArma, dto.getObservacoes());
		
		arma = armaRepository.save(arma);

		return ArmaMapper.mapToDtoResponse(arma);
	}

	public ArmaDtoResponse alterarArma(long id, ArmaDtoRequest dto) {
		Arma arma = armaRepository.findById(id);

		TipoArma tipoArma = TipoArma.getByNome(dto.getTipoArma());
		TipoDanoArma tipoDanoArma = TipoDanoArma.getByNome(dto.getTipoDanoArma());
		TipoDistanciaArma tipoDistanciaArma = TipoDistanciaArma.getByNome(dto.getTipoDistanciaArma());
		arma.modificaValores(tipoArma, dto.getNome(), dto.getCusto(), dto.getDano(), tipoDanoArma, dto.getFn(),
				dto.getPeso(), tipoDistanciaArma, dto.getObservacoes());
		
		armaRepository.save(arma);
		
		return ArmaMapper.mapToDtoResponse(arma);
	}

	public boolean excluirArma(long id) {
		Arma arma = armaRepository.findById(id);

		if (arma == null) {
			return false;
		}

		armaRepository.delete(arma);

		return true;
	}

}