package com.buscacep.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;
@Configuration
public class ModelConvert {
	
	@Bean
	public static ModelMapper mapper(){
		return new ModelMapper();
	}
}
