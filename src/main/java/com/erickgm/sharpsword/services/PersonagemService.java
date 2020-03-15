package com.erickgm.sharpsword.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erickgm.sharpsword.domain.builders.PersonagemBuilder;
import com.erickgm.sharpsword.domain.entities.Arma;
import com.erickgm.sharpsword.domain.entities.Armadura;
import com.erickgm.sharpsword.domain.entities.Classe;
import com.erickgm.sharpsword.domain.entities.Equipamento;
import com.erickgm.sharpsword.domain.entities.Habilidade;
import com.erickgm.sharpsword.domain.entities.Personagem;
import com.erickgm.sharpsword.domain.entities.Raca;
import com.erickgm.sharpsword.domain.entities.Usuario;
import com.erickgm.sharpsword.repository.ClasseRepository;
import com.erickgm.sharpsword.repository.PersonagemRepository;
import com.erickgm.sharpsword.repository.RacaRepository;
import com.erickgm.sharpsword.repository.UsuarioRepository;

@Service
public class PersonagemService {

	@Autowired
	private PersonagemRepository personagemRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RacaRepository racaRepository;
	
	@Autowired
	private ClasseRepository classeRepository;

	public List<Personagem> listarPersonagens() {
		return personagemRepository.findAll();
	}

	public Personagem obterPersonagemPeloId(long id) {
		return personagemRepository.findById(id);
	}
}