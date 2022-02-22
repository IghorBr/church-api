package com.church.api.configs;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.church.api.services.impl.DBServiceImpl;

@Configuration
public class DataBaseConfig {

	@Autowired private DBServiceImpl dbService;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbService.instantiateTestDatabase();		
		return true;
	}
	
}