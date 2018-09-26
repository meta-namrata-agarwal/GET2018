package com.metacube.training.configuration;

import javax.sql.DataSource;

import org.codehaus.groovy.transform.tailrec.HasRecursiveCalls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityClass extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("security");
		http.authorizeRequests().antMatchers("/admin/*")
				.access("hasRole('ROLE_ADMIN')").antMatchers("/user/*")
				.access("hasRole('ROLE_USER')").and().formLogin()
				.loginPage("/login").defaultSuccessUrl("/Dashboard")
				.loginProcessingUrl("/Login").failureUrl("/login?error")
				.usernameParameter("email").and().logout()
				.logoutSuccessUrl("/login?logout").logoutUrl("/Logout")
				.and().exceptionHandling().accessDeniedPage("/403");
		http.csrf().disable();
	}

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(userDetailsService);
		auth.authenticationProvider(authenticationProvider());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	// @Autowired
	// protected void configureGlobal(AuthenticationManagerBuilder auth) throws
	// Exception {
	// auth.inMemoryAuthentication()
	// .withUser("1234").password("{noop}1234").roles("ADMIN");
	// auth.inMemoryAuthentication().withUser("namrata@gmail.com").password("{noop}1234").roles("User");
	// }

	// @Autowired
	// public void configAuthentication(AuthenticationManagerBuilder auth)
	// throws Exception {
	// System.out.println("namrata");
	// auth.jdbcAuthentication()
	// .dataSource(dataSource).passwordEncoder(NoOpPasswordEncoder.getInstance())
	// .usersByUsernameQuery(
	// "select emailId as username,password, isActive from employee where emailId=?")
	// .authoritiesByUsernameQuery(
	// "select emailId as username,role from userrolename where emailId=?");
	// }

}
