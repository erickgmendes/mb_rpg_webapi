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

import com.erickgm.sharpsword.application.dto.request.UsuarioDtoRequest;
import com.erickgm.sharpsword.application.dto.response.UsuarioDtoResponse;
import com.erickgm.sharpsword.application.services.UsuarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Usuario")
@CrossOrigin(origins = "*")
public class UsuarioResource {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/usuarios")
	@ApiOperation(value = "Este método retorna uma lista de usuários")
	public ResponseEntity<List<UsuarioDtoResponse>> listarUsuario() {
		List<UsuarioDtoResponse> response = usuarioService.listarUsuarios();
		return new ResponseEntity<List<UsuarioDtoResponse>>(response, HttpStatus.OK);
	}

	@GetMapping("/usuario/{id}")
	@ApiOperation(value = "Este método retorna um usuário pelo seu identificador")
	public ResponseEntity<UsuarioDtoResponse> obterUsuarioPeloId(@PathVariable(value = "id") long id) {
		UsuarioDtoResponse usuario = usuarioService.obterUsuarioPeloId(id);

		if (usuario == null) {
			return new ResponseEntity<UsuarioDtoResponse>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<UsuarioDtoResponse>(usuario, HttpStatus.OK);
	}
	
	@PostMapping("/usuario")
	@ApiOperation(value = "Este método adiciona um usuário")
	public ResponseEntity<UsuarioDtoResponse> incluirUsuario(@RequestBody UsuarioDtoRequest dto) {
		UsuarioDtoResponse response = usuarioService.incluirUsuario(dto);

		if (response == null) {
			return new ResponseEntity<UsuarioDtoResponse>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<UsuarioDtoResponse>(response, HttpStatus.OK);
	}
	
	@PutMapping("/usuario/{id}")
	@ApiOperation(value = "Este método atualiza uma usuário")
	public ResponseEntity<UsuarioDtoResponse> alterarUsuario(@PathVariable(value = "id") long id, @RequestBody UsuarioDtoRequest dto) {
		UsuarioDtoResponse response = usuarioService.alterarUsuario(id, dto);

		if (response == null) {
			return new ResponseEntity<UsuarioDtoResponse>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<UsuarioDtoResponse>(response, HttpStatus.OK);
	}	

	@DeleteMapping("/usuario/{id}")
	@ApiOperation(value = "Este método exclui uma usuário")
	public ResponseEntity<Boolean> excluirUsuario(@PathVariable(value = "id") long id) {
		if(!usuarioService.excluirUsuario(id)) {
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
