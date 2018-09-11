package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DataBaseHelper;
import com.dao.dataBaseEmployee;

/**
 * AddEmployeeServlet implementation class AddEmployeeServlet
 */
@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddEmployeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		boolean result = DataBaseHelper.addEmployeeHelper(fname, lname, email, age);
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Add Employees</title>");
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
		if (result == true) {
			out.println("<div id='div' align='center' style=\"color:green\"><p><b>Data inserted successfully!!</b><p></div>");
		} else {
			out.println("<div id='div' align='center' style=\"color:red\"><p>Data insertion failed!!<p></div>");
		}
		out.println("</body>");
		out.println("<html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
