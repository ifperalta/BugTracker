package com.container.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.container.dao.ApplicationProxy;

public class PasswordReset extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int response = 0;
		String hashedPass = null;
		String firstPass = req.getParameter("firstPass");
		String secondPass = req.getParameter("secondPass");
		
		if(firstPass.equals(secondPass)) {
			hashedPass = org.apache.commons.codec.digest.DigestUtils.sha256Hex(firstPass); 
		}
		
		String token = req.getParameter("token");
		String jspstate = "";
		
		try {
				response = new ApplicationProxy().updatePassword(token, hashedPass);

		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		req.getRequestDispatcher("/registration.jsp").forward(req, resp);
		
	}
}
