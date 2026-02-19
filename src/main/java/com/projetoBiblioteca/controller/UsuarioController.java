package com.projetoBiblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.projetoBiblioteca.entities.Usuario;
import com.projetoBiblioteca.services.UsuarioService;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarUsuarioId(@PathVariable Long id) {
		Usuario usuario = usuarioService.buscarUsuariosPorId(id);
		if (usuario != null) {
			return ResponseEntity.ok(usuario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Usuario>> buscarTodosUsuarios() {
		List<Usuario> produtos = usuarioService.buscarTodosUsuarios();
		return ResponseEntity.ok(produtos);
	}

	@PostMapping("/")
	public ResponseEntity<Usuario> salvaProduto(@RequestBody Usuario usuarios) {
		Usuario saveUsuarios = usuarioService.salvarUsuario(usuarios);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveUsuarios);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Usuario> alteraUsuarios(@PathVariable Long id, @RequestBody Usuario usuarios) {
		Usuario atualizaUsuarios= usuarioService.atualizarUsuario(id, usuarios);
		if (atualizaUsuarios != null) {
			return ResponseEntity.ok(atualizaUsuarios); // Retorna o produto atualizado
		} else {
			return ResponseEntity.notFound().build(); // Retorna 404 se o produto não for encontrado
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Usuario> apagarUsuario(@PathVariable Long id) {
		boolean apagarUsuario = usuarioService.apagarUsuario(id);
		if (apagarUsuario) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // Retorna 204 No Content
		} else {
			return ResponseEntity.notFound().build(); // Retorna 404 se o produto não for encontrado
		}
	}
}