window.addEventListener("load" , function(){
	aggiungiEventi4();
});

function aggiungiEventi4()
{
	var btnModifica = document.querySelector("#btnModificaMetri");
	btnModifica.addEventListener("click" , function(){
		var selectedCheckBoxes = document.querySelectorAll("input:checked");
		
		if(selectedCheckBoxes.length > 0)
		{
			var m = document.getElementById("campoMetri");
			selectedCheckBoxes.forEach(function(checkbox , indice){
				var chiave = checkbox.getAttribute("id");
				var metri = m.value;
				var param = {chiave , metri};
				console.log(param);
				
				$.ajax({
					type:"POST",
					url:"/modifyMetri",
					contentType:"application/json",
					data:param,
					success: function(risposta)
					{
						console.log(risposta);
						alert("Metri Modificati");
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