package com.montespierre.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.montespierre.app.servicesecurity.EmpleadoServiceSecurity;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private EmpleadoServiceSecurity empleadoServiceSecurity; 
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		
		return bCryptPasswordEncoder;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
	throws Exception{
		auth.userDetailsService(empleadoServiceSecurity).passwordEncoder(bcrypt);
		//usuarios en memoria
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();
		//dice que cualquier peticion que entra debe estar autenticada
	}
	
	
}
