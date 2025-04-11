package CatalogoDeBandas.Response;

import lombok.Builder;

import java.util.List;

@Builder
public record BandResponse(Long id, String nome, int ano, String descricao, int membros, List<GeneroResponse> generos) {
}
