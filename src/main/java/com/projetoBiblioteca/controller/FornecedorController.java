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

import com.projetoBiblioteca.entities.Fornecedor;
import com.projetoBiblioteca.services.FornecedorService;

@RestController
@RequestMapping("/Fornecedor")
public class FornecedorController {

	@Autowired
	private FornecedorService fornecedorService;

	public FornecedorController(FornecedorService fornecedorService) {
		this.fornecedorService = fornecedorService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Fornecedor> buscarFornecedorId(@PathVariable Long id) {
		Fornecedor fornecedor = fornecedorService.buscarFornecedorPorId(id);
		if (fornecedor != null) {
			return ResponseEntity.ok(fornecedor);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Fornecedor>> buscarTodosFornecedores() {
		List<Fornecedor> fornecedores = fornecedorService.buscarTodosFornecedores();
		return ResponseEntity.ok(fornecedores);
	}

	@PostMapping("/")
	public ResponseEntity<Fornecedor> salvarFornecedor(@RequestBody Fornecedor fornecedor) {
		Fornecedor saveFornecedor = fornecedorService.salvarFornecedor(fornecedor);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveFornecedor);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Fornecedor> alterarFornecedor(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
		Fornecedor atualizaFornecedor = fornecedorService.atualizarFornecedor(id, fornecedor);
		if (atualizaFornecedor != null) {
			return ResponseEntity.ok(atualizaFornecedor);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Fornecedor> apagarFornecedor(@PathVariable Long id) {
		boolean apagarFornecedor = fornecedorService.apagarFornecedor(id);
		if (apagarFornecedor) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}