# 📚 API de Cadastro de Usuários

Este projeto é uma **API REST** desenvolvida em **Spring Boot** para o gerenciamento completo de usuários, oferecendo operações de **CRUD** (Criar, Ler, Atualizar e Deletar). A API também inclui **testes unitários** robustos, implementados com **JUnit** e **Mockito**, garantindo a confiabilidade e a qualidade do código.

---

## 🚀 Tecnologias Essenciais

* **Java 17+**: Linguagem de programação principal.
* **Spring Boot**: Framework para o desenvolvimento rápido de aplicações Java.
* **Spring Data JPA**: Simplifica o acesso a dados com JPA.
* **Lombok**: Reduz a verbosidade do código Java.
* **H2 Database**: Banco de dados relacional em memória para desenvolvimento e testes.
* **JUnit 5**: Framework para escrita de testes unitários.
* **Mockito**: Biblioteca para criação de objetos mock para testes.
* **Maven**: Ferramenta de gerenciamento de projetos e dependências.

---

## 📂 Estrutura do Projeto

A estrutura do projeto está organizada para facilitar a navegação e o desenvolvimento:

```bash
src
└── main
    ├── java
    │   └── com.cadastro.usuario
    │       ├── controllers           # Lógica de manipulação de requisições HTTP
    │       ├── models                # Classes de modelo de dados (entidades)
    │       ├── repositories          # Interfaces para acesso a dados
    │       ├── services              # Lógica de negócio da aplicação
    │       └── UsuarioApplication.java # Classe principal da aplicação
└── test
    └── java
        └── com.cadastro.usuario
            ├── UsuarioApplicationTests.java  # Testes de integração da aplicação
            └── UsuarioTest.java              # Testes unitários dos controladores
```

---

## 🔗 Endpoints da API

A API oferece os seguintes endpoints para gerenciamento de usuários:

| Método | Endpoint         | Ação                                |
| :----- | :--------------- | :---------------------------------- |
| `GET`  | `/usuarios`      | Retorna todos os usuários cadastrados. |
| `GET`  | `/usuarios/{id}` | Retorna um usuário específico pelo ID. |
| `POST` | `/usuarios`      | Cria um novo usuário.               |
| `PUT`  | `/usuarios/{id}` | Atualiza os dados de um usuário existente. |
| `DELETE` | `/usuarios/{id}` | Deleta um usuário pelo ID.          |
| `GET`  | `/usuarios/somar`| **Endpoint de teste**: Soma dois números. |

---

## 🗄️ Configuração do Banco de Dados

Por padrão, o projeto utiliza o **H2 Database**, um banco de dados em memória ideal para desenvolvimento e testes. Para acessar o console do H2, utilize as seguintes credenciais:

* **JDBC URL**: `jdbc:h2:mem:testdb`
* **Username**: `sa`
* **Password**: (deixe em branco)

---

## ✅ Funcionalidades Principais

Esta API oferece as seguintes funcionalidades:

* **Cadastro de usuários**: Permite a criação de novos registros de usuários.
* **Listagem de usuários**: Recupera a lista completa de usuários.
* **Atualização de dados**: Possibilita a modificação das informações de usuários existentes.
* **Exclusão de usuários**: Remove registros de usuários do sistema.
* **Testes unitários**: Cobertura abrangente de testes com JUnit e Mockito para garantir a qualidade do código.
* **Endpoint adicional para soma de números**: Incluído para fins de demonstração e testes.
