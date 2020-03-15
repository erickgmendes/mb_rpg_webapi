package com.erickgm.sharpsword.resources;

import java.util.List;

import com.erickgm.sharpsword.domain.entities.Personagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erickgm.sharpsword.services.PersonagemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Personagem")
@CrossOrigin(origins = "*")
public class PersonagemResource {

	@Autowired
	private PersonagemService personagemService;

	@GetMapping("/personagems")
	@ApiOperation(value = "Este método retorna uma lista de personagems")
	public ResponseEntity<List<Personagem>> listarPersonagems() {
		List<Personagem> response = personagemService.listarPersonagens();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/personagem/{id}")
	@ApiOperation(value = "Este método retorna uma personagem pelo seu identificador")
	public ResponseEntity<Personagem> obterPersonagemPeloId(@PathVariable(value = "id") long id) {
		Personagem  response = personagemService.obterPersonagemPeloId(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}