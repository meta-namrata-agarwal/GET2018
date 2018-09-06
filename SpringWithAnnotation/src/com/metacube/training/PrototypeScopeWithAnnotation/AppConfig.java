package com.metacube.training.PrototypeScopeWithAnnotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

	@Bean
	@Scope("singleton")
	public Person person()
	{
		return new Person();
	
	}
}
