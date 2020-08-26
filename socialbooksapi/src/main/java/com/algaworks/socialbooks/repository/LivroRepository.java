package com.algaworks.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.socialbooks.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
