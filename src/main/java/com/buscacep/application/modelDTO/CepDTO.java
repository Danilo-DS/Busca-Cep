package com.buscacep.application.modelDTO;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class CepDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String bairro;
	private String cep;
	private String localidade;
	private String uf;
	private String logradouro;
	
	public CepDTO() {}

	public CepDTO(String bairro, String cep, String localidade, String uf, String logradouro) {
		this.bairro = bairro;
		this.cep = cep;
		this.localidade = localidade;
		this.uf = uf;
		this.logradouro = logradouro;
	}
}
