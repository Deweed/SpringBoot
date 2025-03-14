API de Produtos - Java com Spring Boot
Este projeto demonstra o desenvolvimento de uma API REST simples em Java utilizando o framework Spring Boot. O objetivo é criar uma API sem banco de dados que disponibilize funcionalidades completas para manipulação de produtos.

Objetivo
Criar uma API completa sem banco de dados com as seguintes funcionalidades:

Listar produtos: Retorna todos os produtos cadastrados (método GET).

Buscar produto por ID: Retorna um produto específico com base no ID (método GET).

Adicionar produto: Insere um novo produto na lista (método POST).

Atualizar produto: Atualiza os dados de um produto existente (método PUT).

Remover produto: Exclui um produto da lista (método DELETE).

Tecnologias Utilizadas
Java 17+: Linguagem de programação principal.

Spring Boot 3.x: Framework para desenvolvimento rápido e simplificado de aplicações.

Maven: Gerenciador de dependências.

Postman (ou similar): Para testar a API.

Estrutura do Código
Controller (ProductController)
Responsável por expor os endpoints da API para manipulação dos produtos, como listar todos, adicionar e buscar por ID.

Exemplo de Endpoint:

GET /api/products: Retorna todos os produtos cadastrados.

Model (Product)
Classe que representa o produto, contendo atributos como:

id (long): Identificador único do produto.

name (String): Nome do produto.

Service (ProductService)
Camada de lógica de negócios que gerencia a lista de produtos em memória. Inclui métodos para adicionar, buscar, atualizar e remover produtos.

Fluxo dos Dados
Cadastro de Produtos: Produtos são mantidos em uma lista ArrayList em memória.

ID Automático: IDs únicos são gerados automaticamente na inserção de novos produtos.

Como Rodar o Projeto
Pré-requisitos:

Instale o JDK 17+.

Instale o Maven.

Configure uma IDE como o IntelliJ IDEA ou o VS Code.

Clonar o Repositório:

bash
git clone https://github.com/seu-usuario/seu-repositorio.git
Navegar até a Pasta do Projeto:

bash
cd nome-do-projeto
Rodar o Projeto:

Execute o comando Maven:

bash
mvn spring-boot:run
Ou execute diretamente a classe principal pela IDE.

Testar os Endpoints: Use o Postman, cURL ou outro cliente HTTP para chamar os endpoints, como:

GET http://localhost:8080/api/products - Lista todos os produtos.

POST http://localhost:8080/api/products - Adiciona um novo produto.

Exemplo de JSON para Adicionar Produto
json
{
  "name": "Produto Exemplo"
}
Contribuição
Contribuições são bem-vindas! Para contribuir:

Faça um fork do repositório.

Crie uma nova branch.

Envie suas alterações via pull request.

Licença
Este projeto é apenas para fins educacionais.
