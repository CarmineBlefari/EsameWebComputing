<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vendi e Affitta!</title>

    <!-- Stile dell'index -->
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/styleAnnunci.css">

    <!--Owl Carousel -->
    <link rel="stylesheet" href="../css/owl.carousel.min.css">
    <link rel="stylesheet" href="../css/owl.theme.default.min.css">

    <!--Stile delle icone-->
    <link rel="stylesheet" href="../css/all.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
    
    <nav class="nav">
        <div class="nav-menu flex-row">
            <div class="nav-brand">
                <a href="index.html" class="text-grey">Vendi e Affitta!</a>
            </div>
            <div class="toggle-collapse">
                <div class="toggle-icons">
                    <i class="fas fa-bars"></i>
                </div>
            </div>
            <div class="socials text-grey">
                <a href="#"><i class="fab fa-facebook-square"></i></a>
                <a href="https://www.instagram.com/wearecalabria/"><i class="fab fa-instagram"></i></a>
                <a href="#"><i class="fab fa-youtube"></i></a>
            </div>
        </div>
        
    </nav>

	<hr>

	<main>
		
		<h2 class="title-annunci">Qui sotto puoi creare,modificare o eliminare annunci!</h2>
		<p>Benvenuto venditore : ${username}</p> 
		<hr>
		<br>
		
		<form method="post" action="modificaAnnuncio">
			<table id="annunci" class = "table-annunci-elenco" border = "1">
		        <tbody>
		        		<tr>
		        			<th>Azioni</th>
			        		<th><input type="button" class="button-annuncio" value="Elimina Annuncio" id="btnCancellaAnnuncio"></th>
			        	</tr>
	        		<c:forEach items="${annunci}" var="ann">
		        		<tr>
		        			<th>Select</th>
			        		<th>Prezzo</th>
			        		<th>Metri</th>
			        		<th>Descrizione</th>
			        		<th>Recensioni</th>
			        		<th>Foto</th>
			        		<th>Tipologia</th>
			        		<th>Posizione</th>
			        	</tr>
	        			<tr>
	        				<td class="no-border"><input id="${ann.id}" type="checkbox"/></td>
		        			<td class="no-border">
		        				<div class="background">
		        					€ : ${ann.prezzo}
		        				</div>
		        			</td>
		        			<td class="no-border">
		        				<div class="background">
		        					${ann.metri} .mq
		        				</div>
		        			</td>
		        			<td class="no-border" width="160px">
		        				<div class="background">
		        					${ann.descrizione}
		        				</div>
		        			</td>
		        			<td class="recensione">
		        				<div class="background">
		        					${ann.recensione}
		        				</div>
		        			</td>
		        			<td><img src="../images/${ann.image}" width="100px" height="100px"></td>
		        			<td class="tipologia">
		        				<div class="background">
		        					${ann.tipo}
		        				</div>
		        			</td>
		        			<td class="no-border">
		        				<div class="background">
		        					${ann.coordinate}
		        				</div>
		        			</td>
	        			</tr>
	        			<tr>
		        			<th style="border:none"></th>
			        		<th class="button-annuncio-modifica">
			        			<input type="number" placeholder="prezzo" id="campoPrezzo">
			        			<input type="button" class="button-modifica" value="Modifica Prezzo" id="btnModificaPrezzo">
			        		</th>
			        		<th class="button-annuncio-modifica">
			        			<input type="number" placeholder="metri" id="campoMetri">
			        			<input type="button" class="button-modifica" value="Modifica Metri" id="btnModificaMetri">
			        		</th>
			        		<th class="button-annuncio-modifica">
			        			<input type="text" placeholder="descrizione" id="campoDescrizione">
			        			<input type="button" class="button-modifica"  value="Modifica Descrizione" id="btnModificaDescrizione">
			        		</th>
			        		<th class="button-annuncio-modifica">
			        			<input type="text" placeholder="recensione.." id="campoRecensione">
			        			<input type="button"  class="button-modifica" value="Modifica Recensione" id="btnModificaRecensione">
			        		</th>
			        		<th class="button-annuncio-modifica">
			        			<input type="file" accept="image/*" id="campoFoto" value="" class="file-chooser">
			        			<input type="button"  class="button-modifica" value="Modifica Foto" id="btnModificaImage">
			        		</th>
			        		<th class="button-annuncio-modifica">
			        			<select id = "campoTipo">
									<option value = "1">Appartamento</option>
									<option value = "2">Villa</option>
									<option value = "3">Auto</option>
									<option value = "4">Terra</option>
								</select>
			        			<input type="button"  class="button-modifica" value="Modifica Tipo" id="btnModificaTipo">
			        		</th>
			        	</tr>
	        		</c:forEach>
		        </tbody>
	        </table>
	    </form>
		
		
    </main>

   
    <!-- FOOTER -->

    <footer class="footer">
        <div class="container">
            <div class="about-us">
                <h2>About Us</h2>
                <p>Questa pagina nasce per promuovere la nostra azienda immobiliare!
                	Affidati a noi per i tuoi acquisti , le tue venditi o eventuali affitti!
                </p>
            </div>
            <div class="newsletter">
            </div>
            <div class="follow">
                <h2>&nbsp;Follow Us</h2>
                <p>&nbsp;&nbsp;Seguici sui nostri social per essere sempre aggiornato</p>
                <div class="socials text-grey">
	                <a href="https://www.facebook.com/"><i class="fab fa-facebook-square"></i></a>
	                <a href="https://www.instagram.com/"><i class="fab fa-instagram"></i></a>
	                <a href="https://www.youtube.com/"><i class="fab fa-youtube"></i></a>
           		</div>
            </div>
        </div>
        <div class="rights flex-row">
            <h4 class="rights-text">
                Copyright 2021 All rights reserved | made by
                <a href="#" target="_black">Carmine Blefari&nbsp;<i class="fab fa-instagram"></i></a>
            </h4>
        </div>
        <a href="#" class="to-top">
            <span><i class="fas fa-arrow-circle-up fa-2x"></i></span>
        </a>
    </footer>

    <!-------------Fine FOOTER-------------------->

	<script type="text/javascript">
		function deleteRow(i){
   			document.getElementById('annunci').deleteRow(i)
   			document.getElementById('annunci').deleteRow(i-1)
		}
	</script>

	<!--cio che riguarda jquery-->
    <script src="./js/jquery3.6.0.min.js"></script>

    <!--owl carousel js-->
    <script src="./js/owl.carousel.js"></script>
    <script src="./js/owl.carousel.min.js"></script>

    <!--cio che riguarda java script-->
    <script src="./js/main.js"></script>

    <script src="../js/modeAnnuncio.js"></script>
    <script src="../js/main.js"></script>
    <script src="../js/GestioneAnnunci.js"></script>
    <script src="../js/modificaAnnuncio/ModificaPrezzo.js"></script>
    <script src="../js/modificaAnnuncio/ModificaTipo.js"></script>
    <script src="../js/modificaAnnuncio/ModificaMetri.js"></script>
    <script src="../js/modificaAnnuncio/ModificaDescrizione.js"></script>
    <script src="../js/modificaAnnuncio/ModificaRecensione.js"></script>
    <script src="../js/modificaAnnuncio/ModificaFoto.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
     

</body>
</html>