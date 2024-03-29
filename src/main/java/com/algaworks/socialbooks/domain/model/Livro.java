package com.algaworks.socialbooks.domain.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Livro {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome_livro")
	private String nome;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_publicacao")
	private LocalDate dataPublicado;

	private String editora;

	private String resumo;

	@ManyToOne
	@JoinColumn(name = "id_autor")
	private Autor autor;
	
	@JsonIgnore
	@OneToMany(mappedBy = "comentario")
	private List<Comentario> comentarios;
}