package com.metacube.training.SetCollectionWithAnnotation;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

public class SetCollectionEntity {

	private Set<String> set;

	/**
	 * @return the list
	 */
	public Set<String> getSet() {
		return set;
	}

	/**
	 * @param list the list to set
	 */
	@Autowired
	public void setSet(Set<String> set) {
		this.set = set;
	}
	
	
	
	
}
