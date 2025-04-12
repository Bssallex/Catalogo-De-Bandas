package CatalogoDeBandas.Controller;

import CatalogoDeBandas.Mapper.GeneroMapper;
import CatalogoDeBandas.Request.GeneroRequest;
import CatalogoDeBandas.Response.GeneroResponse;
import CatalogoDeBandas.Service.GeneroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/genero")
@RequiredArgsConstructor
public class GeneroController {

    private final GeneroService service;
    private String mensagem = "Não foi encontrado nenhum gênero com esse id: ";

    @GetMapping("/listar")
    public ResponseEntity<List<GeneroResponse>> listar(){
        List<GeneroResponse> listar = service.listar();
        return ResponseEntity.ok(listar);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<GeneroResponse> listarId(@PathVariable Long id){
       return service.listarPorId(id)
               .map(ResponseEntity::ok)
               .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/salvar")
    public ResponseEntity<GeneroResponse> salvar(@RequestBody GeneroRequest request){
        service.salvar(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarPorId(@PathVariable Long id, @RequestBody GeneroRequest request){
        return service.listarPorId(id).map(alterar -> {
            service.alterar(id, request);
            return ResponseEntity.ok().build();
        }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem + id));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        return service.listarPorId(id).map(deletar -> {
            service.deletar(id);
            return ResponseEntity.ok().build();
        }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem + id));
    }

}
