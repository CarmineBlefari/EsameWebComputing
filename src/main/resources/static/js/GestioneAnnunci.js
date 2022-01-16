window.addEventListener("load" , function(){
	aggiungiEventi();
});

function aggiungiEventi()
{
	var btnCancella = document.querySelector("#btnCancellaAnnuncio");
	btnCancella.addEventListener("click" , function(){
		var selectedCheckBoxes = document.querySelectorAll("input:checked");
		
		if(selectedCheckBoxes.length > 0)
		{
			selectedCheckBoxes.forEach(function(checkbox , indice){
				var chiave = checkbox.getAttribute("id");
				
				$.ajax({
					type:"POST",
					url:"/deleteAnnuncio",
					contentType:"application/json",
					data:JSON.stringify(chiave),
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
	});
}














