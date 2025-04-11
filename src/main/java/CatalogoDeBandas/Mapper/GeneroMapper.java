package CatalogoDeBandas.Mapper;

import CatalogoDeBandas.Entity.GeneroEntity;
import CatalogoDeBandas.Request.GeneroRequest;
import CatalogoDeBandas.Response.GeneroResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GeneroMapper {

    public static GeneroEntity genero(GeneroRequest request){

        return GeneroEntity.builder()
                .nome(request.nome())
                .build();

    }

    public static GeneroResponse response(GeneroEntity genero){

        return GeneroResponse.builder()
                .id(genero.getId())
                .nome(genero.getNome())
                .build();
    }
}
