package moderna.ifoodbackend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String documentoCliente;
    private LocalDateTime dataPedido;
    private Long restauranteId;
    private Long itemId;
    private Double valorItem;
    private UUID transacaoId;
}