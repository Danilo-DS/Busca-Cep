//Quando o botão é clicado faz a verificação do input "CampoCep".
$('#buscar').click(function(){
	let cep = document.getElementById("CampoCep");
	if (!isNaN(cep.value) && cep.value != null && cep.value != ""){
		buscaCep(cep);
	}
	else{
		cep.value = "";
		alertaUser("Preencha o Campo Corretamente!");
	}	
});

//Carrega o cep do encontrado e passa para o metodo "montaTabela" para exibir no HTML.
function carregarCeps(){
	$(document).ready(function(){
		$.get("index/buscaCep", function(data){
			if(typeof(data) != undefined && !data == ""){
				montaTabela(data);
			}
		});
	});
};

/* Monta a tabela em html */	
const montaTabela = (item) =>{
		$('#table-view').append(
		`<tbody>
			    <tr id="lineTable">
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
	$('#error').text(msg);			
	$( "#alertError" ).fadeIn(1100,0).delay( 1500 ).slideUp(1100); //Exibe o alert por 1,5s e depois some.
}

//Consulta o Cep no Servidor e exibe, caso contrario "Cep Não Encontrado"
function buscaCep(cep){	
	$.get("index/buscaCep/" + cep.value.trim(), function(resp){ //busca o Cep 
			cep.value = "";
			$('#lineTable').remove();
			montaTabela(resp)
			console.log(resp)
			
	}).fail(function(error){
		cep.value = "";
		alertaUser(error.responseText);
		console.log(error.status);
		});
};
carregarCeps();