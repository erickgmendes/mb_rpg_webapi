package com.erickgm.sharpsword.resources;

import java.util.List;

import com.erickgm.sharpsword.application.dto.response.ClerigoDtoResponse;
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

import com.erickgm.sharpsword.application.dto.request.ClasseDtoRequest;
import com.erickgm.sharpsword.application.dto.response.ClasseDtoResponse;
import com.erickgm.sharpsword.application.services.ClasseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Classes")
@CrossOrigin(origins = "*")
public class ClasseResource {

	@Autowired
	private ClasseService classeService;

	@GetMapping("/classes")
	@ApiOperation(value = "Este método retorna uma lista de classes")
	public ResponseEntity<List<ClasseDtoResponse>> listarClasse() {
		List<ClasseDtoResponse> response = classeService.listarClasses();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/classes/{id}")
	@ApiOperation(value = "Este método retorna uma classe pelo seu identificador")
	public ResponseEntity<ClasseDtoResponse> obterClassePeloId(@PathVariable(value = "id") long id) {
		ClasseDtoResponse response = classeService.obterClassePeloId(id);

		if (response == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/classes")
	@ApiOperation(value = "Este método adiciona um classe")
	public ResponseEntity<ClasseDtoResponse> incluirClasse(@RequestBody ClasseDtoRequest dto) {
		ClasseDtoResponse response = classeService.incluirClasse(dto);

		if (response == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PutMapping("/classes/{id}")
	@ApiOperation(value = "Este método atualiza uma classe")
	public ResponseEntity<ClasseDtoResponse> alterarClasse(@PathVariable(value = "id") long id, @RequestBody ClasseDtoRequest dto) {
		ClasseDtoResponse response = classeService.alterarClasse(id, dto);

		if (response == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(response, HttpStatus.OK);
	}	

	@DeleteMapping("/classes/{id}")
	@ApiOperation(value = "Este método exclui uma classe")
	public ResponseEntity<Boolean> excluirClasse(@PathVariable(value = "id") long id) {
		if(!classeService.excluirClasse(id)) {
			return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
}