package com.java3.projetoBlutecnologi.profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.java3.projetoBlutecnologi.services.DBService;

@Configuration
@Profile("test")
public class TestProfile {

	@Autowired
	private DBService dbService;

	@Bean
	public String instaciaDB() {
		this.dbService.instanciaDB();
		return null;
	}
}
