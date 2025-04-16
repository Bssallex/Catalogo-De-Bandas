CREATE TABLE banda_genero(
   banda_id INTEGER,
   genero_id INTEGER,
   CONSTRAINT fk_banda_genero_banda FOREIGN KEY(banda_id) REFERENCES catalogo(id),
   CONSTRAINT fk_banda_genero_genero FOREIGN KEY(genero_id) REFERENCES genero(id)
);