package moderna.ifoodbackend.repository;

import moderna.ifoodbackend.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    Optional<List<Pedido>> findByDocumentoCliente(String documentoCliente);
}
