package com.erickgm.sharpsword.resources;

import java.util.List;

import com.erickgm.sharpsword.domain.entities.Habilidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erickgm.sharpsword.services.HabilidadeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Habilidade")
@CrossOrigin(origins = "*")
public class HabilidadeResource {

	@Autowired
	private HabilidadeService habilidadeService;

	@GetMapping("/habilidades")
	@ApiOperation(value = "Este método retorna uma lista de habilidades")
	public ResponseEntity<List<Habilidade>> listarHabilidade() {
		List<Habilidade> response = habilidadeService.listarHabilidades();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}