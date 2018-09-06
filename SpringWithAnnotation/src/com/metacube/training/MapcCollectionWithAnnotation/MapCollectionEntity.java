package com.metacube.training.MapcCollectionWithAnnotation;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

public class MapCollectionEntity {

	private Map<String,Integer> map;
	
	/**
	 * @return the nameMap
	 */
	public Map<String,Integer> getNameMap() {
		return map;
	}
	/**
	 * @param nameMap the nameMap to set
	 */
	@Autowired
	public void setNameMap(Map<String, Integer> map) {
		this.map = map;
	}
	
	
}
