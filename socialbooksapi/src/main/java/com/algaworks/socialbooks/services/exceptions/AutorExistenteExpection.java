package com.algaworks.socialbooks.services.exceptions;

public class AutorExistenteExpection extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AutorExistenteExpection(String messagem) {
		super(messagem);
	}
	
	public AutorExistenteExpection(String messagem, Throwable causa) {
		super(messagem, causa);
	}
	
}
