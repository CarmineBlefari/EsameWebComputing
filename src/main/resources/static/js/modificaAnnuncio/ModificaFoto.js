window.addEventListener("load" , function(){
	aggiungiEventi7();
});

function aggiungiEventi7()
{
	var btnModifica = document.querySelector("#btnModificaImage");
	btnModifica.addEventListener("click" , function(){
		var selectedCheckBoxes = document.querySelectorAll("input:checked");
		
		if(selectedCheckBoxes.length > 0)
		{
			var i = document.getElementById("campoFoto");
			selectedCheckBoxes.forEach(function(checkbox , indice){
				var chiave = checkbox.getAttribute("id");
				var img = i.value;
				var param = {chiave , img};
				console.log(param);
				
				$.ajax({
					type:"POST",
					url:"/modifyImage",
					contentType:"application/json",
					data:param,
					success: function(risposta)
					{
						console.log(risposta);
						alert("Immagine Modificata");
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