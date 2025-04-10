package CatalogoDeBandas.Controller;

import CatalogoDeBandas.Request.BandRequest;
import CatalogoDeBandas.Response.BandResponse;
import CatalogoDeBandas.Service.BandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/band")
@RequiredArgsConstructor
public class BandController {

    private final BandService service;

    @GetMapping("/listar")
    public List<BandResponse> listar(){
        List<BandResponse> lista = service.listar();
        return lista;
    }

    @GetMapping("/listar/{id}")
    public BandResponse listarPorId(@PathVariable Long id){
        BandResponse verificar = service.listarPorId(id);
        return verificar;
    }

    @PostMapping("/salvar")
    public BandResponse salvar(@RequestBody BandRequest request){
        BandResponse salvar = service.salvar(request);
        return salvar;
    }

    @PutMapping("/alterar/{id}")
    public BandResponse alterar(@PathVariable Long id, @RequestBody BandRequest band){
      Optional<BandResponse> verificar = service.alterar(id, band);
      return verificar.orElse(null);
    }

    @DeleteMapping("/deletar/{id}")
    public Optional<BandResponse> deletar(@PathVariable Long id){
        return service.deletar(id);
    }
}
