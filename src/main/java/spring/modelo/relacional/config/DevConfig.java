package spring.modelo.relacional.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import spring.modelo.relacional.services.DBservice;
import spring.modelo.relacional.services.EmailService;
import spring.modelo.relacional.services.SmtpEmailService;

@Configuration		//Arquivo de configuração do profile de teste
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBservice dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instantiateDataBase() throws ParseException {
		
		if(!"create".equals(strategy)) {
			return false;
		}
		
		dbService.instantiateTestDatabase();
		return true;
	}
	
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
}
