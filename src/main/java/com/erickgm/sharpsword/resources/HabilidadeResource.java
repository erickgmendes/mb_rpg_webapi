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

import com.erickgm.sharpsword.application.dto.request.HabilidadeDtoRequest;
import com.erickgm.sharpsword.application.dto.response.HabilidadeDtoResponse;
import com.erickgm.sharpsword.application.services.HabilidadeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Raça")
@CrossOrigin(origins = "*")
public class HabilidadeResource {

	@Autowired
	private HabilidadeService habilidadeService;

	@GetMapping("/habilidades")
	@ApiOperation(value = "Este método retorna uma lista de habilidades")
	public ResponseEntity<List<HabilidadeDtoResponse>> listarHabilidade() {
		List<HabilidadeDtoResponse> response = habilidadeService.listarHabilidades();

		return new ResponseEntity<List<HabilidadeDtoResponse>>(response, HttpStatus.OK);
	}

	@GetMapping("/habilidade/{id}")
	@ApiOperation(value = "Este método retorna uma habilidade pelo seu identificador")
	public ResponseEntity<HabilidadeDtoResponse> obterHabilidadePeloId(@PathVariable(value = "id") long id) {
		HabilidadeDtoResponse response = habilidadeService.obterHabilidadePeloId(id);

		if (response == null) {
			return new ResponseEntity<HabilidadeDtoResponse>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<HabilidadeDtoResponse>(response, HttpStatus.OK);
	}
	
	@PostMapping("/habilidade")
	@ApiOperation(value = "Este método adiciona um habilidade")
	public ResponseEntity<HabilidadeDtoResponse> incluirHabilidade(@RequestBody HabilidadeDtoRequest dto) {
		HabilidadeDtoResponse response = habilidadeService.incluirHabilidade(dto);

		if (response == null) {
			return new ResponseEntity<HabilidadeDtoResponse>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<HabilidadeDtoResponse>(response, HttpStatus.OK);
	}
	
	@PutMapping("/habilidade/{id}")
	@ApiOperation(value = "Este método atualiza uma habilidade")
	public ResponseEntity<HabilidadeDtoResponse> alterarHabilidade(@PathVariable(value = "id") long id, @RequestBody HabilidadeDtoRequest dto) {
		HabilidadeDtoResponse response = habilidadeService.alterarHabilidade(id, dto);

		if (response == null) {
			return new ResponseEntity<HabilidadeDtoResponse>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<HabilidadeDtoResponse>(response, HttpStatus.OK);
	}	

	@DeleteMapping("/habilidade/{id}")
	@ApiOperation(value = "Este método exclui uma habilidade")
	public ResponseEntity<Boolean> excluirHabilidade(@PathVariable(value = "id") long id) {
		if(!habilidadeService.excluirHabilidade(id)) {
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}