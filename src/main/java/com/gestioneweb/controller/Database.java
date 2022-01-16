package com.gestioneweb.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database {
	
	public static List<Messaggi> dammiMessaggi()
	{
		List <Messaggi> messaggi = new ArrayList<Messaggi>();
		
		String sql = "select * from messaggiVenditore";
		
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", 
															"postgres", "admin");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) 
			{
				Messaggi m = new Messaggi(rs.getString(3) , rs.getString(2), rs.getString(1));
				messaggi.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return messaggi;
	}
	
	public static List<Annuncio> dammiAnnunci()
	{
		
		List <Annuncio> annunci = new ArrayList<Annuncio>();
		
		String sql = "select * from annunci";
		
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", 
															"postgres", "admin");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) 
			{
				Annuncio a = new Annuncio(rs.getInt(1) , rs.getInt(2) ,rs.getInt(9), rs.getString(3) , rs.getString(4), rs.getString(5), rs.getInt(6) , rs.getString(7) , rs.getString(8));
				annunci.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return annunci;
	}
	static List <Annuncio> annunciFiltrati = new ArrayList<Annuncio>();
	public boolean mostra(int tipo)
	{
		
		String sql = "select * from annunci";
		
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", 
															"postgres", "admin");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) 
			{
				if(rs.getInt(7) == tipo)
				{
					Annuncio a = new Annuncio(rs.getInt(1) , rs.getInt(2) ,rs.getInt(9), rs.getString(3) , rs.getString(4), rs.getString(5), rs.getInt(6) , rs.getString(7),rs.getString(8));
					annunciFiltrati.add(a);
				}
			}
			return true;
		} catch (SQLException e) {
			return false;
		}
		
	}
	public static List<Annuncio> dammiAnnunciFiltrati()
	{
		return annunciFiltrati;
	}
	private Database() {}
	
	private static Database instance = null;
	
	public static Database getInstance() {
		if(instance == null)
		{
			instance = new Database();
		}
		return instance;
	}
	
	public boolean deleteAnnuncio(int chiave)
	{	
		String sql = "DELETE FROM annunci WHERE id = ?";
		try
		{
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", 
				"postgres", "admin");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,chiave);
			ps.execute();
			return true;
		}
		catch(SQLException e)
		{
			return false;
		}
	}
	
	public String currentRecensione(int chiave , String recensione)
	{
		String sql2 = "select * from annunci";
		String result = "";
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", 
															"postgres", "admin");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql2);
			while (rs.next()) 
			{
				if(rs.getInt(9) == chiave)
				{
					result = rs.getString(4)+"\n"+recensione;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean addRecensione(int chiave , String recensione)
	{
		String sql = "UPDATE annunci SET recensione = ? WHERE id = '" + chiave + "'";
		try
		{
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", 
				"postgres", "admin");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,currentRecensione(chiave,recensione));
			ps.execute();
			return true;
		}
		catch(SQLException e)
		{
			return false;
		}
	}
	
	public boolean modifyPrezzo(int chiave , int prezzo)
	{
		String sql = "UPDATE annunci SET prezzo = ? WHERE id = '"+chiave+"'";
		try
		{
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", 
				"postgres", "admin");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,prezzo);
			ps.execute();
			return true;
		}
		catch(SQLException e)
		{
			return false;
		}
	}
	
	public boolean modifyTipo(int chiave , int tipo)
	{
		String sql = "UPDATE annunci SET tipo = ? WHERE id = '"+chiave+"'";
		try
		{
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", 
				"postgres", "admin");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,tipo);
			ps.execute();
			return true;
		}
		catch(SQLException e)
		{
			return false;
		}
	}
	
	public boolean modifyMetri(int chiave , int metri)
	{
		String sql = "UPDATE annunci SET metri = ? WHERE id = '"+chiave+"'";
		try
		{
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", 
				"postgres", "admin");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,metri);
			ps.execute();
			return true;
		}
		catch(SQLException e)
		{
			return false;
		}
	}
	
	public boolean modifyRecensione(int chiave , String recensione)
	{
		String sql = "UPDATE annunci SET recensione = ? WHERE id = '"+chiave+"'";
		try
		{
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", 
				"postgres", "admin");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,recensione);
			ps.execute();
			return true;
		}
		catch(SQLException e)
		{
			return false;
		}
	}
	
	public boolean modifyDescrizione(int chiave , String descrizione)
	{
		String sql = "UPDATE annunci SET descrizione = ? WHERE id = '"+chiave+"'";
		try
		{
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", 
				"postgres", "admin");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,descrizione);
			ps.execute();
			return true;
		}
		catch(SQLException e)
		{
			return false;
		}
	}
	
	public boolean modifyImage(int chiave , String image)
	{
		String sql = "UPDATE annunci SET image = ? WHERE id = '"+chiave+"'";
		try
		{
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", 
				"postgres", "admin");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,image);
			ps.execute();
			return true;
		}
		catch(SQLException e)
		{
			return false;
		}
	}
	
	public boolean banUser(String utente)
	{
		String sql = "DELETE FROM users WHERE username = ?";
		try
		{
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", 
				"postgres", "admin");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,utente);
			ps.execute();
			return true;
		}
		catch(SQLException e)
		{
			return false;
		}
	}
	
	public boolean promuoviUser(String utente)
	{
		String sql = "UPDATE users SET tipo = 3 WHERE username = '"+utente+"'";
		try
		{
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", 
				"postgres", "admin");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();
			return true;
		}
		catch(SQLException e)
		{
			return false;
		}
	}
}
