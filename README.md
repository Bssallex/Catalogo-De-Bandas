# 🎸 CATÁLOGO DE BANDAS

API RESTful desenvolvida com **Spring Boot** para gerenciar um catálogo de bandas de rock, incluindo diversos subgêneros. A aplicação é escalável, moderna e segue a arquitetura MVC, implementando boas práticas de desenvolvimento backend.

---

## 📌 Funcionalidades

### 🎸 Entidade: Bandas  
- ✅ Cadastrar uma nova banda  
- ✅ Listar todas as bandas  
- ✅ Buscar banda por ID  
- ✅ Alterar dados de uma banda  
- ✅ Deletar banda  

### 🎼 Entidade: Gênero  
- ✅ Listar todos os gêneros  
- ✅ Buscar gênero por ID  
- ✅ Criar um novo gênero  
- ✅ Atualizar um gênero existente  
- ✅ Deletar um gênero  

### 🔗 Relacionamento de Tabelas  
- ✅ Implementação de relacionamento **Many-to-Many** entre bandas e gêneros  

---

## 🚀 Tecnologias Utilizadas

- Java 17  
- Spring Boot  
- Spring Data JPA  
- PostgreSQL    
- Flyway   
- Swagger 
- Docker  
- Lombok  
- Maven   
- YAML  
- ResponseEntity  
- DTOs     

---

## 🧱 Camadas da Aplicação

- `controller` - Camada de exposição de endpoints REST  
- `service` - Camada de regras de negócio  
- `repository` - Camada de persistência (Spring Data JPA)  
- `entity` - Entidades JPA representando tabelas  
- `mapper` - Conversão entre entidades e DTOs  
- `request` - Objetos de entrada  
- `response` - Objetos de saída  

---

## 🗃️ Entidades

### 🎵 Banda

A entidade `Banda` contém os seguintes campos:

- `nome`: Nome da banda  
- `anoCriacao`: Ano de criação  
- `descricao`: Breve histórico da banda  
- `membros`: Lista de membros da banda  
- `generos`: Lista de gêneros associados (**ManyToMany** com `Genero`)  

### 🎼 Gênero

A entidade `Genero` possui:

- `nome`: Nome do gênero musical  
- `bandas`: Lista de bandas associadas (**ManyToMany** com `Banda`)  

---

## 🔄 Endpoints

### 🎸 BandaController

| Método | Endpoint             | Descrição                      | Status HTTP             |
|--------|----------------------|--------------------------------|-------------------------|
| GET    | `/bandas/listar`     | Lista todas as bandas          | `200 OK`                |
| GET    | `/bandas/listar/{id}`| Lista uma banda por ID         | `200 OK` / `404 Not Found` |
| POST   | `/bandas/criar`      | Cria uma nova banda            | `201 Created`           |
| PUT    | `/bandas/alterar/{id}`| Altera os dados de uma banda  | `200 OK` / `404 Not Found` |
| DELETE | `/bandas/deletar/{id}`| Remove uma banda               | `204 No Content` / `404 Not Found` |

### 🎼 GeneroController

| Método | Endpoint               | Descrição                       | Status HTTP             |
|--------|------------------------|----------------------------------|-------------------------|
| GET    | `/generos/listar`      | Lista todos os gêneros           | `200 OK`                |
| GET    | `/generos/listar/{id}` | Lista um gênero por ID           | `200 OK` / `404 Not Found` |
| POST   | `/generos/criar`       | Cria um novo gênero              | `201 Created`           |
| PUT    | `/generos/alterar/{id}`| Altera os dados de um gênero     | `200 OK` / `404 Not Found` |
| DELETE | `/generos/deletar/{id}`| Remove um gênero                 | `204 No Content` / `404 Not Found` |

---

## 🔐 Configuração e Segurança

- Configuração centralizada em arquivos `.yml`  
- Variáveis de ambiente utilizadas para dados sensíveis (como credenciais e URLs)  
- Docker para gerenciamento de containers de banco de dados  

---

## 🛠️ Migrations

- Banco de dados versionado com **Flyway**  

---

## 🐳 Banco de Dados

- **PostgreSQL** como banco de produção    

---

## 📑 Documentação da API

- Documentada com **Swagger(OpenAPI)** 

---

