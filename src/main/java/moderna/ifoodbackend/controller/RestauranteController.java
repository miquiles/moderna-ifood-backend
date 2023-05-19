package moderna.ifoodbackend.controller;

import lombok.AllArgsConstructor;

import moderna.ifoodbackend.model.empresa.Restaurante;
import moderna.ifoodbackend.repository.RestauranteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/restaurantes")
public class RestauranteController {

    RestauranteRepository restauranteRepository;
    @PostMapping("/criar")
    public Restaurante novo(@RequestBody Restaurante restaurante){
        return restauranteRepository.save(restaurante);
    }

    @GetMapping("listar-todos")
    public List<Restaurante> listar(){
        return restauranteRepository.findAll();
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


}
