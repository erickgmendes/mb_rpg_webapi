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

import com.erickgm.sharpsword.application.dto.request.MunicaoDtoRequest;
import com.erickgm.sharpsword.application.dto.response.MunicaoDtoResponse;
import com.erickgm.sharpsword.application.services.MunicaoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Raça")
@CrossOrigin(origins = "*")
public class MunicaoResource {

	@Autowired
	private MunicaoService municaoService;

	@GetMapping("/municaos")
	@ApiOperation(value = "Este método retorna uma lista de municaos")
	public ResponseEntity<List<MunicaoDtoResponse>> listarMunicao() {
		List<MunicaoDtoResponse> response = municaoService.listarMunicoes();

		return new ResponseEntity<List<MunicaoDtoResponse>>(response, HttpStatus.OK);
	}

	@GetMapping("/municao/{id}")
	@ApiOperation(value = "Este método retorna uma municao pelo seu identificador")
	public ResponseEntity<MunicaoDtoResponse> obterMunicaoPeloId(@PathVariable(value = "id") long id) {
		MunicaoDtoResponse response = municaoService.obterMunicaoPeloId(id);

		if (response == null) {
			return new ResponseEntity<MunicaoDtoResponse>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<MunicaoDtoResponse>(response, HttpStatus.OK);
	}

	@PostMapping("/municao")
	@ApiOperation(value = "Este método adiciona um municao")
	public ResponseEntity<MunicaoDtoResponse> incluirMunicao(@RequestBody MunicaoDtoRequest dto) {
		MunicaoDtoResponse response = municaoService.incluirMunicao(dto);

		if (response == null) {
			return new ResponseEntity<MunicaoDtoResponse>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<MunicaoDtoResponse>(response, HttpStatus.OK);
	}

	@PutMapping("/municao/{id}")
	@ApiOperation(value = "Este método atualiza uma municao")
	public ResponseEntity<MunicaoDtoResponse> alterarMunicao(@PathVariable(value = "id") long id,
			@RequestBody MunicaoDtoRequest dto) {
		MunicaoDtoResponse response = municaoService.alterarMunicao(id, dto);

		if (response == null) {
			return new ResponseEntity<MunicaoDtoResponse>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<MunicaoDtoResponse>(response, HttpStatus.OK);
	}

	@DeleteMapping("/municao/{id}")
	@ApiOperation(value = "Este método exclui uma municao")
	public ResponseEntity<Boolean> excluirMunicao(@PathVariable(value = "id") long id) {
		if (!municaoService.excluirMunicao(id)) {
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}