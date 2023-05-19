package moderna.ifoodbackend.controller;

import lombok.AllArgsConstructor;

import moderna.ifoodbackend.model.empresa.Restaurante;
import moderna.ifoodbackend.repository.RestauranteRepository;
import moderna.ifoodbackend.service.RestauranteService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/restaurantes")
public class RestauranteController {

    RestauranteRepository restauranteRepository;
    RestauranteService restauranteService;

    @PostMapping("/criar")
    public Restaurante novo(@RequestBody Restaurante restaurante){
        return restauranteRepository.save(restaurante);
    }

    @GetMapping("listar-todos")
    public List<Restaurante> listar(){
        return restauranteRepository.findAll();
    }

    @GetMapping("listar/")
    public Optional<List<Restaurante>> listarPorCategoria(@RequestParam (value = "categoria") String categoria){
        return restauranteRepository.findByCategoria(categoria);
    }

    @GetMapping("buscar/{id}")
    public Optional<Restaurante> buscarPorId(@PathVariable Long id){
        return restauranteRepository.findById(id);
    }

    @DeleteMapping("deletar/{id}")
    public void deletarPorId(@PathVariable Long id){
        restauranteRepository.deleteById(id);
    }

    @DeleteMapping("deletar-todos")
    public void deletarTodos(){
        restauranteRepository.deleteAll();
    }

    @GetMapping("categorias")
    public Collection<Object> listarCategorias(){
        return restauranteService.listarCategorias();
    }


}
