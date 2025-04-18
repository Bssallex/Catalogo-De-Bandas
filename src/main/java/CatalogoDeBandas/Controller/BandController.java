package CatalogoDeBandas.Controller;

import CatalogoDeBandas.Request.BandRequest;
import CatalogoDeBandas.Response.BandResponse;
import CatalogoDeBandas.Service.BandService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/band")
@RequiredArgsConstructor
public class BandController {

    private final BandService service;

    private String mensagem = "Não foi possível encontrar nenhuma banda com esse id: ";

    @GetMapping("/listar")
    @Operation(summary = "Lista todas as bandas", description = "Lista todas as bandas que estão cadastradas no banco de dados")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Requisição bem-sucedida")})
    public ResponseEntity<List<BandResponse>> listar(){
        List<BandResponse> lista = service.listar();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista uma banda por ID", description = "Lista uma banda de acordo com o ID enviado pelo usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Requisição bem-sucedida"),
            @ApiResponse(responseCode = "404", description = "O recurso não foi encontrado")
    })
    public ResponseEntity<?> listarPorId(@Parameter(description = "Usuário envia um ID")@PathVariable Long id){
       return service.listarPorId(id)
               .map(ResponseEntity::ok)
               .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/criar")
    @Operation(summary = "Cria uma nova banda", description = "Cria uma nova banda de acordo com os dados enviados pelo usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso")
    })
    public ResponseEntity<BandResponse> criar(@RequestBody BandRequest request){
        BandResponse salvar = service.salvar(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera uma banda por ID", description = "Procura a banda pelo ID e em seguida altera os dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Requisição bem-sucedida"),
            @ApiResponse(responseCode = "404", description = "O recurso não foi encontrado")
    })
    public ResponseEntity<?> alterar(@Parameter(description = "Usuário envia um ID")@PathVariable Long id, @RequestBody BandRequest band){
      return service.listarPorId(id).map(alterar -> {
          service.alterar(id, band);
          return ResponseEntity.ok().build();
      }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem + id));
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta uma banda por ID", description = "Procura uma banda por ID e em seguida é deletada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Requisição bem-sucedida"),
            @ApiResponse(responseCode = "404", description = "O recurso não foi encontrado")
    })
    public ResponseEntity<?> deletar(@Parameter(description = "Usuário envia um ID")@PathVariable Long id){
        return service.listarPorId(id).map(deletar -> {
                    service.deletar(id);
                    return ResponseEntity.ok().build();
                }).orElseGet(() ->  ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem + id));
    }
}
