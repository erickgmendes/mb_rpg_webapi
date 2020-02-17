package com.erickgm.sharpsword.application.services;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.erickgm.sharpsword.application.dto.request.RacaDtoRequest;
import com.erickgm.sharpsword.application.dto.response.RacaDtoResponse;
import com.erickgm.sharpsword.application.mappers.RacaMapper;
import com.erickgm.sharpsword.domain.entities.Raca;
import com.erickgm.sharpsword.repository.RacaRepository;

@Service
public class RacaService {

    @Autowired
    private RacaRepository racaRepository;

    public String cargaInicial() {
        List<Raca> itens = new ArrayList<Raca>();

        if (racaRepository.count() == 0) {
            itens.add(new Raca(null, "Anões"));
            itens.add(new Raca(null, "Elfos"));
            itens.add(new Raca(null, "Halflings"));
            itens.add(new Raca(null, "Humanos"));
			/*
			itens.add(new Raca(null, "Aesires"   ));
			itens.add(new Raca(null, "Faens"     ));
			itens.add(new Raca(null, "Faunos"    ));
			itens.add(new Raca(null, "Firas"     ));
			itens.add(new Raca(null, "Hamelins"  ));
			itens.add(new Raca(null, "Jubans"    ));
			itens.add(new Raca(null, "Levents"   ));
			itens.add(new Raca(null, "Mahoks"    ));
			itens.add(new Raca(null, "Metadílios"));
			itens.add(new Raca(null, "Tailoxs"   ));
			*/
            for (Raca item : itens) {
                racaRepository.save(item);
            }

            return "Raças carregadas";
        }
        return "Não foi possível carregar Raças";
    }

    public Page<Raca> listarRacasPaginacao(Integer pagina) {
        return racaRepository.findAll(PageRequest.of(pagina, 10));
    }

    public List<Raca> listarRacas() {
        return racaRepository.findByOrderByNomeAsc();
    }

    public RacaDtoResponse obterRacaPeloId(long id) {
        Raca raca = racaRepository.findById(id);
        return RacaMapper.mapToDtoResponse(raca);
    }

    public RacaDtoResponse incluirRaca(RacaDtoRequest dto) {
        if (dto == null) {
            return null;
        }

        Raca raca = racaRepository.findByNome(dto.getNome());
        if (raca != null) {
            return RacaMapper.mapToDtoResponse(raca);
        }

        raca = new Raca(null, dto.getNome());
        raca.modificaValores(dto.getNome());
        raca = racaRepository.save(raca);

        return RacaMapper.mapToDtoResponse(raca);
    }

    public RacaDtoResponse alterarRaca(long id, RacaDtoRequest dto) {
        Raca raca = racaRepository.findById(id);

        raca.modificaValores(dto.getNome());

        racaRepository.save(raca);

        return RacaMapper.mapToDtoResponse(raca);
    }

    public boolean excluirRaca(long id) {
        Raca raca = racaRepository.findById(id);

        if (raca == null) {
            return false;
        }

        racaRepository.delete(raca);

        return true;
    }

}