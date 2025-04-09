package CatalogoDeBandas.Response;

import lombok.Builder;

@Builder
public record BandResponse(Long id, String nome, int ano, String descricao, int membros) {
}
