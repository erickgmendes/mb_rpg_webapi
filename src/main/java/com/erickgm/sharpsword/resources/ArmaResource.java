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

import com.erickgm.sharpsword.application.dto.request.ArmaDtoRequest;
import com.erickgm.sharpsword.application.dto.response.ArmaDtoResponse;
import com.erickgm.sharpsword.application.services.ArmaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Arma")
@CrossOrigin(origins = "*")
public class ArmaResource {

	@Autowired
	private ArmaService armaService;

	@GetMapping("/armas")
	@ApiOperation(value = "Este método retorna uma lista de armas")
	public ResponseEntity<List<ArmaDtoResponse>> listarArma() {
		List<ArmaDtoResponse> response = armaService.listarArmas();

		return new ResponseEntity<List<ArmaDtoResponse>>(response, HttpStatus.OK);
	}

	@GetMapping("/arma/{id}")
	@ApiOperation(value = "Este método retorna uma arma pelo seu identificador")
	public ResponseEntity<ArmaDtoResponse> obterArmaPeloId(@PathVariable(value = "id") long id) {
		ArmaDtoResponse response = armaService.obterArmaPeloId(id);

		if (response == null) {
			return new ResponseEntity<ArmaDtoResponse>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<ArmaDtoResponse>(response, HttpStatus.OK);
	}

	@PostMapping("/arma")
	@ApiOperation(value = "Este método adiciona um arma")
	public ResponseEntity<ArmaDtoResponse> incluirArma(@RequestBody ArmaDtoRequest dto) {
		ArmaDtoResponse response = armaService.incluirArma(dto);

		if (response == null) {
			return new ResponseEntity<ArmaDtoResponse>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<ArmaDtoResponse>(response, HttpStatus.OK);
	}

	@PutMapping("/arma/{id}")
	@ApiOperation(value = "Este método atualiza uma arma")
	public ResponseEntity<ArmaDtoResponse> alterarArma(@PathVariable(value = "id") long id,
			@RequestBody ArmaDtoRequest dto) {
		ArmaDtoResponse response = armaService.alterarArma(id, dto);

		if (response == null) {
			return new ResponseEntity<ArmaDtoResponse>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<ArmaDtoResponse>(response, HttpStatus.OK);
	}

	@DeleteMapping("/arma/{id}")
	@ApiOperation(value = "Este método exclui uma arma")
	public ResponseEntity<Boolean> excluirArma(@PathVariable(value = "id") long id) {
		if (!armaService.excluirArma(id)) {
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}