package moderna.ifoodbackend.service;

import lombok.AllArgsConstructor;
import moderna.ifoodbackend.model.empresa.Restaurante;
import moderna.ifoodbackend.repository.RestauranteRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class RestauranteService {

    private RestauranteRepository restauranteRepository;

    public Collection<Object> listarCategorias(){
        var restaurantes = restauranteRepository.findAll();
        Collection<Object> categorias = new LinkedHashSet<>();

        for (Restaurante restaurante : restaurantes){
            categorias.add(Collections.singletonList((restaurante.getCategoria())));
        }
       return categorias;
    }
}
