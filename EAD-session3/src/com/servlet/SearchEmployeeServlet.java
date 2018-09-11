package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DataBaseHelper;
import com.model.Employee;

/**
 * Servlet implementation class SearchEmployeeServlet
 */
@WebServlet("/SearchEmployeeServlet")
public class SearchEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchEmployeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		List<Employee> Employee = DataBaseHelper.searchEmployeeHelper(fname,
				lname);
		displayEmployee(Employee, response);

	}

	private void displayEmployee(List<Employee> listOfEmployee,
			HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
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
		out.println("<h1 align=\"center\">Employee Details:</h1>");
		out.println("<table align=\"center\"  border=\"1\">");
		out.println("<th>");
		out.println("<td class='empTable'><b>First Name</b></td>");
		out.println("<td class='empTable'><b>Last Name</b></td>");
		out.println("<td class='empTable'><b>Email</b></td>");
		out.println("<td class='empTable'><b>Age</b></td>");
		out.println("</th>");
		int rowCount = 1;
		for (Employee employee : listOfEmployee) {
			out.println("<tr>");
			out.println("<td class='empTable'>" + rowCount + "</td>");
			out.println("<td class='empTable'>" + employee.getFirstName() + "</td>");
			out.println("<td class='empTable'>" + employee.getLastName() + "</td>");
			out.println("<td class='empTable'>" + employee.getEmailId() + "</td>");
			out.println("<td class='empTable'>" + employee.getAge() + "</td>");
			out.println("</tr>");
			rowCount++;
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
