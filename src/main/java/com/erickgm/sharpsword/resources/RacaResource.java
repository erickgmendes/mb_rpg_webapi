package com.erickgm.sharpsword.resources;

import java.util.List;

import com.erickgm.sharpsword.domain.entities.Personagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.erickgm.sharpsword.services.RacaService;
import com.erickgm.sharpsword.domain.entities.Raca;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Raça")
@CrossOrigin(origins = "*")
public class RacaResource {

	@Autowired
	private RacaService racaService;

	@GetMapping("/racas")
	@ApiOperation(value = "Este método retorna uma lista de raças")
	public ResponseEntity<List<Raca>> listarRaca() {
		List<Raca> response = racaService.listarRacas();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/racas/{id}")
	@ApiOperation(value = "Este método retorna uma raça pelo id")
	public ResponseEntity<Raca> obterRacaPeloId(@PathVariable(value = "id") long id) {
		Raca response = racaService.obterRacaPeloId(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}