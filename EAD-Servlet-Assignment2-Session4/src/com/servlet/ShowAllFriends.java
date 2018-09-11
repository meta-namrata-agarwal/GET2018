package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.userDAO.DataBaseHelperUser;

import com.model.User;

/**
 * Servlet implementation class ShowAllFriends
 */
@WebServlet("/ShowAllFriends")
public class ShowAllFriends extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		User user=(User) session.getAttribute("userDetail");
		List<User> listUser = DataBaseHelperUser.showAllUserHelper(user.getCompany(),user.getId());
		
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
		out.println("<h1 align=\"center\">user Details:</h1>");
		out.println("<table align=\"center\" border=\"1\">");
		out.println("<th>");
		out.println("<td class='empTable'><b> Name</b></td>");
		out.println("<td class='empTable'><b>DOB</b></td>");
		out.println("<td class='empTable'><b>Email</b></td>");
		out.println("<td class='empTable'><b>Company</b></td>");
		out.println("<td class='empTable'><b>Contact</b></td>");
		out.println("</th>");
		int rowCount = 1;
		for (User friend : listUser) {
			out.println("<tr>");
			out.println("<td class='empTable'>" + rowCount + "</td>");
			out.println("<td class='empTable'> <a href=\"FriendPageServlet?id="
					+ friend.getId() + "\">"+friend.getFirstName() +" " + friend.getLastName()+"</a> </td>");
			out.println("<td class='empTable'>" + friend.getDob() + "</td>");
			out.println("<td class='empTable'>" + friend.getEmail() + "</td>");
			out.println("<td class='empTable'>" + friend.getCompany() + "</td>");
			out.println("<td class='empTable'>" + friend.getContactNumber() + "</td>");
			out.println("</tr>");
			rowCount++;
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
}
