package CatalogoDeBandas.Service;

import CatalogoDeBandas.Entity.BandEntity;
import CatalogoDeBandas.Mapper.BandMapper;
import CatalogoDeBandas.Repository.BandRepository;
import CatalogoDeBandas.Request.BandRequest;
import CatalogoDeBandas.Response.BandResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BandService {

    private final BandRepository repository;

    public List<BandResponse> listar(){
       return repository.findAll()
               .stream()
               .map(BandMapper::response)
               .toList();
    }

    public BandResponse listarPorId(Long id){
        Optional<BandEntity> verificar = repository.findById(id);

        if(verificar.isPresent()){
            return BandMapper.response(verificar.get());
        }else{
            return null;
        }
    }

    public BandResponse salvar(BandRequest band){
        BandEntity salvar = repository.save(BandMapper.band(band));
        return BandMapper.response(salvar);
    }

    public Optional<BandResponse> alterar(Long id, BandRequest band){
        return repository.findById(id)
                .map(a -> {
                   a.setNome(band.nome());
                   a.setAno(band.ano());
                   a.setMembros(band.membros());
                   a.setDescricao(band.descricao());
                   BandEntity salvar = repository.save(a);
                   return BandMapper.response(salvar);
                });
    }

    public Optional<BandResponse> deletar(Long id){
        return repository.findById(id).map(d -> {
          repository.delete(d);
          return BandMapper.response(d);
        });
    }

}
