package com.projetoBiblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoBiblioteca.entities.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
}