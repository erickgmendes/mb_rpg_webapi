package com.erickgm.sharpsword.application.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erickgm.sharpsword.domain.entities.Raca;
import com.erickgm.sharpsword.repository.RacaRepository;

@Service
public class RacaService {

    @Autowired
    private RacaRepository racaRepository;

    public String cargaInicial() {
        List<Raca> itens = new ArrayList<>();

        if (racaRepository.count() == 0) {
            itens.add(new Raca(null, "Anão", 4,2,3,3));
            itens.add(new Raca(null, "Elfo", 2,4,3,3));
            itens.add(new Raca(null, "Halfling", 2,4,3,3));
            itens.add(new Raca(null, "Humano", 3,3,3,3));
            itens.add(new Raca(null, "Orc", 4,3,2,3));

            for (Raca item : itens) {
                racaRepository.save(item);
            }
            return "Raças carregadas";
        }
        return "Não foi possível carregar Raças";
    }

    public List<Raca> listarRacas() {
        return racaRepository.findByOrderByNomeAsc();
    }

}