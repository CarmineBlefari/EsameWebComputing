window.addEventListener("load" , function(){
	aggiungiEventi11();
});

function aggiungiEventi11()
{
	var btnModifica = document.querySelector("#btnModificaTipo");
	btnModifica.addEventListener("click" , function(){
		var selectedCheckBoxes = document.querySelectorAll("input:checked");
		
		if(selectedCheckBoxes.length > 0)
		{
			var t = document.getElementById("campoTipo");
			selectedCheckBoxes.forEach(function(checkbox , indice){
				var chiave = checkbox.getAttribute("id");
				var tipo = t.value;
				var param = {chiave , tipo};
				console.log(param);
				
				$.ajax({
					type:"POST",
					url:"/modifyTipo",
					contentType:"application/json",
					data:param,
					success: function(risposta)
					{
						console.log(risposta);
						alert("Tipologia Modificata");
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