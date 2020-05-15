package com.erickgm.sharpsword.repository;

import com.erickgm.sharpsword.domain.entities.HabilidadeRaca;
import com.erickgm.sharpsword.domain.entities.Raca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabilidadeRacaRepository  extends JpaRepository<HabilidadeRaca, Long> {

    HabilidadeRaca findById(long id);

}
