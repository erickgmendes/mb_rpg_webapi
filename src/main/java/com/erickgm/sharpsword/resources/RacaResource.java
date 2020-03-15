package com.erickgm.sharpsword.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}