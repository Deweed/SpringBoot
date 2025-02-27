# PrimeiroProjeto

Este é um simples projeto Spring Boot que expõe uma API REST.

## Estrutura do Projeto

A estrutura do projeto é a seguinte:

## Como Executar a Aplicação

Siga os passos abaixo para executar a aplicação:

1. **Pré-requisitos:**
   - Certifique-se de ter o [JDK 11+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) instalado.
   - [Maven](https://maven.apache.org/) instalado e configurado no seu `PATH`.

2. **Clone o repositório:**
```
   bash
   git clone <url-do-repositorio>
   cd primeiroprj
```
4. **Compile e empacote a aplicação usando Maven:**
```
bash
mvn clean package
```
4. **Execute a aplicação:**
```
bash
mvn spring-boot:run
```
5. **Acesse a API:**
Abra seu navegador e vá para http://localhost:8080/main/hello para ver a mensagem de saudação. 
Você também pode passar um parâmetro name para personalizar a saudação, por exemplo: http://localhost:8080/main/hello?name=João.

**Endpoints da API**
A aplicação possui os seguintes endpoints:

GET /main/hello: Retorna uma mensagem de saudação. Você pode personalizar a mensagem passando o parâmetro name.

Exemplo:
```
bash
curl -X GET "http://localhost:8080/main/hello?name=João"
```
