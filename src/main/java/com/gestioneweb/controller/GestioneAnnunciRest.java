package com.gestioneweb.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GestioneAnnunciRest {

	@PostMapping("/deleteAnnuncio")
	public boolean cancellaAnnuncio(@RequestBody int chiave) throws Exception
	{
		if(Database.getInstance().deleteAnnuncio(chiave))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@PostMapping("/addRecensione")
	public boolean aggiungiRecensione(@RequestBody String obj) throws Exception
	{
		String elements[] = obj.split("&");
		String chiave = elements[0].substring(7);
		String recensione = elements[1].substring(11);
		int c = Integer.parseInt(chiave);
		if(Database.getInstance().addRecensione(c,recensione))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@PostMapping("/modifyPrezzo")
	public boolean modificaPrezzo(@RequestBody String obj) throws Exception
	{
		String elements[] = obj.split("&");
		String chiave = elements[0].substring(7);
		String prezzo = elements[1].substring(7);
		int c = Integer.parseInt(chiave);
		int p = Integer.parseInt(prezzo);
		if(Database.getInstance().modifyPrezzo(c,p))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@PostMapping("/modifyMetri")
	public boolean modificaMetri(@RequestBody String obj) throws Exception
	{
		String elements[] = obj.split("&");
		String chiave = elements[0].substring(7);
		String metri = elements[1].substring(6);
		int c = Integer.parseInt(chiave);
		int m = Integer.parseInt(metri);
		if(Database.getInstance().modifyMetri(c,m))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@PostMapping("/modifyRecensione")
	public boolean modificaRecensione(@RequestBody String obj) throws Exception
	{
		String elements[] = obj.split("&");
		String chiave = elements[0].substring(7);
		String r = elements[1].substring(11);
		String recensione = r.replace("%20", " ");
		int c = Integer.parseInt(chiave);
		if(Database.getInstance().modifyRecensione(c,recensione))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@PostMapping("/modifyDescrizione")
	public boolean modificaDescrizione(@RequestBody String obj) throws Exception
	{
		String elements[] = obj.split("&");
		String chiave = elements[0].substring(7);
		String d = elements[1].substring(12);
		String descrizione = d.replace("%20", " ");
		int c = Integer.parseInt(chiave);
		if(Database.getInstance().modifyDescrizione(c,descrizione))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@PostMapping("/modifyTipo")
	public boolean modificaTipo(@RequestBody String obj) throws Exception
	{
		String elements[] = obj.split("&");
		String chiave = elements[0].substring(7);
		String tipo = elements[1].substring(5);
		int c = Integer.parseInt(chiave);
		int t = Integer.parseInt(tipo);
		if(Database.getInstance().modifyTipo(c,t))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@PostMapping("/modifyImage")
	public boolean modificaImage(@RequestBody String obj) throws Exception
	{
		String elements[] = obj.split("&");
		String chiave = elements[0].substring(7);
		String image = elements[1].substring(22);
		int c = Integer.parseInt(chiave);
		if(Database.getInstance().modifyImage(c,image))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@PostMapping("/banUser")
	public boolean bannaUtente(@RequestBody String u) throws Exception
	{
		String utente = u.substring(1, u.length()-1);
		if(Database.getInstance().banUser(utente))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@PostMapping("/promuoviUser")
	public boolean promuoviUtente(@RequestBody String u) throws Exception
	{
		String utente = u.substring(1, u.length()-1);
		if(Database.getInstance().promuoviUser(utente))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
