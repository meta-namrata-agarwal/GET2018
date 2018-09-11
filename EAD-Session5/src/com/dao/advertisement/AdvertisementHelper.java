package com.dao.advertisement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.DBinfo;
import com.dao.category.CategoryHelper;
import com.dao.category.categoryQuery;
import com.model.Advertisement;
import com.model.Category;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class AdvertisementHelper {

	public static int insertAdvertisementHalper(String title,
			String description, int categoryId) {

		String addQuery = AdvertisementQuery.insertAdvertisement();
		try (Connection connection = DBinfo.getConn();
				PreparedStatement statement = connection
						.prepareStatement(addQuery);) {

			statement.setString(1, title);
			statement.setString(2, description);
			statement.setInt(3, categoryId);
			statement.executeUpdate();
			return 1;

		} catch (MySQLIntegrityConstraintViolationException e) {

			e.printStackTrace();
			return -1;
		} catch (SQLException sqlException) {

			sqlException.printStackTrace();
			return 0;
		}
	}

	public static List retrieveAllAdvertisementHelper() {
		String query = AdvertisementQuery.retrieveAllAdvertisement();
		List<Advertisement> list = new ArrayList<Advertisement>();
		try (Connection connection = DBinfo.getConn();
				PreparedStatement statement = connection
						.prepareStatement(query);) {
			ResultSet rst = statement.executeQuery();
			while (rst.next()) {
				Advertisement ad = new Advertisement();
				ad.setId(rst.getInt("id"));
				ad.setTitle(rst.getString("ADVERTISEMENT_TITLE"));
				ad.setDescription(rst.getString("ADVERTISEMENT_DESC"));
				ad.setCategoryId(rst.getInt("CATEGORY_ID"));
				list.add(ad);
			}
			return list;
		} catch (SQLException sqlException) {

			sqlException.printStackTrace();
			return null;
		}

	}

	public static List<Category> retrieveAllAdvertisementByCategoryIdHelper(int id) {
		String query = AdvertisementQuery.retrieveAdvertisementByCategoryId();
		List<Category> finalCategory = new ArrayList<Category>();
		List<Advertisement> advertisementList = new ArrayList<>();
		try (Connection connection = DBinfo.getConn();
				PreparedStatement statement = connection
						.prepareStatement(query);) {
			statement.setInt(1, id);
			ResultSet rst = statement.executeQuery();
			while (rst.next()) {
				Advertisement ad = new Advertisement();
				ad.setId(rst.getInt("id"));
				ad.setTitle(rst.getString("ADVERTISEMENT_TITLE"));
				ad.setDescription(rst.getString("ADVERTISEMENT_DESC"));
				ad.setCategoryId(rst.getInt("CATEGORY_ID"));
				advertisementList.add(ad);
			}
			List<Category> cat = new CategoryHelper().retrieveCategoryHelper(id);
			Category finalResult = new Category();
			//System.out.println(cat.get(0).getId()+" "+cat.get(0).getName());
			
			finalResult.setId(cat.get(0).getId());
			finalResult.setName(cat.get(0).getName());
			finalResult.setList(advertisementList);
			finalCategory.add(finalResult);
			return finalCategory;
			
		} catch (SQLException sqlException) {

			sqlException.printStackTrace();
			return null;
		}
	}

	public static int updateAdvertisementNameHelper(String name, int id) {
		String addQuery = AdvertisementQuery.updateAdvertisementName();
		try (Connection connection = DBinfo.getConn();
				PreparedStatement statement = connection
						.prepareStatement(addQuery);) {
			statement.setString(1, name);
			statement.setInt(2, id);
			statement.executeUpdate();
			return 1;
		} catch (MySQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			return -1;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return 0;
		}
	}

	public static int deleteAdvertisementHelper(int id) {
		String addQuery = AdvertisementQuery.deleteAdvertisement();
		try (Connection connection = DBinfo.getConn();
				PreparedStatement statement = connection
						.prepareStatement(addQuery);) {
			statement.setInt(1, id);
			statement.executeUpdate();
			return 1;
		} catch (MySQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			return -1;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return 0;
		}
	}

}