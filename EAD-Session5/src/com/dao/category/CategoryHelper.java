package com.dao.category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.dao.DBinfo;
import com.model.Category;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class CategoryHelper {

	public static int insertCategoryName(String name) {
		String addQuery = categoryQuery.insertCategoryName();
		try (Connection connection = DBinfo.getConn();
				PreparedStatement statement = connection
						.prepareStatement(addQuery);) {

			statement.setString(1, name);
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

	public static List<Category> retrieveAllCategory() {
		String query = categoryQuery.retrieveAllCategory();

		try (Connection connection = DBinfo.getConn();
				PreparedStatement statement = connection
						.prepareStatement(query);) {

			ResultSet rest = statement.executeQuery();
			List<Category> categoryList = new ArrayList<Category>();
			while (rest.next()) {
				Category category=new Category();
				category.setName(rest.getString("CATEGORY_NAME"));
				category.setId(rest.getInt("id"));
				categoryList.add(category);
			}
			return categoryList;
		} catch (SQLException sqlException) {

			sqlException.printStackTrace();
			return null;
		}

	}

	public static int updateCategoryNameHelper(String name,int id) {
		String addQuery = categoryQuery.updateCategoryName();
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

	public List<Category> retrieveCategoryHelper(int id) {
		String query = categoryQuery.retrieveACategory();

		try (Connection connection = DBinfo.getConn();
				PreparedStatement statement = connection
						.prepareStatement(query);) {
			statement.setInt(1, id);
			ResultSet rest = statement.executeQuery();
			List<Category> categoryList = new ArrayList<Category>();
			while (rest.next()) {
				Category category=new Category();
				category.setName(rest.getString("CATEGORY_NAME"));
				category.setId(rest.getInt("id"));
				categoryList.add(category);
			}
			return categoryList;
		} catch (SQLException sqlException) {

			sqlException.printStackTrace();
			return null;
		}
	}
}
