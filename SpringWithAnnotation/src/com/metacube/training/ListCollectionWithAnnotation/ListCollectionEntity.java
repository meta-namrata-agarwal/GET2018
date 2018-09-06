package com.metacube.training.ListCollectionWithAnnotation;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

public class ListCollectionEntity {

	private List<String> list;

	/**
	 * @return the list
	 */
	public List<String> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	@Autowired
	public void setList(List<String> list) {
		this.list = list;
	}
	
	
	
	
}
