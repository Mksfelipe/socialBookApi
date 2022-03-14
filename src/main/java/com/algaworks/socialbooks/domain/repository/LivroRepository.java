package com.algaworks.socialbooks.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.algaworks.socialbooks.domain.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

	@Query("from Livro l join fetch l.autor")
	public List<Livro> findAll();
}
