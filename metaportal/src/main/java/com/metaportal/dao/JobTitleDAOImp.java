package com.metaportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metaportal.modal.JobTitleMaster;

;

public class JobTitleDAOImp {

	public static List<JobTitleMaster> getAllJobHelper() {

		List<JobTitleMaster> list = new ArrayList<JobTitleMaster>();
		String query = JobTitleQuery.getAllJobs;
		try (Connection connection = DBInfo.getConn();
				PreparedStatement statement = connection
						.prepareStatement(query);) {
			ResultSet rest = statement.executeQuery();

			while (rest.next()) {
				JobTitleMaster job = new JobTitleMaster();
				job.setJobCode(rest.getInt("jobCode"));
				job.setJobTitle(rest.getString("jobTitle"));

				list.add(job);
			}
			return list;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return null;
		}

	}

	public static int insertJobsHelper(JobTitleMaster Jobs) {
		String query = JobTitleQuery.insertJob;
		try (Connection connection = DBInfo.getConn();
				PreparedStatement statement = connection
						.prepareStatement(query);) {

			statement.setString(1, Jobs.getJobTitle());
			statement.executeUpdate();
			return 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return 0;
		}
	}

	public static JobTitleMaster getJobsByIdHelper(int id) {
		String query = JobTitleQuery.getJobById;
		try (Connection connection = DBInfo.getConn();
				PreparedStatement statement = connection
						.prepareStatement(query);) {
			statement.setInt(1, id);
			ResultSet rest = statement.executeQuery();
			JobTitleMaster Jobs = new JobTitleMaster();
			while (rest.next()) {
				Jobs.setJobCode(rest.getInt("jobCode"));
				Jobs.setJobTitle(rest.getString("jobTitle"));
			}
			return Jobs;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return null;
		}
	}

	public static int updateJobsHelper(JobTitleMaster jobs) {
		// TODO Auto-generated method stub
		String query = JobTitleQuery.updateJob;
		try (Connection connection = DBInfo.getConn();
				PreparedStatement statement = connection
						.prepareStatement(query);) {

			statement.setString(1, jobs.getJobTitle());
			statement.setInt(2, jobs.getJobCode());
			
			statement.executeUpdate();
			return 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return 0;
		}

	}

	public static int deleteJobsHelper(int id) {
		// TODO Auto-generated method stub
		String query = JobTitleQuery.deleteById;
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
