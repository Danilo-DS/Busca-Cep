package com.buscacep.application.exception;

public class CepExpection extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public CepExpection(String msg) {
		super(msg);
	}
	
}
