package com.projetoBiblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoBiblioteca.entities.Fornecedor;


@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {}