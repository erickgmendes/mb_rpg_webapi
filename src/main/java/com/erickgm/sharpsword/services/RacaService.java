package com.erickgm.sharpsword.services;

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
            itens.add(new Raca(null, "Aesir", 4,2,3,3));
            itens.add(new Raca(null, "Anão", 4,2,3,3));
            itens.add(new Raca(null, "Elfo", 2,4,3,3));
            itens.add(new Raca(null, "Faen", 2,4,3,2));
            itens.add(new Raca(null, "Fauno", 3,3,3,3));
            itens.add(new Raca(null, "Fira", 3,3,3,3));
            itens.add(new Raca(null, "Humano", 3,3,3,3));
            itens.add(new Raca(null, "Juban", 4,2,3,4));
            itens.add(new Raca(null, "Levent", 2,3,3,3));
            itens.add(new Raca(null, "Mahok", 5,2,2,3));
            itens.add(new Raca(null, "Tailox", 2,4,3,3));

            //itens.add(new Raca(null, "Orc", 4,3,2,3));
            //itens.add(new Raca(null, "Halfling", 2,4,3,3));

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