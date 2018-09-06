package com.metacube.training.PrototypeScopeWithAnnotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class Person {
	
	private String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	
	public void setName(String name) {
		this.name = name;
	}

	
}
