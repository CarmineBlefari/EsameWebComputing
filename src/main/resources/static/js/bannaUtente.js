window.addEventListener("load" , function(){
	aggiungiEventi8();
});

function aggiungiEventi8()
{
	var btnBanna = document.querySelector("#btnBannaUtente");
	btnBanna.addEventListener("click" , function(){
				
				var utente = document.getElementById("utenteDaBannare");
				console.log(utente.value);
				
				$.ajax({
					type:"POST",
					url:"/banUser",
					contentType:"application/json",
					data:JSON.stringify(utente.value),
					success: function(risposta)
					{
						console.log(risposta);
						alert("Cancellato");
					},
					error(xhr)
					{
						console.log(xhr);
						alert("No");
					}
				});
				
			});
}


