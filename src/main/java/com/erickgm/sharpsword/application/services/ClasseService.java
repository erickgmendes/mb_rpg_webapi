package com.erickgm.sharpsword.application.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erickgm.sharpsword.domain.entities.Classe;
import com.erickgm.sharpsword.repository.ClasseRepository;

@Service
public class ClasseService {

	@Autowired
	private ClasseRepository classeRepository;
	
	public String cargaInicial() {
		List<Classe> itens = new ArrayList<>();

		if (classeRepository.count() == 0) {
			itens.add(new Classe(null, "Espadachim",1,1,0,0));
			itens.add(new Classe(null, "Guerreiro",1,1,0,0));
			itens.add(new Classe(null, "Bárbaro",1,1,0,0));
			itens.add(new Classe(null, "Paladino",1,0,0,1));
			itens.add(new Classe(null, "Ranger",0,1,1,0));
			itens.add(new Classe(null, "Ladrão",0,1,1,0));
			itens.add(new Classe(null, "Feiticeiro",0,0,1,1));
			itens.add(new Classe(null, "Sacerdote",0,0,1,1));

			for (Classe item : itens) {
				classeRepository.save(item);
			}

			return "Classes carregadas";
		}
		return "Não foi possível carregar Classes";
	}

	public List<Classe> listarClasses() {
		return classeRepository.findByOrderByNomeAsc();
	}
}