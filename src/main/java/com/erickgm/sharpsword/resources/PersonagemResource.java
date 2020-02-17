package com.erickgm.sharpsword.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erickgm.sharpsword.application.dto.request.PersonagemDtoRequest;
import com.erickgm.sharpsword.application.dto.response.PersonagemDtoResponse;
import com.erickgm.sharpsword.application.services.PersonagemService;

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
	public ResponseEntity<List<PersonagemDtoResponse>> listarPersonagems() {
		List<PersonagemDtoResponse> response = personagemService.listarPersonagens();
		return new ResponseEntity<List<PersonagemDtoResponse>>(response, HttpStatus.OK);
	}

	@GetMapping("/personagem/{id}")
	@ApiOperation(value = "Este método retorna uma personagem pelo seu identificador")
	public ResponseEntity<PersonagemDtoResponse> obterPersonagemPeloId(@PathVariable(value = "id") long id) {
		PersonagemDtoResponse  response = personagemService.obterPersonagemPeloId(id);
		return new ResponseEntity<PersonagemDtoResponse>(response, HttpStatus.OK);
	}	
	
	@PostMapping("/personagem")
	@ApiOperation(value = "Este método adiciona uma personagem")
	public ResponseEntity<PersonagemDtoResponse> incluirPersonagem(@RequestBody PersonagemDtoRequest dto) {
		PersonagemDtoResponse response = personagemService.incluirPersonagem(dto);

		if (response == null) {
			return new ResponseEntity<PersonagemDtoResponse>(response, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<PersonagemDtoResponse>(response, HttpStatus.OK);
	}

	@PutMapping("/personagem/{id}")
	@ApiOperation(value = "Este método atualiza uma personagem")
	public ResponseEntity<PersonagemDtoResponse> alterarPersonagem(@PathVariable(value = "id") long id, @RequestBody PersonagemDtoRequest dto) {
		PersonagemDtoResponse response = personagemService.alterarPersonagem(id, dto);

		if (response == null) {
			return new ResponseEntity<PersonagemDtoResponse>(response, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<PersonagemDtoResponse>(response, HttpStatus.OK);
	}	

	@DeleteMapping("/personagem/{id}")
	@ApiOperation(value = "Este método exclui uma personagem")
	public ResponseEntity<Boolean> excluirPersonagem(@PathVariable(value = "id") long id) {
		if(!personagemService.excluirPersonagem(id)) {
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

}