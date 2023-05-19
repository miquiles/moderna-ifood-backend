package moderna.ifoodbackend.repository;

import moderna.ifoodbackend.model.empresa.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

    Optional<List<Restaurante>> findByCategoria(String categoria);
}
