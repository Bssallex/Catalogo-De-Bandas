package CatalogoDeBandas.Response;

import lombok.Builder;

@Builder
public record GeneroResponse(Long id, String nome) {
}
