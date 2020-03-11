package com.erickgm.sharpsword.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erickgm.sharpsword.application.dto.response.RacaDtoResponse;
import com.erickgm.sharpsword.application.services.RacaService;
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
		return new ResponseEntity<List<Raca>>(response, HttpStatus.OK);
	}

	@GetMapping("/racas/{id}")
	@ApiOperation(value = "Este método retorna uma raça pelo seu identificador")
	public ResponseEntity<RacaDtoResponse> obterRacaPeloId(@PathVariable(value = "id") long id) {
		RacaDtoResponse response = racaService.obterRacaPeloId(id);

		if (response == null) {
			return new ResponseEntity<RacaDtoResponse>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<RacaDtoResponse>(response, HttpStatus.OK);
	}
}