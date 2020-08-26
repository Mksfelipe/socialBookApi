package com.algaworks.socialbooks.services.exceptions;

public class AutorNaoEncontradoException extends RuntimeException{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AutorNaoEncontradoException(String messagem) {
		super(messagem);
	}
	
	public AutorNaoEncontradoException(String messagem, Throwable causa) {
		super(messagem, causa);
	}
}