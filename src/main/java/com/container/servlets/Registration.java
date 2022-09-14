package com.container.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.container.beans.Notifications;
import com.container.beans.SendEmail;

import com.container.dao.ApplicationProxy;


@WebServlet("/registration")
public class Registration extends HttpServlet {
	private String querystatus = null;
	private Notifications notify = new Notifications();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int response = 0;
		String user = req.getParameter("username");
		String firstPass = req.getParameter("firstPass");
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
	    String hashedPass = org.apache.commons.codec.digest.DigestUtils.sha256Hex(firstPass); 		
		String email = req.getParameter("email");
		String jspstate = "";
		
		try {
			String active = "1";
				String token = UUID.randomUUID().toString();
				response = new ApplicationProxy().storeCredentials(user, firstname, lastname, hashedPass, email, active, token);
				
				String textBody = "Thank you for signing up with us! click on this link to verify your email: "+ req.getRequestURL()+"?token="+token;
				String subject = "Email Verification";
				
				SendEmail verifyEmail = new SendEmail();
				verifyEmail.sendEmail(email,"capstoneproject@gmail.com",textBody,subject );
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}

		if(response > 0){
			querystatus = "Successful!";
		}else{
			querystatus ="Unsuccessful!";
		}

		//jspstate = "<div class='alert alert-warning' role='alert'>Invalid login information</div>";
		//req.setAttribute("msg", jspstate);

		req.setAttribute("msg", querystatus);
		//req.getRequestDispatcher("/capstone/html/registration.jsp").forward(req, resp);
//		/resp.sendRedirect("/registration.jsp?message="+querystatus);
		resp.sendRedirect(req.getContextPath() + "/registration?message="+querystatus);

	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
 		 String token = req.getParameter("token");
 		 
 		 try {
			new ApplicationProxy().verifyToken(token);
				System.out.println("successfully verified Email!!!");
			    resp.sendRedirect(req.getContextPath() + "/login");
				//resp.sendRedirect("/login.jsp");
			
		 }catch (SQLException e) {
				String message = "Failed to verify Email! Please try again later.";
			 	resp.sendRedirect(req.getContextPath() + "/registration?message="+message);
				//resp.sendRedirect("/registration.jsp?message="+message);
				e.printStackTrace();
		 }
   }
}