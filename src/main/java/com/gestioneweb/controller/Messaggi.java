package com.gestioneweb.controller;

public class Messaggi {
	private String venditore;
	private String acquirente;
	private String messaggio;
	public Messaggi(String venditore, String acquirente, String messaggio) {
		super();
		this.venditore = venditore;
		this.acquirente = acquirente;
		this.messaggio = messaggio;
	}
	public String getVenditore() {
		return venditore;
	}
	public void setVenditore(String venditore) {
		this.venditore = venditore;
	}
	public String getAcquirente() {
		return acquirente;
	}
	public void setAcquirente(String acquirente) {
		this.acquirente = acquirente;
	}
	public String getMessaggio() {
		return messaggio;
	}
	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}
}
