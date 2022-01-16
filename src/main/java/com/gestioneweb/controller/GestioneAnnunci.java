package com.gestioneweb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GestioneAnnunci {

	@GetMapping("/gestioneAnnunci/elencoAnnunci")
	public String elencoAnnunci(HttpServletRequest req)
	{
		List<Annuncio> annunci = Database.dammiAnnunci();
		
		req.setAttribute("annunci", annunci);
		
		return "elenco_annuncio";
	}	
	
	@GetMapping("/gestioneAnnunci/elencoAnnunciAcquirente")
	public String elencoAnnunciAcquirente(HttpServletRequest req)
	{
		List<Annuncio> annunci = Database.dammiAnnunci();
		
		req.setAttribute("annunci", annunci);
		
		return "elencoAnnunci_Acquirente";
	}	
	
	@GetMapping("/gestioneAnnunci/elencoAnnunciAmministratore")
	public String elencoAnnunciAmministratore(HttpServletRequest req)
	{
		List<Annuncio> annunci = Database.dammiAnnunci();
		
		req.setAttribute("annunci", annunci);
		
		return "elencoAnnunci_Amministratore";
	}	
}
