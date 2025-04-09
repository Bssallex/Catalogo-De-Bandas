package CatalogoDeBandas.Mapper;

import CatalogoDeBandas.Entity.BandEntity;
import CatalogoDeBandas.Request.BandRequest;
import CatalogoDeBandas.Response.BandResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BandMapper {

    public static BandEntity band(BandRequest request){

        return BandEntity.builder()

                .nome(request.nome())
                .ano(request.ano())
                .descricao(request.descricao())
                .membros(request.membros())
                .build();
    }

    public static BandResponse response(BandEntity band){

        return BandResponse.builder()
                .id(band.getId())
                .nome(band.getNome())
                .ano(band.getAno())
                .descricao(band.getDescricao())
                .membros(band.getMembros())
                .build();
    }




}
