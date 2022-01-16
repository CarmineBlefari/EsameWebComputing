package com.gestioneweb.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class azioniMessaggi {
	@PostMapping("/aggiungiMessaggio")
	public String aggiungiMessaggio(HttpServletRequest request, HttpServletResponse response,
						String messaggio , String acquirente, String venditore) throws ServletException, IOException {
		String risposta = "loginAcquirente";
		HttpSession session = request.getSession(true);	
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", 
															"postgres", "admin");
			
			PreparedStatement p = con.prepareStatement("INSERT INTO messaggivenditore VALUES(?, ?, ?);");
			if(messaggio != "" && acquirente != "" && venditore != "")
			{
				session.setAttribute("acquirente", acquirente);
				p.setString(1, messaggio);
				p.setString(2, acquirente);
				p.setString(3, venditore);
				p.executeUpdate();
				p.close();
				risposta = "loginAcquirente";
			}
			else
			{
				risposta = "loginAcquirente";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return risposta;
	}
}
