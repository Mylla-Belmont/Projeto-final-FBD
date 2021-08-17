
create table personagens(
    id_personagem serial not null,
    nome varchar(30) not null,
    vida integer not null,
    chakra integer not null,
    agilidade integer not null,
    especial integer not null,

    constraint idPersonagem_pkey primary key(id_personagem)
);

create table ataques(
    id_ataques serial not null,
    personagem integer not null,
    nome varchar(50) not null,
    força integer not null,
    tipo integer not null,

    constraint idAtaque_pkey primary key(id_ataques),
    constraint idAtaque_fkey foreign key(personagem) references personagens(id_personagem)
);

create table jogador(
    id_jogador serial not null,
    nickname varchar(30) not null,
    vitorias integer not null,
    derrotas integer not null,

    constraint idJogador_pkey primary key(id_jogador)
);


select * from personagens
select * from ataques
select * from jogador

/*
drop table personagens
drop table ataques
drop table jogador
*/

insert into personagens(id_personagem, nome, vida, chakra, agilidade, especial) values (default, 'Naruto', 100, 100, 70, 60)
insert into ataques(id_ataques, personagem, nome, força, tipo) values(default, 1, 'Jutsu sexy', 10, 0) 
insert into ataques(id_ataques, personagem, nome, força, tipo) values(default, 1, 'Jutsu multiclone das sombras', 20, 1) 
insert into ataques(id_ataques, personagem, nome, força, tipo) values(default, 1, 'Rasengan', 30, 2) 

insert into personagens(id_personagem, nome, vida, chakra, agilidade, especial) values (default, 'Sakura', 100, 100, 40, 80)
insert into ataques(id_ataques, personagem, nome, força, tipo) values(default, 2, 'soco forte', 10, 0) 
insert into ataques(id_ataques, personagem, nome, força, tipo) values(default, 2, 'soco mais forte', 20, 1) 
insert into ataques(id_ataques, personagem, nome, força, tipo) values(default, 2, 'meteoro de socos', 30, 2)

/*Selects usados no jogo*/
/* "nome das variaveis" */

/* listCharacters------>*/select id_personagem, nome from personagens
/* getCharacters------>*/select nome, vida, chakra, especial, agilidade from personagens where id_personagem = "id"
/* getIdCharacters------>*/select id_personagem from personagens where nome = "nome"
/* getAttack------>*/select A.força from ataques A, personagens P where A.tipo = "tipo" and A.personagem = P.id_personagem and P.nome = "nome"
/* getSpecial------>*/select especial from personagens where nome = "nome"
/* getNameAttack------>*/select A.nome from ataques A, personagens P where A.tipo = "tipo" and A.personagem = P.id_personagem and P.nome = "nome"
/* getAllCharacters------>*/select P.nome, P.agilidade, P.especial from personagens P
/* getPlayers------>*/select id_jogador, nickname from jogador
/* getIdPlayer------>*/select id_jogador from jogador where nickname = "nome"
/* getRanking------>*/select nickname, vitorias from jogador
/* getNamePlayer------>*/select nickname from jogador where id_jogador = "id"

/*Inserts usados no jogo*/

/* addCharacters------>*/insert into personagens(id_personagem ,nome, vida, chakra, agilidade, especial) values(default, "nome",100,100, "agilidade", "especial")
/* addAttack------>*/insert into ataques(id_ataques, personagem, nome, força, tipo) values(default, "id_personagem", "nome", "força", "tipo")
/* addPlayer------>*/insert into jogador (id_jogador, nickname, vitorias, derrotas) values(default, "nome", 0, 0)

/*Updates usados no jogo*/

/* addPlayerWin------>*/update jogador set vitorias = vitorias + 1 where id_jogador = "id"
/* addPlayerDefeat------>*/update jogador set derrotas = derrotas + 1 where id_jogador = "id"

/*Deletes usados no jogo*/

/* deleteCharacters------>*/delete from personagens where id_personagem = "id"
/* deleteCharacters------>*/delete from ataques where personagem = "id"

