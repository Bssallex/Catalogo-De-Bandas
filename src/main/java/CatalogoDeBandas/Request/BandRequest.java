package CatalogoDeBandas.Request;

import lombok.Builder;

import java.util.List;

@Builder
public record BandRequest(String nome, int ano, String descricao, int membros, List<Long> generosId) {
}
