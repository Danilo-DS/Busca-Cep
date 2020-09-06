function carregarCeps(){
	$(document).ready(function(){
		$.get("index/buscaCep", function(data){ 
			data.forEach(e => montaTabela(e));
		});
	});
};

/* Monta a tabela em html */	
const montaTabela = (item) =>{
	$('#table-view').append(
	`<tbody>
		    <tr>
		      <td>`+item.bairro+`</th>
		      <td>`+item.cep+`</td>
		      <td>`+item.localidade+`</td>
		      <td>`+item.uf+`</td>
		      <td>`+item.logradouro+`</td>
		    </tr>
	</tbody>`		
	);
	
}

function alertaUser(msg){
	document.getElementById("alerta").hidden = false;
	$('#error').text(msg);			
	//$(document).ready(function () {
		window.setTimeout(function() {
		    $('#alerta').fadeTo(2000, 0).slideUp(1700, function(){
		    	$(this).hide();
		    });
		}, 2100);
		setTimeout(function (){
			window.location.reload();
		}, 5300)
		
	//});
}

function buscaCep(){	
	let cep = document.getElementById("CampoCep");
	if (!isNaN(cep.value) && cep.value != null && cep.value != ""){
		$.get("index/buscaCep/" + cep.value.trim(), function(resp){
				if(resp == ""){
					cep.value = "";
					window.location.reload();
				}
				else{
					cep.value = "";
					alertaUser(resp);
				}
			});
	}
	else{
		cep.value = "";
		alertaUser("Preencha o Campo Corretamente!")
	}
};

carregarCeps();	
const buscar = document.getElementById("buscar").addEventListener("click",buscaCep);