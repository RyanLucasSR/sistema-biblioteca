# 📚 Sistema de Biblioteca em Java

Sistema de gerenciamento de biblioteca desenvolvido em **Java**, utilizando 
**JDBC** e **MySQL**, com foco na prática de Programação Orientada a Objetos, 
SQL e arquitetura em camadas.

## 🚀 Funcionalidades

- 📖 Cadastro de livros
- 📋 Listagem de livros
- 🔎 Pesquisa de livros por título
- 🔍 Consulta de livro por ID
- ✏️ Atualização de livros
- ❌ Remoção de livros
- 📚 Empréstimo de livros
- 🔄 Devolução de livros
- 🧾 Menu interativo via console

## 🛠️ Tecnologias Utilizadas

- Java
- JDBC
- MySQL
- MySQL Workbench
- IntelliJ IDEA
- Git & GitHub

## 🧠 Conceitos Aplicados

- Programação Orientada a Objetos (POO)
- JDBC
- SQL (CRUD)
- PreparedStatement
- Tratamento de exceções
- Arquitetura em camadas (DAO, Service, Model e View)
- Encapsulamento
- Collections (List e ArrayList)
- Separação de responsabilidades

## 📂 Estrutura do Projeto

```text
src/
│
├── dao/
│   ├── FabricaDeConexao.java
│   └── LivroDAO.java
│
├── exception/
│   ├── LivroException.java
│   └── VazioException.java
│
├── model/
│   └── Livro.java
│
├── service/
│   └── RegrasBiblioteca.java
│
├── view/
│   ├── BibliotecaConsole.java
│   └── Menu.java
│
├── Aplicacao.java
├── biblioteca.properties.example
```

## ▶️ Como Executar

1. Clone o repositório:

```bash
git clone https://github.com/RyanLucasSR/sistema-biblioteca.git
```

2. Configure um banco MySQL.

3. Crie um arquivo `biblioteca.properties` baseado no arquivo `biblioteca.properties.example`.

4. Abra o projeto no IntelliJ IDEA.

5. Adicione o MySQL Connector/J ao projeto.

6. Execute a classe `Aplicacao.java`.

## 🎯 Objetivo

Este projeto foi desenvolvido com o objetivo de praticar:

- Java
- JDBC
- SQL
- MySQL
- Arquitetura em camadas
- Manipulação de banco de dados utilizando DAO

## 📌 Autor

Desenvolvido por **Ryan Lucas**