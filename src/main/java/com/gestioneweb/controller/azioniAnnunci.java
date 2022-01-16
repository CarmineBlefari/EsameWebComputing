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
public class azioniAnnunci {
	
	@PostMapping("/aggiungiAnnuncio")
	public String aggiungiAnnuncio(HttpServletRequest request, HttpServletResponse response,
						int prezzo , int metri , String descrizione , String recensione, String image, int tipo , String venditore, String coordinates) throws ServletException, IOException {
		
		String risposta = "loginVenditore";
		HttpSession session = request.getSession(true);	
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", 
															"postgres", "admin");
			
			PreparedStatement p = con.prepareStatement("INSERT INTO annunci VALUES(?, ?, ?, ?, ?, ?, ?, ?);");
			if(descrizione != "" && recensione != "" && prezzo != 0 && metri != 0)
			{
				session.setAttribute("descrizione", descrizione);
				p.setInt(1, prezzo);
				p.setInt(2, metri);
				p.setString(3, descrizione);
				p.setString(4, recensione);
				p.setString(5, image);
				p.setInt(6, tipo);
				p.setString(7, venditore);
				p.setString(8, coordinates);
				p.executeUpdate();
				p.close();
				risposta = "loginVenditore";
			}
			else
			{
				risposta = "loginVenditore";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return risposta;
	}
}
