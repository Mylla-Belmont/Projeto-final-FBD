select P.nome, força from attacks, Characters P where tipo = 0 and personagem = P.id and P.nome = 'naruto'

UPDATE Characters SET nome = 'Hinata' WHERE id = 6;

select * from attacks

create table Characters(
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

create table Jogador(
	idJogador serial not null,
	nickname varchar(20),
	vitorias integer,
	derrotas integer,
	pontuação integer,

	CONSTRAINT idJogador_pkey PRIMARY KEY(idJogador)
);

INSERT into Characters(id, nome, vida, chakra, agilidade, especial) 
values (DEFAULT, 'Bribinha', 100, 100, 50, 10)

DELETE from Characters where id = 8

alter table jogador rename idjogador to id

SELECT * from jogador

alter table Characters RENAME nomeespecial to attack1

alter table Characters add column attack3 varchar(30)

alter table Characters drop COLUMN força3

alter table Characters add column força3 integer

insert into Characters (attack1, attack2, attack3) values ()

create table attacks(
    personagem serial not null,
    id integer,
    nome varchar(30),
    força integer,

    CONSTRAINT id_pkey PRIMARY key (id),
    CONSTRAINT Characters_fkey FOREIGN key (personagem) REFERENCES Characters(id)
)

SELECT * from attacks

SELECT id from Characters where nome = 'Saruka'


insert into attacks (personagem, id, nome, força) values (1, 1, 'Jutsu saxy', 10)
insert into attacks (personagem, id, nome, força) values (1, 2, 'Jutsu Multiclone das sombras', 20)
insert into attacks (personagem, id, nome, força) values (1, 3, 'Rasengan', 30)

insert into attacks (personagem, nome, força, tipo) values (2, 'Soco', 10, 0)
insert into attacks (personagem, nome, força, tipo) values (2, 'Soco forte', 20, 1)
insert into attacks (personagem, nome, força, tipo) values (2, 'Soco mais forte', 30, 2)

select A.forçafrom attacks A, Characters P where A.tipo = 2 and A.personagem = P.id and P.nome = 'Sakura'

update attacks set tipo = 2 where nome = 'Rasengan'

select A.força from attacks A, Characters P where A.tipo = 0 and A.personagem = P.id and P.nome = 'Naruto'

select * from jogador 

SELECT P.nome, P.agilidade, P.especial, A.nome from Characters P, attacks A where P.id = A.personagem

DELETE FROM Characters where id = 17

insert into jogador (id, nickname, vitorias, derrotas, pontuação) values (default, 'Bribinha', 0, 0, 0)

SELECT nickname from jogador where id = 1