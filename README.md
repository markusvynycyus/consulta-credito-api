# API de Consulta de Créditos NFSe

![Logo](url_da_imagem) <!-- Aqui você pode adicionar um logo ou imagem do projeto, se desejar -->

## Descrição

Este projeto implementa uma API RESTful para a consulta e gestão de créditos NFSe, utilizando o Spring Boot. O sistema permite a busca de créditos por número de NFSe e número de crédito, convertendo os dados para `DTOs` e utilizando o ModelMapper para facilitar o mapeamento entre as entidades e seus representações.

### Funcionalidades

- **Busca de Créditos**:
  - Por número da NFSe.
  - Por número do crédito.
  
- **DTOs**:
  - Conversão dos dados para objetos mais leves para retorno ao cliente.
  
- **Spring Data JPA**:
  - Integração com PostgreSQL para persistência de dados.

- **ModelMapper**:
  - Utilizado para mapear as entidades para DTOs de forma simples e eficiente.

---

## Estrutura do Projeto

O projeto é estruturado da seguinte maneira:

```plaintext
src/
 ├── main/
 │    ├── java/
 │    │    ├── com/
 │    │    │    ├── venicios/
 │    │    │    │    ├── api_credito_nfse/
 │    │    │    │    │    ├── controller/      # Controladores da API
 │    │    │    │    │    ├── dto/             # Objetos de Transferência de Dados (DTO)
 │    │    │    │    │    ├── model/           # Modelos de entidades
 │    │    │    │    │    ├── repository/      # Repositórios para acesso ao banco de dados
 │    │    │    │    │    ├── service/         # Lógica de negócios
 │    │    │    │    │    └── assembler/       # Classes para conversão de dados (ModelMapper)
 └── resources/
      ├── application.properties  # Configurações do banco de dados e JPA
