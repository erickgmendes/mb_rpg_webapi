package com.erickgm.sharpsword.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erickgm.sharpsword.domain.entities.Classe;

public interface ClasseRepository extends JpaRepository<Classe, Long> {

	Classe findByNome(String nome);

	Classe findById(long id);
	
	//List<Classe> findAllOrderByNomeAsc();
	
	List<Classe> findByOrderByNomeAsc();

}
