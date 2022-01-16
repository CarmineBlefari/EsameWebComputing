window.addEventListener("load" , function(){
	aggiungiEventi6();
});

function aggiungiEventi6()
{
	var btnModifica = document.querySelector("#btnModificaDescrizione");
	btnModifica.addEventListener("click" , function(){
		var selectedCheckBoxes = document.querySelectorAll("input:checked");
		
		if(selectedCheckBoxes.length > 0)
		{
			var d = document.getElementById("campoDescrizione");
			selectedCheckBoxes.forEach(function(checkbox , indice){
				var chiave = checkbox.getAttribute("id");
				var descrizione = d.value;
				var param = {chiave , descrizione};
				console.log(param);
				
				$.ajax({
					type:"POST",
					url:"/modifyDescrizione",
					contentType:"application/json",
					data:param,
					success: function(risposta)
					{
						console.log(risposta);
						alert("Descrizione Modificata");
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