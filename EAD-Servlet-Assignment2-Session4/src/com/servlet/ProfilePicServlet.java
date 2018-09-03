package com.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import com.dao.userDAO.DataBaseHelperUser;
import com.model.User;
import com.mysql.jdbc.Blob;

/**
 * Servlet implementation class ProfilePicServlet
 */
@WebServlet("/ProfilePicServlet")
public class ProfilePicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession(false);
		User user=(User) session.getAttribute("userDetail");
		if(!ServletFileUpload.isMultipartContent(request)) {
			out.print("nithing gto ipload");
			return;
		}
	//	FileItemFactory itemf=new DiskFileItemFactory();
	//	ServletFileUpload upload= new ServletFileUpload(itemf);
//		try
//		{
			//DiskFileItemFactory diskFactory = new DiskFileItemFactory();
			//diskFactory.setSizeThreshold(4000);
			//diskFactory.setRepository(new File(System.getProperty("java.io.tmpdir")));
			ServletFileUpload uploadHandler = new ServletFileUpload(new DiskFileItemFactory());
			List<FileItem> items;
			try {
				items = uploadHandler.parseRequest(new ServletRequestContext( request));
			System.out.println(items);
			for(FileItem item: items) {		
		//	File uploadDIr=new File("D:\\movies");
			//File file=java.io.File.createTempFile("img", ".png", uploadDIr);
				System.out.println(item.getName());
				item.write(new File("C:/Users/Admin/Pictures"+item.getName()));
				User u=DataBaseHelperUser.uploadPic(user.getId(),item.getName());
				
				System.out.println("hiii");
			}
			}catch (FileUploadException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.println("succes");
			}
//		}}
//		 catch(FileUploadException e)
//		{
//			 e.printStackTrace();
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		 
	

}
