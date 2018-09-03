package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.websocket.SendResult;

import com.facade.RegisterUserFacade;
import com.model.User;

/**
 * Servlet implementation class RegisterUserServlet
 */
@WebServlet("/RegisterUserServlet")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Date dob = Date.valueOf(request.getParameter("dateofbirth"));
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPass = request.getParameter("confirmPassword");
		String contactNumber = request.getParameter("contact");
		String company = request.getParameter("company");
		User result = RegisterUserFacade.register(firstName, lastName, dob, email, password, confirmPass, contactNumber,
				company);
		PrintWriter out = response.getWriter();
		if (result != null) {
			HttpSession session = request.getSession(false);
			if(session!=null)
			{
			JOptionPane.showMessageDialog( null, "session expired!", "Failure", JOptionPane.ERROR_MESSAGE);
			HttpSession Nsession = request.getSession(true);	
			Nsession.setAttribute("userDetail", result);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ProfilePageServlet");
			requestDispatcher.forward(request, response); 
			}
		} else {
			response.sendRedirect("Registration.html");
		}
		out.println("</body>");
		out.println("<html>");
	}
}
