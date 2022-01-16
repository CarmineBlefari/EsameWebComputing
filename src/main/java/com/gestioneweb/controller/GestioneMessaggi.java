package com.gestioneweb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GestioneMessaggi {
	@GetMapping("/gestioneMessaggi/elencoMessaggi")
	public String elencoMessaggi(HttpServletRequest req)
	{
		List<Messaggi> messaggi = Database.dammiMessaggi();
		
		req.setAttribute("messaggi", messaggi);
		
		return "elenco_messaggi";
	}	
}
