var criarCarroVolks = function(nome, placa){
	return{
		nome: nome,
		placa: placa,
		fabricante: 'VW'
	};
}

var fox = criarCarroVolks('Fox', 'AAA-1111');
console.log('fox',fox);

var gol = criarCarroVolks('Gol', 'AAA-2222');
console.log('gol',gol);