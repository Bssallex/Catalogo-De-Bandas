package CatalogoDeBandas.Controller;

import CatalogoDeBandas.Request.GeneroRequest;
import CatalogoDeBandas.Response.GeneroResponse;
import CatalogoDeBandas.Service.GeneroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genero")
@RequiredArgsConstructor
public class GeneroController {

    private final GeneroService service;

    @GetMapping("/listar")
    public List<GeneroResponse> listar(){
        List<GeneroResponse> listar = service.listar();
        return listar;
    }

    @GetMapping("/listar/{id}")
    public GeneroResponse listarId(@PathVariable Long id){
        GeneroResponse listar = service.listarPorId(id);
        return listar;
    }

    @PostMapping("/salvar")
    public GeneroResponse salvar(@RequestBody GeneroRequest request){
        GeneroResponse salvar = service.salvar(request);
        return salvar;
    }

    @PutMapping("/alterar/{id}")
    public GeneroResponse alterarPorId(@PathVariable Long id, @RequestBody GeneroRequest request){
        GeneroResponse alterar = service.alterar(id, request);
        return alterar;
    }
    @DeleteMapping("/deletar/{id}")
    public GeneroResponse deletar(@PathVariable Long id){
        GeneroResponse deletar = service.deletar(id);
        return deletar;
    }

}
