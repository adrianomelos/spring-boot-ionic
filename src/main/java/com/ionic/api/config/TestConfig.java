package com.ionic.api.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@Configurable
@Profile("test")
public class TestConfig {

	@Bean
	public boolean startConfigDb() {
		
		return true;
	}
}
