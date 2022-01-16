package com.gestioneweb.controller;

public class Annuncio {

	private int prezzo;
	private int metri;
	private int id;
	private String descrizione;
	private String recensione;
	private String image;
	private int tipo;
	private String venditore;
	private String coordinate;
	public Annuncio(int prezzo, int metri, int id, String descrizione, String recensione, String image, int tipo,
			String venditore, String coordinate) {
		super();
		this.prezzo = prezzo;
		this.metri = metri;
		this.id = id;
		this.descrizione = descrizione;
		this.recensione = recensione;
		this.image = image;
		this.tipo = tipo;
		this.venditore = venditore;
		this.coordinate = coordinate;
	}
	public int getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}
	public int getMetri() {
		return metri;
	}
	public void setMetri(int metri) {
		this.metri = metri;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getRecensione() {
		return recensione;
	}
	public void setRecensione(String recensione) {
		this.recensione = recensione;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getVenditore() {
		return venditore;
	}
	public void setVenditore(String venditore) {
		this.venditore = venditore;
	}
	public String getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}
	
}
