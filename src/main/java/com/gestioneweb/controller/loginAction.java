package com.gestioneweb.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class loginAction {
	
	@GetMapping("/paginaLogin")
	public String paginaLogin()
	{
		return "usersActions";
	}
	
	@PostMapping("/loginServlet")
	public String doLogin(HttpServletRequest request, HttpServletResponse response,
						String username, String password) throws ServletException, IOException {
		String sql = "select * from users where username = '" + username + "'";
		String risposta = "usersActions";
		
		HttpSession session = request.getSession(true);		
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", 
															"postgres", "admin");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) 
			{
				if (rs.getString(2).equals(password)) {
					response.setStatus(HttpServletResponse.SC_OK);
					session.setAttribute("username", rs.getString("username"));
					if(rs.getInt(5) == 1)
					{
						risposta = "loginAcquirente";
					}
					if(rs.getInt(5) == 2)
					{
						risposta = "loginAmministratore";
					}
					if(rs.getInt(5) == 3)
					{
						risposta = "loginVenditore";
					}
					
				}else 
				{
					response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
					risposta = "usersActions";
				}
			}else 
			{
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return risposta;
		
	}
	
	@GetMapping("/faiLogOut")
	public String logOut(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		HttpSession session = request.getSession();
		session.invalidate();
		String risposta = "usersActions";
		return risposta;
	}
	
	
	@PostMapping("/doRegister")
	public String doRegister(HttpServletRequest request, HttpServletResponse response,
						String username, String password, String nome , String cognome , int tipo) throws ServletException, IOException {
		
		String risposta = "usersActions";
		HttpSession session = request.getSession(true);	
		
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", 
															"postgres", "admin");
			
			PreparedStatement p = con.prepareStatement("INSERT INTO users VALUES(?, ?, ?, ?, ?);");
			if(username != "" && password != "" && nome != "" && cognome != "")
			{
				session.setAttribute("username", username);
				p.setString(1, username);
				p.setString(2, password);
				p.setString(3, nome);
				p.setString(4, cognome);
				p.setInt(5 , tipo);
				p.executeUpdate();
				if(tipo == 1)
				{
					risposta = "loginAcquirente";
				}
				if(tipo == 2)
				{
					risposta = "loginAmministratore";
				}
				if(tipo == 3)
				{
					risposta = "loginVenditore";
				}
				p.close();
			}
			else
			{
				risposta = "usersActions";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return risposta;
	}
}
