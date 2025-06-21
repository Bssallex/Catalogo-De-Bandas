# 🎸 Catálogo de Bandas

API REST desenvolvida para gerenciar um catálogo de **bandas de rock**, incluindo diversos subgêneros. Usuários podem cadastrar, editar e remover bandas, bem como associá-las a gêneros musicais. A aplicação é escalável, estruturada com boas práticas e preparada para produção com versionamento de banco via Flyway, documentação Swagger e execução via Docker.

---

## 📊 Tecnologias e Ferramentas

- Java 17  
- Spring Boot  
- Spring Data JPA  
- Arquitetura em Camadas (MVC)  
- Swagger / OpenAPI  
- Lombok  
- DTOs e Mapper  
- Maven  
- Flyway  
- Docker + PostgreSQL  
- YAML  
- ResponseEntity  

---

## 🚀 Funcionalidades

### 🎸 Bandas

- 🔍 Listar todas as bandas  
- 🔍 Buscar banda por ID  
- 📝 Criar uma nova banda  
- ✏️ Alterar dados de uma banda existente  
- 🗑️ Deletar uma banda  

### 🎼 Gêneros

- 🔍 Listar todos os gêneros musicais  
- 🔍 Buscar gênero por ID  
- 📝 Criar um novo gênero  
- ✏️ Alterar dados de um gênero existente  
- 🗑️ Deletar um gênero  

### 🔗 Relacionamento

- 🔄 Relacionamento **Many-to-Many** entre bandas e gêneros  

---

## 🧠 Regras de Negócio (Entidades Principais)

### 🎵 `Bandas`

| Atributo    | Descrição                                 |
|-------------|--------------------------------------------|
| nome        | Nome da banda                              |
| ano-criacao  | Ano de formação da banda                   |
| descricao   | Histórico ou descrição sobre a banda       |
| membros     | Lista com os nomes dos membros da banda    |
| generos     | Gêneros associados (relação Many-to-Many)  |

### 🎼 `Generos`

| Atributo | Descrição                                  |
|----------|---------------------------------------------|
| nome     | Nome do gênero musical (ex: Rock Alternativo) |
| bandas   | Bandas que pertencem a este gênero (Many-to-Many) |

---

## 📌 Endpoints

### 🎸 Bandas

| Método HTTP | Caminho                     | Descrição                          | Status                   |
|-------------|-----------------------------|------------------------------------|--------------------------|
| GET         | /bandas/listar              | Listar todas as bandas             | 200 OK                   |
| GET         | /bandas/listar/{id}         | Buscar banda por ID                | 200 OK / 404 Not Found   |
| POST        | /bandas/criar               | Criar uma nova banda               | 201 Created              |
| PUT         | /bandas/alterar/{id}        | Alterar dados da banda             | 200 OK / 404 Not Found   |
| DELETE      | /bandas/deletar/{id}        | Deletar uma banda                  | 204 No Content / 404 Not Found |

### 🎼 Gêneros

| Método HTTP | Caminho                       | Descrição                         | Status                   |
|-------------|-------------------------------|-----------------------------------|--------------------------|
| GET         | /generos/listar               | Listar todos os gêneros           | 200 OK                   |
| GET         | /generos/listar/{id}          | Buscar gênero por ID              | 200 OK / 404 Not Found   |
| POST        | /generos/criar                | Criar um novo gênero              | 201 Created              |
| PUT         | /generos/alterar/{id}         | Alterar dados de um gênero        | 200 OK / 404 Not Found   |
| DELETE      | /generos/deletar/{id}         | Deletar um gênero                 | 204 No Content / 404 Not Found |

---

## 🔐 Configuração e Segurança

- Configuração via arquivos `.yml`  
- Variáveis de ambiente para dados sensíveis  
- Containerização com **Docker** para PostgreSQL  
- Proteção dos endpoints pode ser implementada futuramente com **Spring Security + OAuth2**

---

## 🛠️ Migrations

- Banco de dados versionado com **Flyway**  
- Scripts organizados para garantir consistência entre ambientes  

---

## 🐳 Banco de Dados

- **PostgreSQL** como banco principal  
- Execução local e em containers via Docker  

---

## 📑 Documentação da API

- Documentação automática com **Swagger / OpenAPI**  
- Acesse via: `http://localhost:8080/swagger-ui.html`  

---

## 📅 Melhorias Futuras

- ✅ Testes automatizados com JUnit e Mockito  
- 🔐 Autenticação com OAuth2 (Google)  
- 📈 Filtro por gênero, ano ou nome  
- 🎨 Integração com front-end (Thymeleaf ou Angular)  
