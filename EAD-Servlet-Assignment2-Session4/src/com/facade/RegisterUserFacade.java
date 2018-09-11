package com.facade;

import java.sql.Date;

import com.dao.userDAO.DataBaseHelperUser;
import com.model.User;

public class RegisterUserFacade {

	public static User register(String firstName, String lastName, Date dob,
			String email, String password, String confirmPass,
			String contactNumber, String company) {
		// TODO Auto-generated method stub
		int result = DataBaseHelperUser.insertUserHelper(firstName, lastName,
				dob, email, password, contactNumber, company);
		if (result == 1) {
			User user = DataBaseHelperUser.userbyEmailHelper(email);
			return user;
		} else if (result == -1)
			return null;
		else
			return null;
	}
}
