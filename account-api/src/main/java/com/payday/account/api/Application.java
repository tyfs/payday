package com.payday.account.api;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ComponentScan(basePackages={"com.payday.account"})
@EntityScan(basePackages={"com.payday.account"})
@SpringBootApplication(scanBasePackages={"com.payday.account"})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
		
	
	 @Bean
	    public ModelMapper modelMapper() {
	        return new ModelMapper();
	    }
	 
	/*
	 * @Bean public BCryptPasswordEncoder bCryptPasswordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 */
	 
	
	 
}