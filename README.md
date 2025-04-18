# CATÁLOGO DE BANDAS

API REST para gerenciar um catálogo de bandas de rock, desenvolvida com SpringBoot e arquitetura moderna.

## Sobre o Projeto

Permite aos usuários catalogar bandas de rock, seja famosa ou desconhecida. O projeto foi desenvolvido com foco em:

- **Divulgação**: Catalogando bandas e criando um acervo onde qualquer um tem acesso
- **Todos os Subgêneros**: Metal, Heavy Metal, Glam Metal, Hard Rock, Funk Rock, Punk Rock, Indie, Grunge...
- **Escalabilidade**: Arquitetura preparada para crescimento

## Arquitetura

O projeto segue uma arquitetura em camadas:

```
C:/java/CatalogoDeBandas/src/
├── controller/     # Controllers REST
├── entity/         # Entidades JPA
├── mapper/         # Conversão entre DTOs e entidades
├── repository/     # Repositórios Spring Data
└── service/        # Regras de negócio
```
### BACKEND
- Lombok, JPA/Hibernate, Maven, PostGreSQL, H2(testes), Docker, Mapper, ResponseEntity, Flyway, Swagger/OpenAPI...
