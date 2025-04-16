CREATE TABLE catalogo(
   id serial PRIMARY KEY,
   nome_banda varchar(255) NOT NULL,
   ano_criacao INTEGER,
   descricao varchar(255),
   membros INTEGER
);