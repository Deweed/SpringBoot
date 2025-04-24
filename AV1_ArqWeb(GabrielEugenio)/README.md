# [<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" alt="spring" width="25"/>](https://spring.io/projects/spring-boot) Sistema Acadêmico - API Spring Boot
Desenvolvida com Java 24 e utilizando o framework Spring Boot no back-end, esta aplicação representa uma estrutura acadêmica com foco nos relacionamentos entre alunos e cursos. A API permite o cadastro de cursos e alunos, além de possibilitar a associação de alunos aos respectivos cursos, simulando um cenário real de gerenciamento educacional.

<br>

## 🛠 Tecnologias usadas
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" alt="java" width="35"/> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" alt="spring" width="35"/> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg" alt="mariadb" width="35"/> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/maven/maven-original.svg" alt="maven" width="35"/>

<br>

## ✅ Requisitos para executar
- Java 24
- Maven 3.6+
- MariaDB 10.4+ (ou MySQL equivalente)
- IDE (ex: IntelliJ, VSCode ou Eclipse)
- Extensões VSCode: SpringBoot Extension Pack, Java Extension Pack

<br>

## 📂 Estrutura do Projeto
- `controllers/`: Contém os endpoints da API.
- `model/`: Entidades JPA (Aluno, Curso).
- `repository/`: Interfaces para acesso ao banco de dados.
- `services/`: Lógica de negócio da aplicação.
- `application.yml`: Configurações do banco de dados e JPA.

<br>

## ![MariaDB](https://img.shields.io/badge/MariaDB-003545?style=for-the-badge&logo=mariadb&logoColor=white) Configuração do MariaDB
1. **Instalar o XAMPP [<img src="https://www.apachefriends.org/images/xampp-logo-ac950edf.svg" alt="xampp" width="15"/>](https://www.apachefriends.org/)**  
   Faça o download XAMPP (pacote de softwares) [aqui](https://www.apachefriends.org/pt_br/download.html) e instale-o.

2. **Configurar o `application.yml`**  
Abra o arquivo `application.yml` e insira as configurações de conexão com o banco MariaDB.

3. **Iniciar o XAMPP**  
   Execute o XAMPP e clique em "Start" em MySQL para executar o servidor de banco de dados locamente

4. **Criar o banco de dados no phpMyAdmin** 
   Após startar o MySQL, o phpMyAdmin será aberto numa aba do navegador. Crie um banco de dados com o nome "apiav1_sistemaacademico", conforme o application.yml.
   
6. **Rodar a aplicação**  
   Utilizando a extensão "Spring Boot Dashboard", clique no botão de Run, para startar a API em localhost:8080

6. **Utilizar Postman ou Bruno**  
   Instale a extensão do Postman no VSCode para fazer requisições à API. Confira no phpMyAdmin se os cadastros estão sendo realizados.

<br>

## 🚀 Endpoints disponíveis
* GET /alunos – Lista todos os alunos
* POST /alunos – Cadastra um novo aluno
* GET /cursos – Lista todos os cursos
* POST /cursos – Cadastra um novo curso

<br>
