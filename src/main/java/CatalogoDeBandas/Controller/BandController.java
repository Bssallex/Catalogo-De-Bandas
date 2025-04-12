package CatalogoDeBandas.Controller;

import CatalogoDeBandas.Mapper.BandMapper;
import CatalogoDeBandas.Request.BandRequest;
import CatalogoDeBandas.Response.BandResponse;
import CatalogoDeBandas.Service.BandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/band")
@RequiredArgsConstructor
public class BandController {

    private final BandService service;

    private String mensagem = "Não foi possível encontrar nenhuma banda com esse id: ";

    @GetMapping("/listar")
    public ResponseEntity<List<BandResponse>> listar(){
        List<BandResponse> lista = service.listar();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id){
       return service.listarPorId(id)
               .map(ResponseEntity::ok)
               .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/salvar")
    public ResponseEntity<BandResponse> salvar(@RequestBody BandRequest request){
        BandResponse salvar = service.salvar(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterar(@PathVariable Long id, @RequestBody BandRequest band){
      return service.listarPorId(id).map(alterar -> {
          service.alterar(id, band);
          return ResponseEntity.ok().build();
      }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem + id));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        return service.listarPorId(id).map(deletar -> {
                    service.deletar(id);
                    return ResponseEntity.ok().build();
                }).orElseGet(() ->  ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem + id));
    }
}
