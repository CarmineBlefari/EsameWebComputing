window.addEventListener("load" , function(){
	aggiungiEventi3();
});

function aggiungiEventi3()
{
	var btnModifica = document.querySelector("#btnModificaPrezzo");
	btnModifica.addEventListener("click" , function(){
		var selectedCheckBoxes = document.querySelectorAll("input:checked");
		
		if(selectedCheckBoxes.length > 0)
		{
			var p = document.getElementById("campoPrezzo");
			selectedCheckBoxes.forEach(function(checkbox , indice){
				var chiave = checkbox.getAttribute("id");
				var prezzo = p.value;
				var param = {chiave , prezzo};
				console.log(param);
				
				$.ajax({
					type:"POST",
					url:"/modifyPrezzo",
					contentType:"application/json",
					data:param,
					success: function(risposta)
					{
						console.log(risposta);
						alert("Prezzo Modificato");
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