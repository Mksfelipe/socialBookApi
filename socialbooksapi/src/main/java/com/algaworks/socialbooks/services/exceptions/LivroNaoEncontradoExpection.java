package com.algaworks.socialbooks.services.exceptions;

public class LivroNaoEncontradoExpection extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LivroNaoEncontradoExpection(String messagem) {
		super(messagem);
	}
	
	public LivroNaoEncontradoExpection(String messagem, Throwable causa) {
		super(messagem, causa);
	}
	
}
