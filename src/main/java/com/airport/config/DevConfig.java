package com.airport.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.airport.services.DBService;

@Configuration
@Profile("dev")
@EnableWebMvc
public class DevConfig  implements WebMvcConfigurer{

	@Autowired
	private DBService dbService;

	@Value("&{spring.jpa.hibernate.ddl-auto")
	private String value;
		
	@Bean
	public boolean instanciaDB() {
		if(value.equals("create")) {
			this.dbService.instanciaDB();
		}
		return false;		
	}
	
	public void addCorsMappings(CorsRegistry registry) {
		
		registry.addMapping("/**");
		
	}
}
