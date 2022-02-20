package com.algaworks.socialbooks.domain.exception;

public class AutorNaoEncontradoExpection extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public AutorNaoEncontradoExpection(String messagem) {
		super(messagem);
	}
	
	public AutorNaoEncontradoExpection(Long id) {
		this(String.format("Não existe um cadastro de cozinha com código %d", id));
	}
	
}
