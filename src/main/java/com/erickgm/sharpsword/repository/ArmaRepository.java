package com.erickgm.sharpsword.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erickgm.sharpsword.domain.entities.Arma;

public interface ArmaRepository extends JpaRepository<Arma, Long> {

	Arma findById(long id);
	
	Arma findByNome(String nome);

}
