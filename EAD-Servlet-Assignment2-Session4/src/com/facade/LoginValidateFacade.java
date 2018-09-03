package com.facade;

import com.dao.userDAO.DataBaseHelperUser;
import com.enums.Status;
import com.model.User;


public class LoginValidateFacade {

	public static Status checkValidUser(String email,String password)
	{
		Status status=DataBaseHelperUser.userLogInValidationHelper(email, password);
		System.out.println(status);
		return status;
	}
	public static User userByEmail(String email) {

		User user=DataBaseHelperUser.userbyEmailHelper(email);
		return user;
	}
}
