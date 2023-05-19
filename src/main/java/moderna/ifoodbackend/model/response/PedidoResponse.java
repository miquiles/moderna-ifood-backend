package moderna.ifoodbackend.model.response;

import lombok.Data;
import moderna.ifoodbackend.model.empresa.Item;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Data
public class PedidoResponse {

    private String statusPagamento;
    private List<String> itens;
    private Double valorTotal;
    private LocalDateTime dataPedido;
    private UUID transacao;
}
