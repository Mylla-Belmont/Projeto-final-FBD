select P.nome, força from ataques, personagens P where tipo = 0 and personagem = P.id and P.nome = 'naruto'

UPDATE personagens SET nome = 'Hinata' WHERE id = 6;

select * from ataques

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

INSERT into personagens(id, nome, vida, chakra, agilidade, especial) 
values (DEFAULT, 'Bribinha', 100, 100, 50, 10)

DELETE from personagens where id = 8



SELECT * from personagens

alter table personagens RENAME nomeespecial to ataque1

alter table personagens add column ataque3 varchar(30)

alter table personagens drop COLUMN força3

alter table personagens add column força3 integer

insert into personagens (ataque1, ataque2, ataque3) values ()

create table ataques(
    personagem serial not null,
    id integer,
    nome varchar(30),
    força integer,

    CONSTRAINT id_pkey PRIMARY key (id),
    CONSTRAINT personagens_fkey FOREIGN key (personagem) REFERENCES personagens(id)
)

SELECT * from personagens

SELECT id from personagens where nome = 'Saruka'


insert into ataques (personagem, id, nome, força) values (1, 1, 'Jutsu saxy', 10)
insert into ataques (personagem, id, nome, força) values (1, 2, 'Jutsu Multiclone das sombras', 20)
insert into ataques (personagem, id, nome, força) values (1, 3, 'Rasengan', 30)

insert into ataques (personagem, nome, força, tipo) values (2, 'Soco', 10, 0)
insert into ataques (personagem, nome, força, tipo) values (2, 'Soco forte', 20, 1)
insert into ataques (personagem, nome, força, tipo) values (2, 'Soco mais forte', 30, 2)

select A.forçafrom ataques A, personagens P where A.tipo = 2 and A.personagem = P.id and P.nome = 'Sakura'

update ataques set tipo = 2 where nome = 'Rasengan'

select A.força from ataques A, personagens P where A.tipo = 0 and A.personagem = P.id and P.nome = 'Naruto'

select coisa coisa 

SELECT P.nome, P.agilidade, P.especial, A.nome from personagens P, ataques A where P.id = A.personagem

DELETE FROM personagens where id = 17