package com.erickgm.sharpsword.application.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erickgm.sharpsword.application.dto.request.PersonagemDtoRequest;
import com.erickgm.sharpsword.application.dto.response.PersonagemDtoResponse;
import com.erickgm.sharpsword.application.mappers.PersonagemMapper;
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

	public List<PersonagemDtoResponse> listarPersonagens() {
		List<Personagem> personagens = personagemRepository.findAll();
		return PersonagemMapper.mapToListDtoResponse(personagens);
	}

	public PersonagemDtoResponse obterPersonagemPeloId(long id) {
		Personagem personagem =  personagemRepository.findById(id);
		return PersonagemMapper.mapToDtoResponse(personagem);
	}

	public PersonagemDtoResponse incluirPersonagem(PersonagemDtoRequest dto) {
		Usuario usuario = usuarioRepository.findByLogin(dto.getLoginUsuario());
		if (dto == null || usuario == null || personagemRepository.findByNome(dto.getNome()) != null) {
			return null;
		}

		Raca raca = racaRepository.findByNome(dto.getRaca());		
		Classe classe = classeRepository.findByNome(dto.getClasse());
		
		List<Habilidade> habilidades = new ArrayList<Habilidade>();
		List<Arma> armas = new ArrayList<Arma>();
		List<Armadura> armaduras = new ArrayList<Armadura>();
		List<Equipamento> equipamentos = new ArrayList<Equipamento>();

		Personagem personagem = new PersonagemBuilder()
									.comNome(dto.getNome())
									.comUsuario(usuario)
									.comTipoRaca(raca)
									.comTipoClasse(classe)
									.comNivel(dto.getNivel())
									.comMotivacao(dto.getMotivacao())
									.comHabilidades(habilidades)
									.comArmas(armas)
									.comArmaduras(armaduras)
									.comEquipamentos(equipamentos)
									.build();

		personagem = personagemRepository.save(personagem);
				
		return PersonagemMapper.mapToDtoResponse(personagem); 
	}

	public PersonagemDtoResponse alterarPersonagem(long id, PersonagemDtoRequest dto) {
		Personagem personagem = personagemRepository.findById(id);
		Usuario usuario = usuarioRepository.findByLogin(dto.getLoginUsuario());
		Raca raca = racaRepository.findByNome(dto.getRaca());
		Classe classe = classeRepository.findByNome(dto.getClasse());
		List<Habilidade> habilidades = new ArrayList<Habilidade>();
		List<Arma> armas = new ArrayList<Arma>();
		List<Armadura> armaduras = new ArrayList<Armadura>();
		List<Equipamento> equipamentos = new ArrayList<Equipamento>();

		personagem = new PersonagemBuilder().comId(id).comNome(dto.getNome()).comUsuario(usuario)
				.comTipoRaca(raca).comTipoClasse(classe).comNivel(dto.getNivel())
				.comMotivacao(dto.getMotivacao()).comHabilidades(habilidades).comArmas(armas)
				.comArmaduras(armaduras).comEquipamentos(equipamentos).build();

		personagem =  personagemRepository.save(personagem);
		
		return PersonagemMapper.mapToDtoResponse(personagem);
	}

	public boolean excluirPersonagem(long id) {
		Personagem personagem = personagemRepository.findById(id);
		if (personagem == null) {
			return false;
		}
		personagemRepository.delete(personagem);
		return true;
	}

}