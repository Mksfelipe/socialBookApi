package com.algaworks.socialbooks.domain.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	
	private String nome;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date publicacao;
	
	private String editora;
	
	private String resumo;
	
	@OneToMany(mappedBy = "livro")
	private List<Comentario> comentarios;
	
	@ManyToOne
	@JoinColumn(name = "autor_id")
	private Autor autor;

}