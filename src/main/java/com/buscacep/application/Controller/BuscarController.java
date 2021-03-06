package com.buscacep.application.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.buscacep.application.modelDTO.CepDTO;
import com.buscacep.application.service.CepService;

@RestController
@RequestMapping(value = "/index/buscaCep")
public class BuscarController {
	
	@Autowired
	private CepService service;
	
	@GetMapping
	public ResponseEntity<CepDTO> listaCep() {
		return ResponseEntity.ok(service.listar());
	}
	
	@GetMapping(value = "/{cep}")
	public ResponseEntity<?> Encontra(@PathVariable String cep) {
		return ResponseEntity.ok(service.encontra(cep));
	}
}
