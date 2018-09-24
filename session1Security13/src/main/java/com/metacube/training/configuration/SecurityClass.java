package com.metacube.training.configuration;

import org.codehaus.groovy.transform.tailrec.HasRecursiveCalls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class SecurityClass extends WebSecurityConfigurerAdapter {
	@Autowired
	 protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.inMemoryAuthentication()
	          .withUser("1234").password("{noop}1234").roles("ADMIN");
	        auth.inMemoryAuthentication().withUser("namrata@gmail.com").password("{noop}1234").roles("User");
	    }
	 
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	System.out.println("security");
	        http
	          .authorizeRequests()
	          .antMatchers("/admin/*").access("hasRole('ADMIN')").antMatchers("/user/*").access("hasRole('User')")
	          .and()
	          .formLogin()
	          .loginPage("/login")
	          .defaultSuccessUrl("/Dashboard")
	          .loginProcessingUrl("/Login")
	        .failureUrl("/login?error")
	        .usernameParameter("email").and().logout().logoutSuccessUrl("/login?logout").logoutUrl("/Logout").deleteCookies("JSESSIONID");
	        http.csrf().disable();
	        
	          
	    }
	  
	   
	}

