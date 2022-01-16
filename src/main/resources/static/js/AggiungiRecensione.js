window.addEventListener("load" , function(){
	aggiungiEventi2();
});

function aggiungiEventi2()
{
	var btnAggiungi = document.querySelector("#btnInserisciRecensione");
	btnAggiungi.addEventListener("click" , function(){
		var selectedCheckBoxes = document.querySelectorAll("input:checked");
		
		if(selectedCheckBoxes.length > 0)
		{
			var r = document.getElementById("recensione");
			selectedCheckBoxes.forEach(function(checkbox , indice){
				var chiave = checkbox.getAttribute("id");
				var recensione = r.value;
				var param = {chiave , recensione};
				console.log(param);

				$.ajax({
					type:"POST",
					url:"/addRecensione",
   					contentType: "application/json",
					data: param,
					success: function(risposta)
					{
						console.log(risposta);
						alert("Recensione Aggiunta");
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