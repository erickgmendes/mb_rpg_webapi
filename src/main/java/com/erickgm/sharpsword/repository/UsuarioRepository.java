package com.erickgm.sharpsword.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erickgm.sharpsword.domain.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findById(long id);
	
	Usuario findByLogin(String login);

	Usuario findByNome(String nome);
	
}
