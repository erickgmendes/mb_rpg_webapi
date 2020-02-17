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

import com.erickgm.sharpsword.application.dto.request.ArmaduraDtoRequest;
import com.erickgm.sharpsword.application.dto.response.ArmaduraDtoResponse;
import com.erickgm.sharpsword.application.services.ArmaduraService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Armadura")
@CrossOrigin(origins = "*")
public class ArmaduraResource {

	@Autowired
	private ArmaduraService armaduraService;

	@GetMapping("/armaduras")
	@ApiOperation(value = "Este método retorna uma lista de armaduras")
	public ResponseEntity<List<ArmaduraDtoResponse>> listarArmadura() {
		List<ArmaduraDtoResponse> response = armaduraService.listarArmaduras();

		return new ResponseEntity<List<ArmaduraDtoResponse>>(response, HttpStatus.OK);
	}

	@GetMapping("/armadura/{id}")
	@ApiOperation(value = "Este método retorna uma armadura pelo seu identificador")
	public ResponseEntity<ArmaduraDtoResponse> obterArmaduraPeloId(@PathVariable(value = "id") long id) {
		ArmaduraDtoResponse response = armaduraService.obterArmaduraPeloId(id);

		if (response == null) {
			return new ResponseEntity<ArmaduraDtoResponse>( HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<ArmaduraDtoResponse>(response, HttpStatus.OK);
	}

	@PostMapping("/armadura")
	@ApiOperation(value = "Este método adiciona um armadura")
	public ResponseEntity<ArmaduraDtoResponse> incluirArmadura(@RequestBody ArmaduraDtoRequest dto) {
		ArmaduraDtoResponse response = armaduraService.incluirArmadura(dto);

		if (response == null) {
			return new ResponseEntity<ArmaduraDtoResponse>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<ArmaduraDtoResponse>(response, HttpStatus.OK);
	}

	@PutMapping("/armadura/{id}")
	@ApiOperation(value = "Este método atualiza uma armadura")
	public ResponseEntity<ArmaduraDtoResponse> alterarArmadura(@PathVariable(value = "id") long id,
			@RequestBody ArmaduraDtoRequest dto) {
		ArmaduraDtoResponse response = armaduraService.alterarArmadura(id, dto);

		if (response == null) {
			return new ResponseEntity<ArmaduraDtoResponse>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<ArmaduraDtoResponse>(response, HttpStatus.OK);
	}

	@DeleteMapping("/armadura/{id}")
	@ApiOperation(value = "Este método exclui uma armadura")
	public ResponseEntity<Boolean> excluirArmadura(@PathVariable(value = "id") long id) {
		if (!armaduraService.excluirArmadura(id)) {
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}