package CatalogoDeBandas.Controller;

import CatalogoDeBandas.Request.GeneroRequest;
import CatalogoDeBandas.Response.GeneroResponse;
import CatalogoDeBandas.Service.GeneroService;
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
@RequestMapping("/genero")
@RequiredArgsConstructor
public class GeneroController {

    private final GeneroService service;
    private String mensagem = "Não foi encontrado nenhum gênero com esse id: ";

    @GetMapping("/listar")
    @Operation(summary = "Lista todos os gêneros", description = "Lista todos os gêneros que estão cadastrados no banco de dados")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Requisição bem-sucedida")})
    public ResponseEntity<List<GeneroResponse>> listar(){
        List<GeneroResponse> listar = service.listar();
        return ResponseEntity.ok(listar);
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista um gênero por ID", description = "Lista um gênero a partir do ID enviado pelo usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Requisição bem-sucedida"),
            @ApiResponse(responseCode = "404", description = "O recurso não foi encontrado")
    })
    public ResponseEntity<GeneroResponse> listarId(@Parameter(description = "Usuário envia um ID")@PathVariable Long id){
       return service.listarPorId(id)
               .map(ResponseEntity::ok)
               .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/criar")
    @Operation(summary = "Cria um novo gênero", description = "Cria um novo gênero com os dados enviados pelo usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso")
    })
    public ResponseEntity<GeneroResponse> criar(@RequestBody GeneroRequest request){
        service.salvar(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera um gênero por ID", description = "Procura um gênero por ID e em seguida é alterado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Requisição bem-sucedida"),
            @ApiResponse(responseCode = "404", description = "O recurso não foi encontrado")
    })
    public ResponseEntity<?> alterarPorId(@Parameter(description = "Usuário envia um ID")@PathVariable Long id, @RequestBody GeneroRequest request){
        return service.listarPorId(id).map(alterar -> {
            service.alterar(id, request);
            return ResponseEntity.ok().build();
        }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem + id));
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta um gênero por ID", description = "Procura um gênero por ID e em seguida é deletado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Requisição bem-sucedida"),
            @ApiResponse(responseCode = "404", description = "O recurso não foi encontrado")
    })
    public ResponseEntity<?> deletar(@Parameter(description = "Usuário envia um ID")@PathVariable Long id){
        return service.listarPorId(id).map(deletar -> {
            service.deletar(id);
            return ResponseEntity.ok().build();
        }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem + id));
    }

}
