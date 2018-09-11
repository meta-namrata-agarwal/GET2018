package com.model;

import java.util.List;

public class Category {

	private int id;
	private String name;
	private List<Advertisement> list;

	
	public List<Advertisement> getList() {
		return list;
	}

	public void setList(List<Advertisement> list) {
		this.list = list;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

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
