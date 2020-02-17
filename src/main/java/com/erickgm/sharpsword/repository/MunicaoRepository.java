package com.erickgm.sharpsword.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erickgm.sharpsword.domain.entities.Municao;

public interface MunicaoRepository extends JpaRepository<Municao, Long> {

	Municao findByNome(String nome);

	Municao findById(long id);

}
