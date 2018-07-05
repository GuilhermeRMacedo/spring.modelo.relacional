package spring.modelo.relacional.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import spring.modelo.relacional.services.DBservice;

@Configuration		//Arquivo de configuração do profile de teste
@Profile("test")
public class TestConfig {

	@Autowired
	private DBservice dbService;
	
	@Bean
	public boolean instantiateDataBase() throws ParseException {
		dbService.instantiateTestDatabase();
		return true;
	}
}
