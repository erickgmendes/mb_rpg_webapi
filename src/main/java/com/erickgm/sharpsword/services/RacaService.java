package com.erickgm.sharpsword.services;

import java.util.List;

import com.erickgm.sharpsword.domain.entities.Personagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erickgm.sharpsword.domain.entities.Raca;
import com.erickgm.sharpsword.repository.RacaRepository;

@Service
public class RacaService {

    @Autowired
    private RacaRepository racaRepository;

    public String cargaInicial() {

        if (racaRepository.count() == 0) {
            racaRepository.save(getRaca("Anão", 4, 2, 3, 3, true));
            racaRepository.save(getRaca("Elfo", 2, 4, 3, 3, true));
            racaRepository.save(getRaca("Faen", 2, 4, 3, 2, true));
            racaRepository.save(getRaca("Humano", 3, 3, 3, 3, true));

            racaRepository.save(getRaca("Aesir", 4, 2, 3, 3, false));
            racaRepository.save(getRaca("Fauno", 3, 3, 3, 3, false));
            racaRepository.save(getRaca("Fira", 3, 3, 3, 3, false));
            racaRepository.save(getRaca("Juban", 4, 2, 3, 4, false));
            racaRepository.save(getRaca("Levent", 2, 3, 3, 3, false));
            racaRepository.save(getRaca("Mahok", 5, 2, 2, 3, false));
            racaRepository.save(getRaca("Tailox", 2, 4, 3, 3, false));

            return "Raças carregadas";
        }
        return "Não foi possível carregar Raças";
    }

    public List<Raca> listarRacas() {
        return racaRepository.findByOrderByNomeAsc();
    }

    public Raca obterRacaPeloId(long id) {
        return racaRepository.findById(id);
    }

    private Raca getRaca(String nome, int forca, int agilidade, int inteligencia, int vontade, boolean comum) {
        Raca raca = new Raca();
        raca.setNome(nome);
        raca.setValorForca(forca);
        raca.setValorAgilidade(agilidade);
        raca.setValorInteligencia(inteligencia);
        raca.setValorVontade(vontade);
        raca.setComum(comum);

        return raca;
    }

}