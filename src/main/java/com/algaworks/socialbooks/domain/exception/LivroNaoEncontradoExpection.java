package com.algaworks.socialbooks.domain.exception;

public class LivroNaoEncontradoExpection extends EntidadeNaoEncontradaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LivroNaoEncontradoExpection(String messagem) {
		super(messagem);
	}
	
	public LivroNaoEncontradoExpection(Long id) {
		this(String.format("Não existe um cadastro de livro com código %d", id));
	}
	
}
