package com.buscacep.application.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.buscacep.application.ModelConvert;
import com.buscacep.application.exception.CepExpection;
import com.buscacep.application.model.Cep;
import com.buscacep.application.modelDTO.CepDTO;

@Service
public class CepService{
		
	private RestTemplate rt;
	
	private CepDTO cepDTO;
	
	public CepDTO listar() {			
		return cepDTO;		
	}
	
	public CepDTO encontra(String encontrar){
		rt = new RestTemplate();
		Cep cep = rt.getForObject("https://viacep.com.br/ws/"+encontrar+"/json", Cep.class);

		if(!cep.getErro() || cep.equals(null)) {
			cepDTO = toDTO(cep);
			System.out.println(cepDTO);
			listar();
			return cepDTO;
		}
		throw new CepExpection("Cep Não Encontrado");
	}
	
	private CepDTO toDTO(Cep cep) {
		return ModelConvert.mapper().map(cep, CepDTO.class);
	}
}
