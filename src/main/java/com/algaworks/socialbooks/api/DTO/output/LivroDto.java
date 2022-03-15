package com.algaworks.socialbooks.api.DTO;

import java.time.LocalDate;
import java.util.List;

import com.algaworks.socialbooks.domain.model.Autor;
import com.algaworks.socialbooks.domain.model.Comentario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroDto {

	private Long id;

	private String nome;

	private LocalDate dataPublicado;

	private String editora;

	private String resumo;

	private Autor autor;

	private List<Comentario> comentarios;
}
