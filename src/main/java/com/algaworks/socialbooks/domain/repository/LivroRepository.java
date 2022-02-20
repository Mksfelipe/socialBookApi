package com.algaworks.socialbooks.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.socialbooks.domain.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
