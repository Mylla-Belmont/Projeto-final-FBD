# 🌀 Ultimate Ninja Storm – Jogo em Java com Banco de Dados PostgreSQL

**Ultimate Ninja Storm** é um jogo baseado no universo de Naruto, criado como projeto acadêmico para consolidar conhecimentos adquiridos nas disciplinas de **Banco de Dados** e **Programação Orientada a Objetos (POO)**. O projeto reutiliza e aprimora estruturas do meu primeiro jogo em Java, agora incorporando **persistência de dados com PostgreSQL** e maior dinamismo nas funcionalidades.

> ❗️Este projeto **não possui interface gráfica**, pois ainda não foram estudadas bibliotecas visuais ou motores gráficos. Toda a interação ocorre via terminal/console.

---

## 🧠 Objetivos do Projeto

- Aplicar o modelo de dados relacional na prática com Java
- Utilizar conceitos de CRUD e conexão com banco via JDBC
- Trabalhar classes, herança, encapsulamento e modularização
- Implementar lógica de jogo com sistema de batalha, ranking e gerenciamento de dados persistentes

---

## 🛠️ Tecnologias e Ferramentas

- Java 8+
- PostgreSQL
- JDBC
- IDE: VsCode

---

## 🧩 Estrutura do Código

O código está organizado em classes que simulam funcionalidades do jogo. Abaixo, uma visão geral:

| Classe | Função |
|--------|--------|
| `AdversarySystem` | Controla os movimentos automáticos do personagem adversário |
| `Appearance` | Método auxiliar para limpar o terminal |
| `BankAccess` | Métodos de acesso ao banco (CRUD) |
| `Battle` | Controla os movimentos do jogador e o fluxo da batalha |
| `Characters` | Armazena atributos e métodos dos personagens |
| `CommandsPGSQL` | Contém os scripts SQL e configurações |
| `ConnectionPGSQL` | Estabelece e encerra a conexão com o banco |
| `DuelMode` | Controla o modo de duelo entre personagens |
| `LoadScreen` | Tela de carregamento de jogos salvos |
| `Menu` | Menu principal do jogo |
| `Ranking` | Exibe o ranking entre jogadores com base nas vitórias |
| `Settings` | Permite alterações manuais no banco (administração) |

---

## 🎮 Funcionalidades do Jogo

### 📥 Novo Jogo
- Insere um novo jogador na tabela `jogador`, solicitando apenas o nickname.

### 💾 Carregar Jogo
- Recupera informações salvas como nome, vitórias e derrotas do jogador.

### ⚔️ Modo Duelo
- O jogador escolhe personagens ou deixa o jogo selecionar aleatoriamente.
- Durante a batalha, o jogador pode:
  - Atacar (consulta à tabela `ataques`)
  - Usar especial (consulta à tabela `personagens`)
  - Recuperar vida
  - Recuperar chakra (estamina)
  - Desistir da batalha

- O adversário é totalmente automatizado.
- Ao final, a tabela `jogador` é atualizada com vitória ou derrota.

### 🏆 Ranking
- Lista os jogadores em ordem de vitórias registradas.

### ⚙️ Configurações
- Permite acesso administrativo ao banco:
  - Ver personagens cadastrados
  - Adicionar novos personagens (com ataques, especial, agilidade)
  - Remover personagens e seus dados associados

---

## 🗃️ Banco de Dados

O projeto utiliza um modelo relacional com PostgreSQL. As tabelas principais são:

- `jogador`
- `personagens`
- `ataques`

### 📌 Modelo Conceitual (ER)

![Conceitual_1](https://github.com/user-attachments/assets/6d7c0692-0db0-4bfd-91a2-e0dd87746b8c)
