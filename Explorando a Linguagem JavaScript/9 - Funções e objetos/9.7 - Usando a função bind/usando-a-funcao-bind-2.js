
var Estado = (function(){

	function Estado(){
		this.comboEstado = $('#combo-estado');
	}

	Estado.prototype.iniciar = function iniciar(){
		$.ajax({
			url: 'http://localhost:8080/estados',
			method: 'GET',
			dataType: 'jsonp',
			success: onEstadosRetornados.bind(this),
			error: onError
		});
	}

	function onEstadosRetornados(estados){
		this.comboEstado.html('<option> Selecione o estado');
		estados.forEach(function(estado){
			
			var optionEstado = $('<option>').val(estado.uf).text(estado.nome);
			this.comboEstado.append(optionEstado);
		}.bind(this));
	}

	function onError(){
		alert('Erro carregando estados do servidor!');
	}

	return Estado;


})();

$(function(){

	var estado = new Estado();
	estado.iniciar();

});