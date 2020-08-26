package com.algaworks.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.socialbooks.domain.Autor;

@Repository
public interface AutoresRepository extends JpaRepository<Autor, Long>{

}
