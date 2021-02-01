package com.alkemy.challenge.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username, password, enabled from Users where username = ?")
		.authoritiesByUsernameQuery("select u.username, p.profile from userprofile up " + 
		" inner join Users u on u.id = up.idUsers" + 
		" inner join Profiles p on p.id = up.idProfiles" + " where u.username = ?");
				
	}
	
	@Override
	protected void configure (HttpSecurity http) throws Exception {
		http.authorizeRequests()
		//Permisos a URLs por ROLES
		.antMatchers("/subjects/index").hasAnyAuthority("ADMINISTRADOR")
		.antMatchers("/subjects/create").hasAnyAuthority("ADMINISTRADOR")
		.antMatchers("/subjects/save").hasAnyAuthority("ADMINISTRADOR")
		.antMatchers("/professor/delete/*").hasAnyAuthority("ADMINISTRADOR")
		.antMatchers("/professor/edit/*").hasAnyAuthority("ADMINISTRADOR")
		.antMatchers("/subjects/view/*").hasAnyAuthority("ALUMNO", "ADMINISTRADOR")
		
		.anyRequest().authenticated()
		.and().formLogin().permitAll();
		
	

	}
}
