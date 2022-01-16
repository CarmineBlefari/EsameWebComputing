function Annuncio(prezzo , metri, descrizione , recensione , image , id)
{
	this.prezzo = prezzo;
	this.metri = metri;
	this.descrizione = descrizione;
	this.recensione = recensione;
	this.image = image;
	this.id = id;
}

annuncioConDescrizione = {
	"" : new Annuncio(0,0,"","","",0)
}