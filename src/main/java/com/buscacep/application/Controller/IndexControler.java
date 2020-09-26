package com.buscacep.application.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexControler {
	
	@GetMapping(value = "/")
	public void index() {
		//indexAlternativa(); em analise 
	}
	
	@GetMapping(value = "/index")
	public String indexAlternativa() {
		return "page/index";
	}
		
}
