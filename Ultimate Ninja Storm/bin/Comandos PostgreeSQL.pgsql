select P.nome, força from ataques, personagens P where tipo = 0 and personagem = P.id and P.nome = 'naruto'

UPDATE personagens SET nome = 'Hinata' WHERE id = 6;

select * from personagens

create table personagens(
	id serial not null,
	nome varchar(15),
	vida integer not null,
	chakra integer not null,
	especial integer not null,
	agilidade integer not null,
	especial1 varchar(30),
	especial2 varchar(30),
	especial3 varchar(30),
	
	constraint id_pk primary key(id)
);

