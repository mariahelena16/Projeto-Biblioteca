package com.projetoBiblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projetoBiblioteca.entities.Fornecedor;
import com.projetoBiblioteca.repository.FornecedorRepository;

@Service
public class FornecedorService {

	private final FornecedorRepository fornecedorRepository;

	public FornecedorService(FornecedorRepository fornecedorRepository) {
		this.fornecedorRepository = fornecedorRepository;
	}

	public List<Fornecedor> buscarTodosFornecedores() {
		return fornecedorRepository.findAll();
	}

	public Fornecedor buscarFornecedorPorId(Long id) {
		Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
		return fornecedor.orElse(null);
	}

	public Fornecedor salvarFornecedor(Fornecedor atFornecedor) {
		return fornecedorRepository.save(atFornecedor);
	}

	public Fornecedor atualizarFornecedor(Long id, Fornecedor atFornecedor) {
		Optional<Fornecedor> exeFornecedor = fornecedorRepository.findById(id);
		if (exeFornecedor.isPresent()) {
			atFornecedor.setId(id);
			return fornecedorRepository.save(atFornecedor);
		} else {
			return null;
		}
	}

	public Boolean apagarFornecedor(Long id) {
		Optional<Fornecedor> exeFornecedor = fornecedorRepository.findById(id);
		if (exeFornecedor.isPresent()) {
			fornecedorRepository.deleteById(id);
			return true;
		}
		return false;
	}
}