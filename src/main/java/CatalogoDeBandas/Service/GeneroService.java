package CatalogoDeBandas.Service;

import CatalogoDeBandas.Entity.GeneroEntity;
import CatalogoDeBandas.Mapper.GeneroMapper;
import CatalogoDeBandas.Repository.GeneroRepository;
import CatalogoDeBandas.Request.GeneroRequest;
import CatalogoDeBandas.Response.GeneroResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GeneroService {

    private final GeneroRepository repository;

    //LISTAR
    public List<GeneroResponse> listar(){
        List<GeneroEntity> lista = repository.findAll();
        return lista.stream()
                .map(GeneroMapper::response)
                .toList();
    }

    //LISTAR POR ID
    public GeneroResponse listarPorId(Long id){
        Optional<GeneroEntity> verificar = repository.findById(id);
        if(verificar.isPresent()){
            return GeneroMapper.response(verificar.get());
        }else{
            return null;
        }
    }

    //SALVAR
    public GeneroResponse salvar(GeneroRequest request){
        GeneroEntity salvar = repository.save(GeneroMapper.genero(request));
        return GeneroMapper.response(salvar);
    }

    //ALTERAR POR ID
    public GeneroResponse alterar(Long id, GeneroRequest request){
        return repository.findById(id).map(alterar -> {
            alterar.setId(id);
            alterar.setNome(request.nome());
            GeneroEntity salvar = repository.save(alterar);
            return GeneroMapper.response(salvar);
        }).orElse(null);
    }

    //DELETE

    public GeneroResponse deletar(Long id){
        return repository.findById(id).map(deletar -> {
           repository.delete(deletar);
           return GeneroMapper.response(deletar);
        }).orElse(null);
    }
}
