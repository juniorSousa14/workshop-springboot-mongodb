# API REST com Spring Boot e MongoDB

![Java](https://img.shields.io/badge/Java-11%2B-blue?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-2.x.x-green?style=for-the-badge&logo=spring)
![MongoDB](https://img.shields.io/badge/MongoDB-4.x-green?style=for-the-badge&logo=mongodb)
![License](https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge)

Este projeto é uma API RESTful desenvolvida em Java com Spring Boot, projetada para demonstrar a integração com um banco
de dados NoSQL, o MongoDB. A aplicação simula um sistema de blog simples, com funcionalidades para gerenciar usuários,
posts e comentários.

O foco principal é explorar as melhores práticas de desenvolvimento de APIs, modelagem de dados em um banco orientado a
documentos e a criação de consultas complexas com Spring Data MongoDB.

## ✨ Funcionalidades

- **Gerenciamento de Usuários**: Operações CRUD completas (Criar, Ler, Atualizar, Deletar) para usuários.
- **Sistema de Posts**: Endpoints para buscar posts por ID e realizar buscas avançadas.
- **Associações Híbridas**: Demonstração de duas abordagens de modelagem de dados em NoSQL:
    - **Referências (`@DBRef`)**: Para associar posts a um usuário.
    - **Documentos Aninhados (Embedded)**: Para armazenar comentários dentro de um post.
- **Padrão DTO (Data Transfer Object)**: Utilização de DTOs para controlar os dados expostos pela API, garantindo
  segurança e otimização.
- **Consultas Avançadas**: Implementação de buscas personalizadas, incluindo:
    - Busca por texto com *query methods*.
    - Busca com múltiplos critérios (texto e intervalo de datas) utilizando a anotação `@Query`.
- **Tratamento de Exceções**: Manipulação centralizada de exceções para respostas de erro padronizadas na API.

## 🛠️ Tecnologias Utilizadas

- **Java 11+**
- **Spring Boot**
- **Spring Data MongoDB**
- **MongoDB**
- **Maven**

## 📂 Conceitos de Modelagem de Dados

O projeto utiliza uma abordagem híbrida para relacionar as entidades, explorando os pontos fortes dos bancos de dados
orientados a documentos.

1. **User ↔ Post (Referências)**
    - A coleção `users` armazena os usuários e a coleção `posts` armazena os posts.
    - Um `Post` contém uma referência (`@DBRef`) ao seu `User` (autor). Essa abordagem evita a duplicação de dados do
      usuário em cada post e mantém as coleções independentes.

2. **Post ↔ Comment (Documentos Aninhados)**
    - Os comentários são armazenados como uma lista de documentos dentro do próprio `Post`.
    - Essa decisão foi tomada porque os comentários têm um forte acoplamento com o post e geralmente são lidos juntos, o
      que otimiza a performance de leitura ao evitar a necessidade de uma consulta adicional (*join*).

## 🚀 Como Executar

Para executar este projeto localmente, siga os passos abaixo.

### Pré-requisitos

- JDK 11 ou superior
- Maven 3.6+
- MongoDB Server

### Passos

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/juniorSousa14/workshop-springboot-mongodb.git
   ```

2. **Inicie o MongoDB:**
   Abra um terminal e certifique-se de que o serviço do MongoDB está em execução.
   ```bash
   mongod
   ```

3. **Configure a conexão (opcional):**
   O arquivo `src/main/resources/application.properties` já está configurado para uma instância local padrão.
   ```properties
   spring.data.mongodb.uri=mongodb://localhost:27017/workshop_mongo
   ```

4. **Execute a aplicação:**
   Use o Maven para compilar e iniciar o servidor Spring Boot.
   ```bash
   mvn spring-boot:run
   ```

5. **Acesse a API:**
   A aplicação estará disponível em `http://localhost:8080`.

## 📖 Endpoints da API

| Método | Endpoint                    | Descrição                                                                 |
| :----- | :-------------------------- | :------------------------------------------------------------------------ |
| `GET`  | `/users`                    | Retorna todos os usuários cadastrados.                                    |
| `GET`  | `/users/{id}`               | Busca um usuário específico pelo seu ID.                                  |
| `POST` | `/users`                    | Cria um novo usuário.                                                     |
| `PUT`  | `/users/{id}`               | Atualiza os dados de um usuário existente.                                |
| `DELETE` | `/users/{id}`             | Deleta um usuário.                                                        |
| `GET`  | `/users/{id}/posts`         | Retorna todos os posts de um usuário específico.                          |
| `GET`  | `/posts/{id}`               | Busca um post específico pelo seu ID.                                     |
| `GET`  | `/posts/titlesearch`        | Busca posts contendo um texto no título (`?text=...`).                    |
| `GET`  | `/posts/fullsearch`         | Busca posts com múltiplos critérios (`?text=...&minDate=...&maxDate=...`). |

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---
_Desenvolvido para fins de estudo e demonstração de tecnologia._