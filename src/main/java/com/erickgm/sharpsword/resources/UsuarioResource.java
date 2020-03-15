package com.erickgm.sharpsword.resources;

import java.util.List;

import com.erickgm.sharpsword.domain.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erickgm.sharpsword.services.UsuarioService;

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
	public ResponseEntity<List<Usuario>> listarUsuario() {
		List<Usuario> response = usuarioService.listarUsuarios();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/usuario/{id}")
	@ApiOperation(value = "Este método retorna um usuário pelo seu identificador")
	public ResponseEntity<Usuario> obterUsuarioPeloId(@PathVariable(value = "id") long id) {
		Usuario usuario = usuarioService.obterUsuarioPeloId(id);

		if (usuario == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(usuario, HttpStatus.OK);
	}
	
}