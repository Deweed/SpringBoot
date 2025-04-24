# 💻 Projeto Spring Boot - Relacionamento entre Entidades

Este projeto foi desenvolvido como parte de uma atividade avaliativa. Ele consiste na criação de uma aplicação Spring Boot com duas entidades relacionadas (ex: `Produto` e `Categoria` ou `Aluno` e `Curso`), com funcionalidades completas de CRUD e integração com banco de dados MySQL utilizando o XAMPP.

---

## 🛠️ Tecnologias Utilizadas

- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Spring Boot 3.4.5](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Lombok](https://projectlombok.org/)
- [MySQL](https://www.mysql.com/) (via XAMPP)
- [Postman](https://www.postman.com/) (para testes de API)
- [Visual Studio Code](https://code.visualstudio.com/) (como IDE)

---

## 📁 Estrutura do Projeto

```bash
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.exemplo.api/
│   │   │       ├── controller/
│   │   │       ├── model/
│   │   │       ├── repository/
│   │   │       └── ApiApplication.java
│   │   └── resources/
│   │       ├── application.yml
│   │       └── ...
└── pom.xml
```
## ⚙️ Configuração do Ambiente

1. Instalar o XAMPP
- Baixe e instale o XAMPP.
- Inicie o módulo MySQL no painel de controle do XAMPP.

2. Criar banco de dados
Acesse o `phpMyAdmin` e crie um banco com o nome:

```
CREATE DATABASE sistema_relacional;
```

## 🧩 Entidades

O projeto utiliza duas entidades com relacionamento `@OneToMany` ou `@ManyToMany`. Exemplo:

- [x] `Produto` (id, nome, preco, descricao)
- [x] `Categoria` (id, nome)

## 🔗 Relacionamento

Exemplo: Uma `Categoria` pode conter `muitos Produtos`.

Configurado com anotações JPA (`@OneToMany`, `@ManyToOne`), com mapeamento de chaves estrangeiras automático pelo Hibernate.

## 🧪 Testes com Postman

Após iniciar a aplicação, use o Postman para testar os endpoints:


| Método | Endpoint       | Descrição           |
|--------|----------------|---------------------|
| GET    | /produtos      | Listar produtos     |
| POST   | /produtos      | Cadastrar produto   |
| PUT    | /produtos/{id} | Atualizar produto   |
| DELETE | /produtos/{id} | Remover produto     |


## ▶️ Como Executar o Projeto

1. Clone o repositório:
```
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```
2. Abra no VS Code e execute:
Certifique-se de que o MySQL do XAMPP esteja rodando, e depois:

```
./mvnw spring-boot:run
```

## 🧾 Exemplo de application.yml
```
yaml

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/sistema_relacional?useSSL=false&serverTimezone=UTC
    username: root
    password:
    driver-class-name: com.mysql.cj.jdbc.Driver

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQL8Dialect
```

## ✅ Requisitos Atendidos

- [x] Relacionamento funcional no MySQL
- [x] CRUD completo para ambas as entidades
- [x] Lombok utilizado em todas as classes
- [x] Testes com Postman
- [x] Organização em camadas (Controller, Repository, Model)


## 📝 Conclusão

O projeto foi estruturado seguindo boas práticas de desenvolvimento Spring Boot e padrão REST. O uso do Lombok garantiu código mais limpo e enxuto, e a integração com o MySQL via XAMPP proporcionou um ambiente completo e de fácil replicação para avaliação e testes.

# 👤 Autor
Gabriel Eugênio
