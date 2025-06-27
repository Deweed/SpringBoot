# AV2 - API de Autenticação e Autorização JWT

>Este projeto foi desenvolvido para a avaliação **AV2**, com foco na construção de uma API RESTful robusta utilizando **Spring Boot 3**. A aplicação implementa um sistema completo de segurança com autenticação e autorização baseadas em **JSON Web Tokens (JWT)**, além de incluir funcionalidades de documentação, testes, monitoramento e deploy em nuvem.

## ✨ Funcionalidades Principais

  - **Segurança:** Autenticação via JWT e autorização por papéis (`roles`) utilizando `Spring Security` e `OAuth2 Resource Server`.
  - **API de Autenticação:** Endpoints para registro (`/auth/register`) e login (`/auth/login`) de usuários.
  - **Operações CRUD:** Endpoints para gerenciamento de usuários, protegidos conforme o nível de acesso.
  - **Documentação:** Documentação interativa da API gerada automaticamente com `Swagger UI` via `Springdoc OpenAPI`.
  - **Testes:** Cobertura de testes unitários com `JUnit 5 / Mockito` e um plano de testes de carga com `JMeter`.
  - **Monitoramento:** Métricas de saúde e performance expostas via `Spring Boot Actuator` e prontas para serem coletadas pelo `Prometheus`.
  - **Deploy:** Suporte para containerização com `Docker` e deploy na plataforma `Render`.

## 📦 Stack Tecnológica (Dependências da Prova)

  - 🌐 **`Spring Boot Starter Web`**
  - 🔒 **`Spring Boot Starter Security`**
  - 🔑 **`Spring Boot Starter OAuth2 Resource Server`**
  - 🗄️ **`Spring Boot Starter Data JPA`**
  - 💾 **`H2 Database`**
  - 📚 **`Springdoc OpenAPI (springdoc-openapi-starter-webmvc-ui)`**
  - 🛠️ **`Spring Boot DevTools`**
  - 🍬 **`Lombok`**
  - ✅ **`Spring Boot Starter Test`**
  - 🩺 **`Spring Boot Actuator`**
  - 📊 **`Prometheus (micrometer-registry-prometheus)`**

-----

## 🚀 Como Executar o Projeto Localmente

### **1. Pré-requisitos**

  - **Java Development Kit (JDK) 17** ou superior.
  - **Apache Maven 3.8** ou superior.

### **2. Clonagem do Repositório**

O projeto está em uma subpasta. Clone o repositório principal e navegue até a pasta correta.

```bash
# 1. Clone o repositório 'SpringBoot'
git clone https://github.com/Deweed/SpringBoot.git

# 2. Navegue até a pasta do projeto da AV2
cd SpringBoot/AV2-AuthnAutJWT
```

### **3. Configuração do Ambiente (`application.yml`)**

Para atender aos requisitos, o projeto deve usar um arquivo `application.yml` em `src/main/resources/`. Certifique-se de que ele contenha as seguintes configurações:

```yaml
server:
  port: 8080

spring:
  h2:
    console:
      enabled: true
      path: /h2-console
  datasource:
    url: jdbc:h2:mem:testdb
    username: sa
    password:
    driverClassName: org.h2.Driver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true

# Configuração da chave secreta para o JWT
api:
  security:
    token:
      secret: ${JWT_SECRET:SUA_CHAVE_SECRETA_PADRAO_PARA_TESTES_LOCAIS}

# Configuração do Swagger
springdoc:
  api-docs:
    path: /v3/api-docs
  swagger-ui:
    path: /swagger-ui.html

# Configuração do Actuator para expor métricas
management:
  endpoints:
    web:
      exposure:
        include: "health,info,prometheus,metrics"
```

> **Nota:** O uso de `${JWT_SECRET:...}` permite que você defina a chave secreta via variáveis de ambiente no deploy, uma prática recomendada.

### **4. Execute a Aplicação**

Dentro da pasta `AV2-AuthnAutJWT`, execute o comando:

```bash
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

-----

## 📖 Documentação com Swagger / OpenAPI

Com a aplicação rodando, acesse a documentação interativa da API, gerada automaticamente pelo Springdoc:

🔗 **`http://localhost:8080/swagger-ui.html`**

Use esta interface para testar os endpoints de login, registro e CRUD diretamente do navegador.

-----

## ✅ Testes

### **Testes Unitários com JUnit 5**

Para rodar os testes unitários implementados no projeto:

```bash
./mvnw test
```

### **📈 Testes de Carga com JMeter**

1.  **Instale o JMeter**: Baixe em [jmeter.apache.org](https://jmeter.apache.org/download_jmeter.cgi).
2.  **Crie um Plano de Teste**: Configure um `Thread Group` e um `HTTP Request` para fazer requisições `POST` no endpoint `http://localhost:8080/login`.
3.  **Analise os Resultados**: Use o `Summary Report` para verificar a performance da API sob carga.

-----

## 🩺 Monitoramento da API (Actuator & Prometheus)

Com a aplicação rodando, os seguintes endpoints de monitoramento estarão disponíveis:

  - **Saúde da Aplicação**: `http://localhost:8080/actuator/health`
  - **Métricas para Prometheus**: `http://localhost:8080/actuator/prometheus`

Essas métricas podem ser coletadas por uma instância local do Prometheus para análise e visualização em dashboards (por exemplo, no Grafana).

-----

## 🚚 Deploy do Projeto na Nuvem (Render)

### **1. Crie o `Dockerfile`**

Na raiz da pasta `AV2-AuthnAutJWT`, crie um arquivo chamado `Dockerfile` com o seguinte conteúdo:

```dockerfile
# Estágio de Build com Maven
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Estágio Final com a Aplicação
FROM openjdk:17-slim
WORKDIR /app
COPY --from=build /app/target/AV2-AuthnAutJWT-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

### **2. Faça o Push para o GitHub**

Adicione o `Dockerfile` e este `README.md` atualizado ao seu repositório.

```bash
git add .
git commit -m "feat: Adiciona Dockerfile e documentação para deploy"
git push
```

### **3. Configure o Deploy no Render**

1.  No seu dashboard do Render, clique em **New + \> Web Service**.
2.  Conecte seu repositório GitHub e selecione `Deweed/SpringBoot`.
3.  Na tela de configuração, preencha os seguintes campos **com atenção**:
      - **Name**: Dê um nome único (ex: `api-av2-deweed`).
      - **Runtime**: Selecione **`Docker`**. O Render usará seu `Dockerfile`.
      - **Root Directory**: **`AV2-AuthnAutJWT`**. (Este passo é crucial\!)
4.  Vá até a seção **Environment** e adicione sua chave secreta:
      - **`Key`**: `JWT_SECRET`
      - **`Value`**: `sua_chave_secreta_super_forte_para_producao`
5.  Clique em **Create Web Service**.

O Render irá construir a imagem Docker e fazer o deploy da sua aplicação.

### 🔗 Link da Aplicação em Produção

**URL da API**: `https://SUA_URL_AQUI.onrender.com`

**(Após o deploy, substitua o link acima pela URL gerada pelo Render).**
