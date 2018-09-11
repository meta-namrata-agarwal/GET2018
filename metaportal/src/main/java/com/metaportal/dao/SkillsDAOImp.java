package com.metaportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metaportal.modal.Skills;

public class SkillsDAOImp {

	public static List<Skills> getAllSkillHelper() {

		List<Skills> list = new ArrayList<Skills>();
		String query = SkillsQuery.getAllSkills;
		try (Connection connection = DBInfo.getConn();
				PreparedStatement statement = connection
						.prepareStatement(query);) {
			ResultSet rest = statement.executeQuery();
			
			while (rest.next()) {
				Skills skill = new Skills();
				skill.setSkillId(rest.getInt("skillId"));
				skill.setSkillName(rest.getString("skillName"));
				skill.setActive(rest.getBoolean("isActive"));
				list.add(skill);
			}
			return list;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return null;
		}

	}

		public  static int  insertSkillsHelper(Skills Skills) {
			String query = SkillsQuery.insertSkill;
			try (Connection connection = DBInfo.getConn();
					PreparedStatement statement = connection
							.prepareStatement(query);) {

				statement.setString(1, Skills.getSkillName());
				statement.executeUpdate();
				return 1;

			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
				return 0;
			}
		}


		public static Skills getSkillsByIdHelper(int id) {
			String query = SkillsQuery.getSkillById;
			try (Connection connection = DBInfo.getConn();
					PreparedStatement statement = connection
							.prepareStatement(query);) {
				statement.setInt(1,id);
				ResultSet rest = statement.executeQuery();
				Skills Skills = new Skills();
				while (rest.next()) {
					Skills.setSkillId(rest.getInt("skillId"));
					Skills.setSkillName(rest.getString("skillName"));
					Skills.setActive(rest.getBoolean("isActive"));
					
				}
				return Skills;

			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
				return null;
			}
		}

		public static int updateSkillsHelper(Skills skills) {
			// TODO Auto-generated method stub
			String query=SkillsQuery.updateSkill;
			try (Connection connection = DBInfo.getConn();
					PreparedStatement statement = connection
							.prepareStatement(query);) {

				statement.setString(1, skills.getSkillName());
				statement.setInt(2, skills.getSkillId());
				statement.executeUpdate();
				return 1;

			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
				return 0;
			}
			
		}

		public static int deleteSkillsHelper(int id) {
			// TODO Auto-generated method stub
			String query=SkillsQuery.deleteById;
			try (Connection connection = DBInfo.getConn();
					PreparedStatement statement = connection
							.prepareStatement(query);) {

				statement.setInt(1, id);
				statement.executeUpdate();
				return 1;

			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
				return 0;
			}
		}
}
