package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.userDAO.DataBaseHelperUser;
import com.model.User;

/**
 * Servlet implementation class FriendPageServlet
 */
@WebServlet("/FriendPageServlet")
public class FriendPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(false);
		User user=(User) session.getAttribute("userDetail");
		int friendId=Integer.parseInt(request.getParameter("id"));
		User friend=DataBaseHelperUser.getUserByIdHelper(friendId);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>UserProfile</title>");
		out.println("<link rel=\"stylesheet\"  href=\"session4.css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<table  id=\"header\"  width =\"100%\" align = \"center\">");
		out.println("<tr>");
		out.println("<td><img src=\"metacube.png\"  width= \"200px\"/></td>");
		out.println("<td><p width = \"520px\" align=right><b>Welcome,</b></a><a href=\" \"><img src=\"image.png\" align='center' alt=\"dp\" style=\"width:50px;border-radius:50%\"></a>");
		out.print("<a href= \"ProfilePageServlet\">"
				+ user.getFirstName().toUpperCase() + " "
				+ user.getLastName().toUpperCase() + "!</a><a href=\"LogOutServlet\" style='color:red'><b>LogOut</b> </a></p>");
		out.println("</td>");
		out.println("</tr></table>");
		out.println("<form action='ShowAllFriends'>");
		//out.println("<input type='hidden' value='" + user.getId() + "' name='id'/>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td><b>First Name</b></td>");
		out.println("<td> <input type = \"text\" readonly name = \"firstName\" value = \""
				+ friend.getFirstName() + "\" /></td>");
		out.println("</tr><tr>");
		out.println("<td><b>Last Name</b></td>");
		out.println("<td> <input type = \"text\"readonly name = \"lastName\" value = \""
				+ friend.getLastName() + "\" /></td>");
		out.println("</tr><tr>");
		out.println("<td><b>Dob</b></td>");
		out.println("<td> <input type = \"date\"readonly name = \"dob\" value = \""
				+ friend.getDob() + "\" /></td>");
		out.println("</tr><tr>");
		out.println("<td><b>Contact Number</b></td>");
		out.println("<td> <input type = \"text\"readonly name = \"contactNumber\" value = \""
				+ friend.getContactNumber() + "\" /></td>");
		out.println("</tr><tr>");
		out.println("<td><b>Email</b></td>");
		out.println("<td> <input type = \"email\"readonly name = \"email\" value = \""
				+ friend.getEmail() + "\" /></td>");
		out.println("</tr><tr>");
		out.println("<td><b>Company</b></td>");
		out.println("<td > <input type = \"text\" readonly name = \"company\" value = \""
				+ friend.getCompany() + "\" /></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td colspan = \"2\"> <input type = \"submit\" value = \"Back\" /></td>");
		out.println("</tr>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}	
}
