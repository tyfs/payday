package com.payday.account.api.security;


import static com.payday.account.api.security.SecurityConstants.SIGN_UP_URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

//import com.payday.iam.application.services.IUserService;
@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	JWTAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http.cors().and().csrf().disable();
         
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, SIGN_UP_URL)                
                .permitAll()
                .anyRequest().authenticated()
                .and()          
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()
                .addFilter(getAuthorizationFilter())
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);;                
        
        http.headers().frameOptions().disable();
    }    
 
    private JWTAuthorizationFilter getAuthorizationFilter() throws Exception {
        final JWTAuthorizationFilter filter = new JWTAuthorizationFilter(authenticationManager()
        );
        return filter;
    }
    
}