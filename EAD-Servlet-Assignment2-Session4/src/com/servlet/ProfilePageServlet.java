package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.dao.userDAO.DataBaseHelperUser;
import com.model.User;

/**
 * Servlet implementation class ProfilePageServlet
 */
@WebServlet("/ProfilePageServlet")
public class ProfilePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession(false);
		User user=(User) session.getAttribute("userDetail");
		PrintWriter out = response.getWriter();
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
		out.println("<td><p width = \"520px\" align=right><b>Welcome,</b></a><button id=\"show\" style=' border-radius: 50%;'><img src=\"image.png\" name='image' align='center' alt=\"dp\" style=\"width:60px;border-radius:50%\"></button>");
		out.print("<a href= \"ProfilePageServlet\">"
				+ user.getFirstName().toUpperCase() + " "
				+ user.getLastName().toUpperCase() + "!</a><a href=\"LogOutServlet\" style='color:red'><b>LogOut</b> </a></p>");
		out.println("</td>");
		out.println("<form method=\"post\" action=\"ProfilePicServlet\" encType=\"multipart/form-data\">\r\n" + 
				"	<dialog> \r\n" + 
				"		<p>Choose file to upload!</p>\r\n" + 
				"		<input type=\"file\" id=\"myFile\" name='imgFile' style='border:none' size=\"50\"/>\r\n" + 
				"		<p><button id=\"close\">Cancel</button></p>\r\n" + 
				"		<input type=\"submit\" id=\"Upload\" value=\"upload\"/>\r\n" + 
				"		</dialog>\r\n" + 
				"</form>\r\n" + 
				"");
		out.println("<script>\r\n" + 
				"  var dialog = document.querySelector('dialog');\r\n" + 
				"  document.querySelector('#show').onclick = function() {\r\n" + 
				"    dialog.show();\r\n" + 
				"  };\r\n" + 
				"  document.querySelector('#close').onclick = function() {\r\n" + 
				"    dialog.close();\r\n" + 
				"  };\r\n" + 
				"function myFunction() {\r\n" + 
				"    var x = document.getElementById(\"myFile\").value;\r\n" + 
				"    document.getElementById(\"demo\").innerHTML = x;\r\n" + 
				"}\r\n" + 
				"</script>");
		out.println("</tr></table>");
		out.println("<form action = 'ProfilePageServlet' method='get' >");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td><b>First Name</b></td>");
		out.println("<td> <input type = \"text\" readonly name = \"firstName\" value = \""
				+ user.getFirstName() + "\" /></td>");
		out.println("</tr><tr>");
		out.println("<td><b>Last Name</b></td>");
		out.println("<td> <input type = \"text\"readonly name = \"lastName\" value = \""
				+ user.getLastName() + "\" /></td>");
		out.println("</tr><tr>");
		out.println("<td><b>Dob</b></td>");
		out.println("<td> <input type = \"date\"readonly name = \"dob\" value = \""
				+ user.getDob() + "\" /></td>");
		out.println("</tr><tr>");
		out.println("<td><b>Contact Number</b></td>");
		out.println("<td> <input type = \"text\"readonly name = \"contactNumber\" value = \""
				+ user.getContactNumber() + "\" /></td>");
		out.println("</tr><tr>");
		out.println("<td><b>Email</b></td>");
		out.println("<td> <input type = \"email\"readonly name = \"email\" value = \""
				+ user.getEmail() + "\" /></td>");
		out.println("</tr><tr>");
		out.println("<td><b>Company</b></td>");
		out.println("<td > <input type = \"text\" readonly name = \"company\" value = \""
				+ user.getCompany() + "\" /></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td colspan = \"2\"> <input type = \"submit\" value = \"Edit\" /></td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("<p><a href=\"ShowAllFriends\"><input type='button' value='Friends'></a></p>");
		out.println("</body>");
		out.println("</html>");
		JOptionPane.showMessageDialog(null, "Welcome!!");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		User user=(User) session.getAttribute("userDetail");
		PrintWriter out = response.getWriter();
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
		out.println("<form action = 'ProfilePageServlet' method='post' >");
		//out.println("<input type='hidden' value='" + user.getId() + "' name='id'/>");
		out.println("<table >");
		out.println("<tr><td class=\"fieldName\">First Name:</td></tr>");
		out.println("<tr><td class=\"inputCol\" ><input type=\"text\" size=\"30px\" maxlength='50' name=\"firstName\" required  placeholder="
				+ user.getFirstName()
				+ " id=\"FirstName\" onblur=\"return FNameValidate()\"></td></tr>");
		out.println("<tr><td class=\"fieldName\">Last Name:</td></tr>");
		out.println("<tr><td class=\"inputCol\" ><input type=\"text\" size=\"30px\" maxlength='50' name=\"lastName\" required placeholder="
				+ user.getLastName()
				+ " id=\"LastName\"  onblur=\"return LNameValidate()\"></td></tr>");
		out.println("<tr><td class=\"fieldName\">DOB:</td></tr>");
		out.println("<tr><td class=\"inputCol\"><input type=\"DATE\" size=\"30px\" maxlength=\"50\" name=\"dateofbirth\" required id=\"dateofbirth\" placeholder="
				+ user.getDob() + "></td></tr>");
		out.println("<tr><td class=\"fieldName\">Email Id:</td></tr>");
		out.println("<tr><td class=\"inputCol\" ><input type=\"email\" size=\"30px\" maxlength='50' name=\"email\"  readonly value="
				+ user.getEmail() + " id=\"Email\"></td></tr>");
		out.println("<tr><td class=\"fieldName\">Contact Number:</td></tr>");
		out.println("<tr><td class=\"inputCol\" ><input type=\"text\" size=\"30px\" maxlength='50' name=\"contact\" required placeholder="
				+ user.getContactNumber()
				+ " id=\"number\" onblur=\"return ContatctNumberValidate()\"></td></tr>");
		out.println("<tr><td class=\"fieldName\">Company</td></tr>");
		out.println("<tr><td class=\"inputCol\" ><input type=\"text\" size=\"30px\" maxlength='50' name=\"company\" readonly value="
				+ user.getCompany() + " id=\"number\"></td></tr>");
		out.println("</table>");
		out.println("<input type=\"Submit\" value=\"Update\">");
		out.println("</form>");
		out.println("<p><a href=\"ShowAllFriends\"><input type='button' value='Friends'></a></p>");
		out.println("</body>");
		out.println("</html>");
		JOptionPane.showMessageDialog(null, "Welcome!!");
	}
}
