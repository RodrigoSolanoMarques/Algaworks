function Carro(nome, placa) {
	this.nome = nome;
	this.placa = placa;
}


//var fox = new Carro('Fox', 'AAA-1111');

var fox = {};
Carro.call(fox, 'Fox', 'AAA-1111');

var gol = {};
Carro.apply(gol, ['Gol', 'AAA-2222']);

console.log('fox', fox);
console.log('gol', gol);