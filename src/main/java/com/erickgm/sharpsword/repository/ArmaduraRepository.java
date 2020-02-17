package com.erickgm.sharpsword.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erickgm.sharpsword.domain.entities.Armadura;

public interface ArmaduraRepository extends JpaRepository<Armadura, Long> {

	Armadura findById(long id);
	
	Armadura findByNome(String nome);
	
}
