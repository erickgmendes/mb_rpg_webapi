package com.erickgm.sharpsword.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erickgm.sharpsword.domain.entities.Personagem;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {

	Personagem findById(long id);

	Personagem findByNome(String nome);
	
}