# CATÁLOGO DE BANDAS

API REST para gerencir um catálogo de bandas de rock, desenvolvida com SpringBoot e arquitetura moderna.

## Sobre o Projeto

Permite aos usuários catalogar bandas de rock, seja famosa ou desconhecida. O projeto foi desenvolvido com foco em:

- **Divulgação**: Catalogando bandas e criando um acervo onde qualquer um tem acesso
- **Todos os Sub-Gêneros**: Metal, Glam Metal, Hard Rock, Funk Rock, Rock Alternativo...
- **Escalabilidade**: Arquitetura preparada para crescimento

## Arquitetura

O projeto segue uma arquitetura em camadas:

```
src/C:/java/CatalogoDeBandas/
├── controller/     # Controllers REST
├── entity/         # Entidades JPA
├── mapper/         # Conversão entre DTOs e entidades
├── repository/     # Repositórios Spring Data
└── service/        # Regras de negócio
```

## Tecnologias Utilizadas

### Backend
- Lombok, JPA/Hibernate, PostGreSQL, H2(testes), Docker, Mapper, ResponseEntity, Flyway, Swagger/OpenAPI, Maven
