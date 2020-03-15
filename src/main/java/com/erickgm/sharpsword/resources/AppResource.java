package com.erickgm.sharpsword.resources;

import java.util.ArrayList;
import java.util.List;

import com.erickgm.sharpsword.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Application")
@CrossOrigin(origins = "*")
public class AppResource {

	@Autowired
	private HabilidadeService habilidadeService;

	@Autowired
	private EquipamentoService equipamentoService;
	
	@Autowired
	private RacaService racaService;

	@Autowired
	private ClasseService classeService;

	@GetMapping("/carga_inicial")
	@ApiOperation(value = "Este método executa a carga inicial nas tabelas do sistema")
	public List<String> cargaInicial() {
		List<String> lista = new ArrayList<>();

		lista.add(racaService.cargaInicial());
		lista.add(classeService.cargaInicial());
		lista.add(habilidadeService.cargaInicial());
		lista.add(equipamentoService.cargaInicial());

		return lista;
	}
}