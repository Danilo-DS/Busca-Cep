package com.buscacep.application.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Cep implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String bairro;
	private String cep;
	private String localidade;
	private String uf;
	private String logradouro;
	private Boolean erro = false;
	
	public Cep() {
	}
	
	
}
