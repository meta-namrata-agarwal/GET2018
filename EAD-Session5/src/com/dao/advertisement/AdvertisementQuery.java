package com.dao.advertisement;

public class AdvertisementQuery {

	public static String insertAdvertisement()
	{
		final String query="INSERT INTO ADVERTISEMENT(ADVERTISEMENT_TITLE,ADVERTISEMENT_DESC ,CATEGORY_ID) VALUES(?,?,?)";
		return query;
	}
	
	public static String retrieveAllAdvertisement()
	{
		final String query="SELECT * FROM ADVERTISEMENT";
		return query;
	}
	
	public static String retrieveAdvertisementByCategoryId()
	{
		final String query="SELECT * FROM ADVERTISEMENT where CATEGORY_ID=?";
		return query;
	}
	
	public static String updateAdvertisementName()
	{
		final String query="UPDATE ADVERTISEMENT SET ADVERTISEMENT_TITLE=? WHERE  ID=?";
		return query;
	}
	
	public static String deleteAdvertisement()
	{
		final String query="DELETE FROM ADVERTISEMENT WHERE ID=?";
		return query;
	}
}
