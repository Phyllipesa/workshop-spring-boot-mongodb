# Blog API

Esta é uma API simples para um sistema de blog, construída usando Spring Boot e MongoDB.
A API oferece operações básicas para gerenciar usuários, posts e comentários.


## Requisitos
Certifique-se de ter o Java e o Maven instalados em sua máquina.


## Configuração do Banco de Dados
A aplicação utiliza o MongoDB como banco de dados. Certifique-se de ter um servidor MongoDB
em execução ou atualize as configurações no arquivo application.properties para apontar para o seu servidor MongoDB.

```bash
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=blogdb
```


## Executando a Aplicação

Clone o repositório:
```bash
git@github.com:Phyllipesa/workshop-spring-boot-mongodb.git
```


## Navegue até o diretório do projeto:

```bash
cd blog-api
```


## Execute a aplicação usando Maven:

```bash
mvn spring-boot:run
```

A aplicação será iniciada em 'http://localhost:8080'.


## Tecnologia
Java

## Autores

- [@phyllipesa](https://github.com/phyllipesa) - Desenvolvimento do projeto
- [@acenelio](https://github.com/acenelio) - Commit inicial
