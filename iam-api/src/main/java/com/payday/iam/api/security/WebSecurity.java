package com.payday.iam.api.security;


import static com.payday.iam.api.security.SecurityConstants.LOGIN_URL;
import static com.payday.iam.api.security.SecurityConstants.SIGN_UP_URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.payday.iam.application.services.IUserService;
@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    private final IUserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    public WebSecurity(IUserService userService, 
            BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    @Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http.cors().and().csrf().disable();
         
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, SIGN_UP_URL)                
                .permitAll()
                .antMatchers(HttpMethod.POST, LOGIN_URL)                
                .permitAll()
                .and()                
                .addFilter(getAuthenticationFilter());                
        
        http.headers().frameOptions().disable();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
    }
    private JWTAuthenticationFilter getAuthenticationFilter() throws Exception {
        final JWTAuthenticationFilter filter = new JWTAuthenticationFilter(authenticationManager(),
                userService
        );
        return filter;
    }
    
}