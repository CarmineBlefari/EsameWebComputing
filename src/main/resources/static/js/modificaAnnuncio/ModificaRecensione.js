window.addEventListener("load" , function(){
	aggiungiEventi5();
});

function aggiungiEventi5()
{
	var btnModifica = document.querySelector("#btnModificaRecensione");
	btnModifica.addEventListener("click" , function(){
		var selectedCheckBoxes = document.querySelectorAll("input:checked");
		
		if(selectedCheckBoxes.length > 0)
		{
			var r = document.getElementById("campoRecensione");
			selectedCheckBoxes.forEach(function(checkbox , indice){
				var chiave = checkbox.getAttribute("id");
				var recensione = r.value;
				var param = {chiave , recensione};
				console.log(param);
				
				$.ajax({
					type:"POST",
					url:"/modifyRecensione",
					contentType:"application/json",
					data:param,
					success: function(risposta)
					{
						console.log(risposta);
						alert("Recensione Modificata");
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