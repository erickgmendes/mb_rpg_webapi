package com.erickgm.sharpsword.application.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erickgm.sharpsword.application.dto.request.ClasseDtoRequest;
import com.erickgm.sharpsword.application.dto.response.ClasseDtoResponse;
import com.erickgm.sharpsword.application.mappers.ClasseMapper;
import com.erickgm.sharpsword.domain.entities.Classe;
import com.erickgm.sharpsword.repository.ClasseRepository;

@Service
public class ClasseService {

	@Autowired
	private ClasseRepository classeRepository;
	
	public String cargaInicial() {
		List<Classe> itens = new ArrayList<Classe>();

		if (classeRepository.count() == 0) {
			itens.add(new Classe(null, "Clérigo"));
			itens.add(new Classe(null, "Homem de Armas"));
			itens.add(new Classe(null, "Ladrão"));
			itens.add(new Classe(null, "Mago"));

			/*
			itens.add(new Classe(null, "Bardo"));
			itens.add(new Classe(null, "Druida"));
			itens.add(new Classe(null, "Espadachim"));
			itens.add(new Classe(null, "Feiticeiro"));
			itens.add(new Classe(null, "Guerreiro"));
			itens.add(new Classe(null, "Ladino"));
			itens.add(new Classe(null, "Paladino"));
			itens.add(new Classe(null, "Patrulheiro"));
			itens.add(new Classe(null, "Rúnico"));
			itens.add(new Classe(null, "Sacerdote"));
			itens.add(new Classe(null, "Xamã"));
			 */
			
			for (Classe item : itens) {
				classeRepository.save(item);
			}

			return "Classes carregadas";
		}
		return "Não foi possível carregar Classes";
	}

	public List<ClasseDtoResponse> listarClasses() {
		List<Classe> classes = classeRepository.findByOrderByNomeAsc();
		return ClasseMapper.mapToListDtoResponse(classes);
	}

	public ClasseDtoResponse obterClassePeloId(long id) {
		Classe classe = classeRepository.findById(id);
		return  ClasseMapper.mapToDtoResponse(classe);
	}

	public ClasseDtoResponse incluirClasse(ClasseDtoRequest dto) {
		if (dto == null) {
			return null;
		}

		Classe classe = classeRepository.findByNome(dto.getNome());
		if (classe != null) {
			return ClasseMapper.mapToDtoResponse(classe);
		}

		classe = new Classe(null, dto.getNome());
		classe = classeRepository.save(classe);

		return ClasseMapper.mapToDtoResponse(classe);
	}

	public ClasseDtoResponse alterarClasse(long id, ClasseDtoRequest dto) {
		Classe classe = classeRepository.findById(id);
		
		classe.modificaValores(dto.getNome());	
		
		classeRepository.save(classe);
		
		return ClasseMapper.mapToDtoResponse(classe);
	}

	public boolean excluirClasse(long id) {
		Classe classe = classeRepository.findById(id);

		if (classe == null) {
			return false;
		}

		classeRepository.delete(classe);

		return true;
	}

}