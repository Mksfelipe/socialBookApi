package com.algaworks.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.socialbooks.domain.Comentario;

@Repository
public interface ComentariosRepository extends JpaRepository<Comentario, Long> {

}
