SELECT * FROM brewer.estilo;
delete from brewer.estilo where codigo > 4;
alter table brewer.estilo auto_increment = 5;


SELECT * FROM brewer.cerveja;

delete from brewer.cerveja; 
