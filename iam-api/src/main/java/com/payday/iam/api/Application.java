package com.payday.iam.api;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ComponentScan(basePackages={"com.payday.iam"})
@EntityScan(basePackages={"com.payday.iam"})
@SpringBootApplication(scanBasePackages={"com.payday.iam"})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
		
	
	 @Bean
	    public ModelMapper modelMapper() {
	        return new ModelMapper();
	    }
	 
	 @Bean
	    public BCryptPasswordEncoder bCryptPasswordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

}
