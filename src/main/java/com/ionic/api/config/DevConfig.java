package com.ionic.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.ionic.api.services.CidadeService;
import com.ionic.api.services.EstadoService;

@Configurable
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private CidadeService cidadeService;
	@Autowired
	private EstadoService estadoService;

	@Bean
	public boolean startConfigDb() {
		
		estadoService.gravarUfLocal();
		cidadeService.gravarUfLocal();
		return true;
	}
}
