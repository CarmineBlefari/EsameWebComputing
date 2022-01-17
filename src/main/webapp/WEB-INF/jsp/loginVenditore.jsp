<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1,maximum-scale=1,user-scalable=no">
	<link href="https://api.mapbox.com/mapbox-gl-js/v2.6.1/mapbox-gl.css" rel="stylesheet">
	<script src="https://api.mapbox.com/mapbox-gl-js/v2.6.1/mapbox-gl.js"></script>

    <title>Vendi e Affitta!</title>

    <!-- Stile dell'index -->
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/styleAnnunci.css">

    <!--Owl Carousel -->
    <link rel="stylesheet" href="./css/owl.carousel.min.css">
    <link rel="stylesheet" href="./css/owl.theme.default.min.css">

    <!--Stile delle icone-->
    <link rel="stylesheet" href="./css/all.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
</head>
<body>   
    <nav class="nav">
        <div class="nav-menu flex-row">
            <div class="nav-brand">
                <a href="index.html" class="text-grey">Vendi e Affitta!</a>
            </div>
            <div>
                <ul class="nav-items">
                    <li class="nav-links">
                        <a href="gestioneAnnunci/elencoAnnunci">ANNUNCI</a>
                    </li>
                    <li class="nav-links">
                        <a href="gestioneMessaggi/elencoMessaggi">MESSAGGI</a>
                    </li>
                </ul>
            </div>
            <div class="toggle-collapse">
                <div class="toggle-icons">
                    <i class="fas fa-bars"></i>
                </div>
            </div>
            <div class="socials text-grey">
                <a href="faiLogOut">Log-out  <i class="fa fa-user"></i></a>
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
		    <br>
		    <hr>
         	<script src="https://api.mapbox.com/mapbox-gl-js/plugins/mapbox-gl-geocoder/v4.7.2/mapbox-gl-geocoder.min.js"></script>
			<link rel="stylesheet" href="https://api.mapbox.com/mapbox-gl-js/plugins/mapbox-gl-geocoder/v4.7.2/mapbox-gl-geocoder.css" type="text/css">
			 <div id="map" class="mappa"></div>
			 	<script>
					mapboxgl.accessToken = 'pk.eyJ1IjoiY2FybWluZTAwIiwiYSI6ImNreWZ5b3VzYTFubHMycW84eWp4Z28xbXAifQ.EC6IKdsbzFRdEnE5Ptnftg';
					const map = new mapboxgl.Map({
						container: 'map',
						style: 'mapbox://styles/mapbox/streets-v11',
						center: [-79.4512, 43.6568],
						zoom: 10
					});
				 
					// Add the control to the map.
					map.addControl(
						new MapboxGeocoder({
							accessToken: mapboxgl.accessToken,
							mapboxgl: mapboxgl
						})
						
					);
					map.on('click', (e) => {
						// When the map is clicked, get the geographic coordinate.
						var coordinate = map.unproject(e.point);
						console.log(coordinate.lat);
						console.log(coordinate.lng);
						$.ajax({
							url: 'https://api.mapbox.com/geocoding/v5/mapbox.places/'+coordinate.lng+','+coordinate.lat+'.json?access_token=pk.eyJ1IjoiY2FybWluZTAwIiwiYSI6ImNreWZ5b3VzYTFubHMycW84eWp4Z28xbXAifQ.EC6IKdsbzFRdEnE5Ptnftg',
							beforeSend: function(xhr) {
								xhr.setRequestHeader("Authorization", "Bearer 6QXNMEMFHNY4FJ5ELNFMP5KRW52WFXN5")
							}, success: function(data){
								document.getElementById("coordinates").value = data.features[0].place_name;
							}
						})
					});
				</script>
		   	<div class="category-annuncio">
                <div class="form">
                	<h2 class="category-title-annuncio">AGGIUNGI UN ANNUNCIO QUI</h2>
					<form class="registrazione-form" method="post" action="aggiungiAnnuncio">
						<p>prezzo<input class="int" type="number" value="0" name= "prezzo"></p>
						<p>metri<input class="int" type="number" value="0" name= "metri"></p>
						<input type="text" placeholder="aggiungi descrizione" name= "descrizione" value="">
						<textarea rows="4" placeholder="aggiungi recensione" name="recensione" ></textarea>
						<input type="file"  accept="image/*" name="image" value="" class="file-chooser">
						<select name = "tipo">
							<option value = "1">Appartamento</option>
							<option value = "2">Villa</option>
							<option value = "3">Auto</option>
							<option value = "4">Terra</option>
						</select>
						<input type="text" name="venditore" value="${username}" readonly><br><br>
						<input type="text" placeholder="coordinate.." name="coordinates" id="coordinates" readonly><br><br>
			        	<input type="submit" class="button-annuncio" value="Aggiungi">
					</form>
				</div>
         	</div>
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
    
    <!--cio che riguarda jquery-->
    <script src="./js/jquery3.6.0.min.js"></script>

    <!--owl carousel js-->
    <script src="./js/owl.carousel.js"></script>
    <script src="./js/owl.carousel.min.js"></script>

    <!--cio che riguarda java script-->
    <script src="./js/main.js"></script>
   

</body>
</html>