package com.erickgm.sharpsword.repository;

import com.erickgm.sharpsword.domain.entities.HabilidadeClasse;
import com.erickgm.sharpsword.domain.entities.HabilidadeRaca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabilidadeClasseRepository  extends JpaRepository<HabilidadeClasse, Long> {

    HabilidadeClasse findById(long id);

}
