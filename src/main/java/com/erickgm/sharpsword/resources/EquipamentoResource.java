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

import com.erickgm.sharpsword.application.dto.request.EquipamentoDtoRequest;
import com.erickgm.sharpsword.application.dto.response.EquipamentoDtoResponse;
import com.erickgm.sharpsword.application.services.EquipamentoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Raça")
@CrossOrigin(origins = "*")
public class EquipamentoResource {

	@Autowired
	private EquipamentoService equipamentoService;

	@GetMapping("/equipamentos")
	@ApiOperation(value = "Este método retorna uma lista de equipamentos")
	public ResponseEntity<List<EquipamentoDtoResponse>> listarEquipamento() {
		List<EquipamentoDtoResponse> response = equipamentoService.listarEquipamentos();

		return new ResponseEntity<List<EquipamentoDtoResponse>>(response, HttpStatus.OK);
	}

	@GetMapping("/equipamento/{id}")
	@ApiOperation(value = "Este método retorna uma equipamento pelo seu identificador")
	public ResponseEntity<EquipamentoDtoResponse> obterEquipamentoPeloId(@PathVariable(value = "id") long id) {
		EquipamentoDtoResponse response = equipamentoService.obterEquipamentoPeloId(id);

		if (response == null) {
			return new ResponseEntity<EquipamentoDtoResponse>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<EquipamentoDtoResponse>(response, HttpStatus.OK);
	}
	
	@PostMapping("/equipamento")
	@ApiOperation(value = "Este método adiciona um equipamento")
	public ResponseEntity<EquipamentoDtoResponse> incluirEquipamento(@RequestBody EquipamentoDtoRequest dto) {
		EquipamentoDtoResponse response = equipamentoService.incluirEquipamento(dto);

		if (response == null) {
			return new ResponseEntity<EquipamentoDtoResponse>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<EquipamentoDtoResponse>(response, HttpStatus.OK);
	}
	
	@PutMapping("/equipamento/{id}")
	@ApiOperation(value = "Este método atualiza uma equipamento")
	public ResponseEntity<EquipamentoDtoResponse> alterarEquipamento(@PathVariable(value = "id") long id, @RequestBody EquipamentoDtoRequest dto) {
		EquipamentoDtoResponse response = equipamentoService.alterarEquipamento(id, dto);

		if (response == null) {
			return new ResponseEntity<EquipamentoDtoResponse>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<EquipamentoDtoResponse>(response, HttpStatus.OK);
	}	

	@DeleteMapping("/equipamento/{id}")
	@ApiOperation(value = "Este método exclui uma equipamento")
	public ResponseEntity<Boolean> excluirEquipamento(@PathVariable(value = "id") long id) {
		if(!equipamentoService.excluirEquipamento(id)) {
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}