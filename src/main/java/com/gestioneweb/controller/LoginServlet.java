package com.gestioneweb.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void  doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException 
	{
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String sql = "select * from users where username = '" + username + "'";
		
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", 
															"postgres", "admin");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) 
			{
				if (rs.getString(2).equals(password)) {
					request.getSession().setAttribute("username", rs.getString(1));
					response.setStatus(HttpServletResponse.SC_OK);
					if(rs.getInt(5) == 1)
					{
						//response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
						//response.setHeader("Location", "hello.jsp");
						String redirectURL = "http://www.google.com";
						response.sendRedirect(redirectURL); 
					}
					if(rs.getInt(5) == 2)
					{
						response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
						response.setHeader("Location", "amministratoreLoggato.html");
					}
					if(rs.getInt(5) == 3)
					{
						response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
						response.setHeader("Location", "venditoreLoggato.html");
					}
					
				}else 
				{
					response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				}
			}else 
			{
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@GetMapping("/faiLogOut")
	public String logOut(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		HttpSession session = request.getSession();
		session.invalidate();
		String risposta = "usersActions";
		return risposta;
	}
}
