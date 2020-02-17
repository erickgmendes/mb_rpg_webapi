package com.erickgm.sharpsword.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erickgm.sharpsword.domain.entities.Habilidade;

public interface HabilidadeRepository extends JpaRepository<Habilidade, Long> {

	Habilidade findByNome(String nome);

	Habilidade findById(long id);

}
