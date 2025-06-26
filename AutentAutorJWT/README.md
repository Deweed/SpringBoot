<h1>AutentAutorJWT - API de Segurança com Spring Boot e JWT</h1>

Este repositório contém uma implementação robusta de um sistema de autenticação e autorização para APIs REST, construído com o ecossistema Spring Boot. O projeto utiliza JSON Web Tokens (JWT) para garantir o controle de acesso seguro aos endpoints.

A arquitetura foi projetada para ser um ponto de partida claro e funcional para aplicações que necessitam de um módulo de segurança, incluindo um banco de dados em memória para testes e documentação interativa da API.

<h2>🛠️ Tecnologias Utilizadas</h2>
Este projeto é desenvolvido com um conjunto de tecnologias modernas e eficientes:

- Linguagem: Java 17+
- Framework: Spring Boot 3
- Segurança: Spring Security 6
- Tokens: JSON Web Token (JWT)
- Banco de Dados: H2 Database (em memória)
- Documentação: Springdoc OpenAPI (Swagger UI)
- Build Tool: Maven

<h2>▶️ Como Começar</h2>
Siga os passos abaixo para clonar e executar a aplicação em seu ambiente local.

1. Clonagem do Repositório
Primeiro, clone o repositório `SpringBoot` e navegue até o diretório do projeto `AutentAutorJWT`.
```
Bash

git clone https://github.com/Deweed/SpringBoot.git
cd SpringBoot/AutentAutorJWT
```
2. Execução da Aplicação
Você pode iniciar o servidor de duas maneiras. Certifique-se de que o Java 17 (ou superior) e o Maven estejam instalados e configurados em seu sistema.

Opção A: Usando o Maven Wrapper (Recomendado)

Este método utiliza o Maven encapsulado no próprio projeto, dispensando uma instalação global.

```
Bash

# Para Linux/macOS
./mvnw spring-boot:run

# Para Windows
mvnw.cmd spring-boot:run
```
Opção B: Compilando o Projeto Manualmente

Compile o código-fonte em um pacote JAR e execute-o.
```
Bash

# 1. Compila e empacota
mvn clean package

# 2. Executa o JAR gerado
java -jar target/AutentAutorJWT-0.0.1-SNAPSHOT.jar
```
Após a inicialização, a API estará disponível em `http://localhost:8080`.

<h2>🔑 Processo de Autenticação</h2>
O acesso aos recursos protegidos da API é gerenciado por tokens JWT.

Obtenha um Token: Envie uma requisição `POST` para `/auth/login` contendo as credenciais de usuário (`login` e `password`) no corpo da requisição.

Receba as Chaves: Se as credenciais estiverem corretas, a API retornará um token JWT.

Acesse Recursos: Para chamar endpoints protegidos, inclua este token no cabeçalho `Authorization` de suas requisições, prefixado por `Bearer` .

Exemplo de cabeçalho: `Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...`

<h2>📖 Explorando a API (Swagger)</h2>
Toda a API está documentada e pode ser testada interativamente através da interface do Swagger UI, fornecida pelo Springdoc.

Acesse a documentação em seu navegador:

🔗 `http://localhost:8080/swagger-ui/index.html`

Lá, você poderá visualizar todos os endpoints, seus parâmetros e testar o fluxo de autenticação e as chamadas protegidas diretamente.

<h2>🗄️ Consultando o Banco de Dados (H2)</h2>
Para facilitar o desenvolvimento, o projeto utiliza um banco de dados H2 que roda em memória. Você pode acessá-lo através de um console web para verificar dados de usuários e outras tabelas.

- URL do Console: `http://localhost:8080/h2-console`
- Configurações de Conexão:
- Driver Class: `org.h2.Driver`
- JDBC URL: `jdbc:h2:mem:testdb`
- User Name: `sa`
- Password: deixe este campo em branco

<h2>✅ Pré-requisitos</h2>

Java Development Kit (JDK): Versão 17 ou mais recente.
Apache Maven: Versão 3.8 ou superior.
Um cliente de API (como Postman ou Insomnia) ou o próprio Swagger UI para testar os endpoints.
