package com.ionic.api.exceptions;

public class RequisicaoInvalidaExceptionUnautorized extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public RequisicaoInvalidaExceptionUnautorized(String msg) {
		super("Requisicao Invalida Exception: " + msg);
	}

}
