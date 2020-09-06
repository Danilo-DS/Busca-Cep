package com.buscacep.application.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexControler {
	
	@GetMapping(value = "/index")
	public String index() {
		return "page/index";
	}
}
