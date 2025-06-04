# 📚 API de Cadastro de Usuários

Este projeto é uma API REST desenvolvida em Spring Boot para gerenciamento de usuários, permitindo operações de CRUD (Criar, Ler, Atualizar e Deletar). O projeto também conta com testes unitários utilizando JUnit e Mockito.

---

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Lombok
- H2 Database (ou outro banco relacional)
- JUnit 5
- Mockito
- Maven

---

📂 Estrutura do Projeto
```bash
 src
 └── main
     ├── java
         ├── com.cadastro.usuario
             ├── controllers
             ├── models
             ├── repositories     
             ├── services  
             └── UsuarioApplication.java
       
└── test
    └── java
        └── com.cadastro.usuario
            ├── UsuarioApplicationTests.java
            └── UsuarioTest.java // Testes unitários do controller
```

---

## 🔗 Endpoints da API

| Método	|    Endpoint    |	       Ação                 |
|---------|----------------|------------------------------|
| GET	    |  /usuarios	   |Retorna todos os usuários     |
| GET	    | /usuarios/{id} |Retorna um usuário por ID     |
| POST	  | /usuarios	     | Cria um novo usuário         |
| PUT	    | /usuarios/{id} | Atualiza um usuário existente| 
| DELETE	| /usuarios/{id} | Deleta um usuário por ID     |
| GET	    | /usuarios/somar| 	Soma dois números (teste)   |

---

## 🗄️ Banco de Dados

Por padrão, o projeto utiliza H2 Database, que roda em memória durante a execução. Para acessar o console do H2:

- JDBC URL: jdbc:h2:mem:testdb
- Username: sa
- Password: (em branco)

---

## ✅ Funcionalidades
✔️ Cadastro de usuários

✔️ Listagem de usuários

✔️ Atualização de dados

✔️ Exclusão de usuários

✔️ Testes unitários com JUnit e Mockito

✔️ Endpoint adicional para soma de números (para testes)

