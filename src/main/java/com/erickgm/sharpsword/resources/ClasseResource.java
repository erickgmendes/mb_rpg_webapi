package com.erickgm.sharpsword.resources;

import java.util.List;

import com.erickgm.sharpsword.domain.entities.Classe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erickgm.sharpsword.services.ClasseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Classes")
@CrossOrigin(origins = "*")
public class ClasseResource {

	@Autowired
	private ClasseService classeService;

	@GetMapping("/classes")
	@ApiOperation(value = "Este método retorna uma lista de classes")
	public ResponseEntity<List<Classe>> listarClasse() {
		List<Classe> response = classeService.listarClasses();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}