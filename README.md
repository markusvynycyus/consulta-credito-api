# API de Consulta de Créditos NFSe

![Java Badge](https://camo.githubusercontent.com/bea90da226e09b503e6c8fde824f4816b98dcf30cd31e803006bf6335af06890/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6a6176612d2532334544384230302e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d6f70656e6a646b266c6f676f436f6c6f723d7768697465) <!-- Badge do Java -->
[Java Badge](https://camo.githubusercontent.com/bea90da226e09b503e6c8fde824f4816b98dcf30cd31e803006bf6335af06890/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6a6176612d2532334544384230302e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d6f70656e6a646b266c6f676f436f6c6f723d7768697465) <!-- Badge do Java -->
![Spring Badge](https://camo.githubusercontent.com/9ee242f2c2b1eb587f7e42704b3a0629082aac88f66fff96d34723f777b07775/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f737072696e672d2532333644423333462e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d737072696e67266c6f676f436f6c6f723d7768697465) <!-- Badge do Spring -->
![JWT Badge](https://camo.githubusercontent.com/6eff46a364eba690cb91a9f40084d97f96bf95699f3cb7722125dc1dc324fde1/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4a57542d626c61636b3f7374796c653d666f722d7468652d6261646765266c6f676f3d4a534f4e253230776562253230746f6b656e73) <!-- Badge do JWT -->
![Postgres Badge](https://camo.githubusercontent.com/544022edf8369d944e68802fc043b0268484709e334d23db2882590aeae296cb/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f706f7374677265732d2532333331363139322e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d706f737467726573716c266c6f676f436f6c6f723d7768697465) <!-- Badge do PostgreSQL -->

## Visão Geral

A API de Consulta de Créditos NFSe é uma solução robusta desenvolvida em Spring Boot para gerenciamento e consulta de créditos fiscais. O sistema oferece endpoints RESTful para acesso seguro e eficiente aos dados de créditos NFSe, com foco em performance e facilidade de integração.

## ✨ Principais Funcionalidades

- **Consultas Avançadas**
  - Busca de créditos por número da NFSe
  - Pesquisa por número do crédito
  - Filtros combinados para consultas complexas

- **Arquitetura Moderna**
  - Padrão DTO para transferência otimizada de dados
  - Mapeamento inteligente com ModelMapper
  - Separação clara de responsabilidades (Controller-Service-Repository)

- **Persistência de Dados**
  - Integração com PostgreSQL
  - Utilização do Spring Data JPA
  - Consultas otimizadas com JPA Query Methods

- **Pronto para Produção**
  - Documentação Swagger/OpenAPI integrada
  - Tratamento de erros personalizado
  - Configurações de segurança básica

## 🚀 Como Utilizar

### Pré-requisitos
- Java 17+
- PostgreSQL 14+
- Maven 3.6+

### Instalação
```bash
git clone https://github.com/seu-usuario/api-credito-nfse.git
cd api-credito-nfse
mvn install
```

### Configuração
Edite o arquivo `application.properties` com suas credenciais:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/nfse_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

### Execução
```bash
mvn spring-boot:run
```

## 📚 Documentação da API

A API está documentada com Swagger e pode ser acessada em:
```
http://localhost:8080/swagger-ui.html
```

## 🏗️ Estrutura do Projeto

```plaintext
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── venicios/
│   │           └── api_credito_nfse/
│   │               ├── config/            # Configurações do sistema
│   │               ├── controller/        # Endpoints da API
│   │               ├── dto/               # Data Transfer Objects
│   │               ├── exception/         # Tratamento de erros
│   │               ├── model/             # Entidades JPA
│   │               ├── repository/        # Camada de persistência
│   │               ├── service/           # Lógica de negócios
│   │               └── util/              # Utilitários e helpers
│   └── resources/
│       ├── application.properties         # Configurações
│       └── messages/                      # Mensagens internacionalizadas
└── test/                                  # Testes unitários e integração
```

## 🤝 Contribuição

Contribuições são bem-vindas! Siga estes passos:

1. Faça um fork do projeto
2. Crie uma branch (`git checkout -b feature/nova-funcionalidade`)
3. Commit suas mudanças (`git commit -m 'Adiciona nova funcionalidade'`)
4. Push para a branch (`git push origin feature/nova-funcionalidade`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está licenciado sob a licença MIT - veja o arquivo [LICENSE](LICENSE) para detalhes.

---

**Desenvolvido por** [Marcos Venicios Evangelista Chaves  
**Contato**: markusvynycyus@hotmail.com  
**Versão**: 1.0.0
