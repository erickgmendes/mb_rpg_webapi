package com.erickgm.sharpsword.resources;

import java.util.List;

import com.erickgm.sharpsword.domain.entities.Equipamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erickgm.sharpsword.services.EquipamentoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Equipamento")
@CrossOrigin(origins = "*")
public class EquipamentoResource {

	@Autowired
	private EquipamentoService equipamentoService;

	@GetMapping("/equipamentos")
	@ApiOperation(value = "Este método retorna uma lista de equipamentos")
	public ResponseEntity<List<Equipamento>> listarEquipamento() {
		List<Equipamento> response = equipamentoService.listarEquipamentos();

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}