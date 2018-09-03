package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.enums.Status;
import com.facade.LoginValidateFacade;
import com.model.User;

/**
 * Servlet implementation class LoginVALIDATIONServlet
 */
@WebServlet("/LoginVALIDATIONServlet")
public class LoginVALIDATIONServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Status status = LoginValidateFacade.checkValidUser(email, password);
		switch (status) {
		case FAILED:
			RequestDispatcher rd = request.getRequestDispatcher("LogIn.html");
			JOptionPane.showMessageDialog(null, "Something went wrong", "ERROR", JOptionPane.ERROR_MESSAGE);
			rd.forward(request, response);
			break;
		case NOT_FOUND:
			RequestDispatcher rds = request.getRequestDispatcher("LogIn.html");
			JOptionPane.showMessageDialog(null, "Invalid user or password", "ERROR", JOptionPane.ERROR_MESSAGE);
			rds.forward(request, response);
			break;
		case SUCCESS:
			User user = LoginValidateFacade.userByEmail(email);
			HttpSession session = request.getSession(true);
			session.setAttribute("userDetail", user);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ProfilePageServlet");
			requestDispatcher.forward(request, response);
			break;
		default:
			break;
		}
	}
}
