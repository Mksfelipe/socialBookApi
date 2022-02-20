package com.algaworks.socialbooks.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.socialbooks.domain.model.Comentario;

@Repository
public interface ComentariosRepository extends JpaRepository<Comentario, Long> {

}
