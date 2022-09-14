package com.container.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.container.beans.SendEmail;
import com.container.dao.ApplicationProxy;
import com.container.dao.DBConnection;

public class PasswordRecovery extends HttpServlet {

	public PasswordRecovery() {}
	
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String token = req.getParameter("token");
		ApplicationProxy proxy = new ApplicationProxy();
		try {
			ResultSet set = proxy.loadUsers(token);
			if(set.next()) {
				resp.sendRedirect("/passwordreset");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		Connection c = DBConnection.getConnectionToDatabase();
		String email = req.getParameter("email");
		String jspstate = null;
		
				String token = UUID.randomUUID().toString();
				
				String textBody = "Reset your password using this link: "+ req.getRequestURL()+"?token="+token;
				String subject = "Password Reset";
				
				String updateQuery = "UPDATE tblusers SET active = 0 WHERE email = ?";
				PreparedStatement statement = null;
				try {
					statement = c.prepareStatement(updateQuery);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					statement.setString(1,email);
					statement.execute();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				SendEmail verifyEmail = new SendEmail();
				verifyEmail.sendEmail(email,"capstoneproject@gmail.com",textBody,subject );
				
				String message = "Successful! Please check your email for password reset link.";
				
				resp.sendRedirect("/passwordrecovery?message="+message);
		
	}
}
