package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DataBaseHelper;
import com.model.Employee;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

/**
 * Servlet implementation class updateServlet
 */
@WebServlet("/CallupdateServlet")
public class CallupdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CallupdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		int empId = Integer.parseInt(request.getParameter("id"));
		Employee employee = DataBaseHelper.getEmployeeByIdHelper(empId);
		
		if (employee != null) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Show Employees</title>");
			out.println("<link rel=\"stylesheet\"  href=\"emp.css\">");
			out.println("</head>");
			out.println("<body>");
			out.println("<table  id=\"header\"  width =\"100%\" align = \"center\">");
			out.println("<tr>");

			out.println("<td><img src=\"metacube.png\"  width= \"200px\"/></td>");
			out.println(
					"<td  width = \"520px\" align=right><a href= \"IndexPage.html\">Home |</a><a href= \"about.html\">About |</a>");
			out.println(
					"<a href= \"gallery.html\">Gallery |</a><a href= \"product.html\">Product |</a><a href= \"contact.html\">Contact |</a>");
			out.print("<a href= \"SignUp.html\">Sign Up |</a><a href= \"LogIn.html\">Log In </a>");
			out.println("</td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("<form action = 'UpdateDetailInDatabase' >");
			out.println("<input type='hidden' value='" + empId
					+ "' name='id'/>");
			out.println("<table>");
			out.println("<tr>");
			out.println("<td><b>First Name</b></td>");
			out.println("<td> <input type = \"text\" name = \"firstName\" value = \""
					+ employee.getFirstName() + "\" /></td>");
			out.println("</tr>");
			out.println("<td><b>Last Name</b></td>");
			out.println("<td> <input type = \"text\" name = \"lastName\" value = \""
					+ employee.getLastName() + "\" /></td>");
			out.println("</tr>");
			out.println("<td><b>Email</b></td>");
			out.println("<td> <input type = \"email\" name = \"email\" value = \""
					+ employee.getEmailId() + "\" /></td>");
			out.println("</tr>");
			out.println("<td><b>Age</b></td>");
			out.println("<td > <input type = \"number\" name = \"age\" value = \""
					+ employee.getAge() + "\" /></td>");
			out.println("</tr>");
			out.println("</tr>");
			out.println("<td colspan = \"2\"> <input type = \"submit\" value = \"Update\" /></td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		} else {
			out.println("Cannot Update right now. Try again later.");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
