package CatalogoDeBandas.Request;

import lombok.Builder;

@Builder
public record BandRequest(String nome, int ano, String descricao, int membros) {
}
