package com.dao.category;

public class categoryQuery {

	public static String insertCategoryName()
	{
		final String query="INSERT INTO CATEGORY(CATEGORY_NAME) VALUES(?)";
		return query;
	}
	
	public static  String retrieveAllCategory()
	{
		final String query="SELECT * FROM CATEGORY";
		return query;
	}
	
	public static String updateCategoryName()
	{
		final String query="UPDATE CATEGORY SET CATEGORY_NAME=? WHERE id=?";
		return query;
	}

	public static String retrieveACategory() {
		final String query="SELECT * FROM CATEGORY WHERE id=?";
		return query;
	}
}
