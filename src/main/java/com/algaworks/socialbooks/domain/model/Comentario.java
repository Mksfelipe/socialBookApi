package com.algaworks.socialbooks.domain.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Comentario {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String texto;
	
	private String usuario;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date data;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "livro_id_fk")
	@JsonIgnore
	private Livro livro;
	
}