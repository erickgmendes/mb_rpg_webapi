package com.erickgm.sharpsword.services;

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
		if (classeRepository.count() == 0) {
			classeRepository.save(getClasse("Guerreiro",1,1,0,0, true));
			classeRepository.save(getClasse("Patrulheiro",0,1,1,0, true));
			classeRepository.save(getClasse("Feiticeiro",0,0,1,1, true));
			classeRepository.save(getClasse("Ladino",0,1,1,0, true));

			classeRepository.save(getClasse("Bardo",0,1,0,1, false));
			classeRepository.save(getClasse("Druida",0,0,1,1, false));
			classeRepository.save(getClasse("Espadachim",1,1,0,0, false));
			classeRepository.save(getClasse("Paladino",1,0,0,1, false));
			classeRepository.save(getClasse("Rúnico",1,0,1,0, false));
			classeRepository.save(getClasse("Sacerdote",0,0,1,1, false));
			classeRepository.save(getClasse("Xamã",1,0,0,1, false));

			return "Classes carregadas";
		}
		return "Não foi possível carregar Classes";
	}

	public List<Classe> listarClasses() {
		return classeRepository.findByOrderByNomeAsc();
	}

	private Classe getClasse(String nome, int forca, int agilidade, int inteligencia, int vontade, boolean comum){
		Classe classe = new Classe();
		classe.setNome(nome);
		classe.setValorForca(forca);
		classe.setValorAgilidade(agilidade);
		classe.setValorInteligencia(inteligencia);
		classe.setValorVontade(vontade);
		classe.setComum(comum);

		return classe;
	}
}