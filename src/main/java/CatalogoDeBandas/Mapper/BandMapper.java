package CatalogoDeBandas.Mapper;

import CatalogoDeBandas.Entity.BandEntity;
import CatalogoDeBandas.Entity.GeneroEntity;
import CatalogoDeBandas.Request.BandRequest;
import CatalogoDeBandas.Response.BandResponse;
import CatalogoDeBandas.Response.GeneroResponse;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class BandMapper {

    public static BandEntity band(BandRequest request, List<GeneroEntity> genero){

        return BandEntity.builder()

                .nome(request.nome())
                .ano(request.ano())
                .descricao(request.descricao())
                .membros(request.membros())
                .generos(genero)
                .build();
    }

    public static BandResponse response(BandEntity band){

        return BandResponse.builder()
                .id(band.getId())
                .nome(band.getNome())
                .ano(band.getAno())
                .descricao(band.getDescricao())
                .membros(band.getMembros())
                .generos(band.getGeneros().stream()
                        .map(g -> new GeneroResponse(g.getId(), g.getNome()))
                        .collect(Collectors.toList()))
                .build();
    }

}
