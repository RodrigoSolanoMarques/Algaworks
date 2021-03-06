var Estado = (function(){

	function Estado(){
		this.comboEstado = $('#combo-estado');
		this.emitter = $({});
		this.on = this.emitter.on.bind(this.emitter);
	}


	Estado.prototype.iniciar = 	function iniciar(){
		$.ajax({
			url: 'http://localhost:8080/estados',
			method: 'GET',
			dataType: 'jsonp',
			success: onEstadosRetornados.bind(this),
			error: onError
		});

		this.comboEstado.on('change', onEstadoAlterado.bind(this));
	}

	function onEstadoAlterado(){

		this.emitter.trigger('alterado', this.comboEstado.val());	
	}

	function onEstadosRetornados(estados){
		this.comboEstado.html('<option value=""> Selecione o estado');
		estados.forEach(function(estado){
			var optionEstado = $('<option>').val(estado.uf).text(estado.nome);

			this.comboEstado.append(optionEstado);

			console.log();
		}.bind(this));
	}

	function onError(){
		alert('Erro carregando estados do servidor!');
	}

	return Estado;
})();

var Cidade = (function(){

	function Cidade(estado){
		this.comboCidade = $('#combo-cidade');
		this.estado = estado;
	}

	Cidade.prototype.iniciar = function(){
		this.estado.on('alterado', onEstadoSelecionado.bind(this));
	}

	function onEstadoSelecionado(event, uf){

		if(uf){
			$.ajax({
				url: 'http://localhost:8080/cidades',
				method: 'GET',
				dataType: 'jsonp',
				success: onCidadesRetornados.bind(this),
				error: onError,
				data:{
					uf: uf
				}
			});
		}else{
			
			reset.call(this);
		}	
	}

	function reset(){		
		this.comboCidade.html('');
		this.comboCidade.attr('disabled', 'disabled');
	}

	function onCidadesRetornados(cidades){
		this.comboCidade.removeAttr('disabled');
		this.comboCidade.html('<option> Selecione uma cidade</option>')
		cidades.forEach(function(cidade){
			var optionCidade = $('<option>').val(cidade.codigo).text(cidade.nome);
			this.comboCidade.append(optionCidade);
		}.bind(this));
	}

	function onError(){
		alert('Erro carregando cidades do servidor!');
	}

	return Cidade;
})();

$(function(){
	var estado = new Estado();
	estado.iniciar();

	var cidade = new Cidade(estado);
	cidade.iniciar();
});

