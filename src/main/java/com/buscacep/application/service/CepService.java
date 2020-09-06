package com.buscacep.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.buscacep.application.model.Cep;

@Service
public class CepService{
		
	private RestTemplate rt;
	
	private static List<Cep> ceps = new ArrayList<>();
	
	public List<Cep> listar() {
		return ceps;
	}
	
	public String encontra(String encontrar){
		rt = new RestTemplate();
		Cep cep = rt.getForObject("https://viacep.com.br/ws/"+encontrar+"/json", Cep.class);

		if(!cep.getErro() || cep.equals(null)) {
			ceps.add(cep);
			return null;
		}
		return "Cep Não Encontrado!";
	}
}
