package com.erickgm.sharpsword.resources;

import java.util.List;

import com.erickgm.sharpsword.domain.entities.Habilidade;
import com.erickgm.sharpsword.domain.entities.HabilidadeClasse;
import com.erickgm.sharpsword.domain.entities.HabilidadeRaca;
import com.erickgm.sharpsword.domain.entities.Personagem;
import com.erickgm.sharpsword.services.HabilidadeClasseService;
import com.erickgm.sharpsword.services.HabilidadeRacaService;
import com.erickgm.sharpsword.services.RacaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.erickgm.sharpsword.services.HabilidadeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Habilidade")
@CrossOrigin(origins = "*")
public class HabilidadeResource {

	@Autowired
	private HabilidadeRacaService habilidadeRacaService;

	@Autowired
	private HabilidadeClasseService habilidadeClasseService;

	@Autowired
	private HabilidadeService habilidadeService;

	@Autowired
	private RacaService racaService;

	@GetMapping("/habilidades")
	@ApiOperation(value = "Este método retorna uma lista de habilidades")
	public ResponseEntity<List<Habilidade>> listarHabilidade() {
		List<Habilidade> response = habilidadeService.listarHabilidades();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/habilidades/racas/{id}")
	@ApiOperation(value = "Este método retorna uma habilidade pelo identificador da raça")
	public ResponseEntity<Habilidade> obterHabilidadeRacaPeloId(@PathVariable(value = "id") long id) {
		HabilidadeRaca hr = habilidadeRacaService.obterHabilidadeRacaPeloId(id);
		return new ResponseEntity<>(hr.getHabilidade(), HttpStatus.OK);
	}

	@GetMapping("/habilidades/classes/{id}")
	@ApiOperation(value = "Este método retorna uma habilidade pelo identificador da classe")
	public ResponseEntity<Habilidade> obterHabilidadeClassePeloId(@PathVariable(value = "id") long id) {
		HabilidadeClasse hc = habilidadeClasseService.obterHabilidadeClassePeloId(id);
		return new ResponseEntity<>(hc.getHabilidade(), HttpStatus.OK);
	}
}