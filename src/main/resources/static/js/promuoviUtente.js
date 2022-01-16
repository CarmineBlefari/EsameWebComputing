window.addEventListener("load" , function(){
	aggiungiEventi9();
});

function aggiungiEventi9()
{
	var btnPromuovi = document.querySelector("#btnPromuovi");
	btnPromuovi.addEventListener("click" , function(){
				
				var utente = document.getElementById("utenteDaPromuovere");
				console.log(utente.value);
				
				$.ajax({
					type:"POST",
					url:"/promuoviUser",
					contentType:"application/json",
					data:JSON.stringify(utente.value),
					success: function(risposta)
					{
						console.log(risposta);
						alert("Promosso");
					},
					error(xhr)
					{
						console.log(xhr);
						alert("No");
					}
				});
				
			});
}