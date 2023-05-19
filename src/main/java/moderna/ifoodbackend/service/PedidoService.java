package moderna.ifoodbackend.service;

import lombok.AllArgsConstructor;
import moderna.ifoodbackend.model.Pedido;
import moderna.ifoodbackend.model.empresa.Item;
import moderna.ifoodbackend.model.response.PedidoResponse;
import moderna.ifoodbackend.repository.ItemRepository;
import moderna.ifoodbackend.repository.PedidoRepository;
import moderna.ifoodbackend.repository.RestauranteRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@AllArgsConstructor
public class PedidoService {

    private RestauranteRepository restauranteRepository;
    private PedidoRepository pedidoRepository;
    private ItemRepository itemRepository;
    public PedidoResponse salvarPedido(List<Pedido> pedidos) {
        UUID transacaoId = UUID.randomUUID();
        var pedidoResponse = new PedidoResponse();
        Collection<Object> itens = new LinkedHashSet<>();

        for(Pedido pedido : pedidos){
            pedido.setDataPedido(LocalDateTime.now());
            var itemSalvo = itemRepository.findById(pedido.getItemId());
            pedido.setValorItem(itemSalvo.get().getPreco());
            pedido.setTransacaoId(transacaoId);
        }
            pedidoRepository.saveAll(pedidos);

            var valorTotal = 0.0;

            for(Pedido pedido : pedidos){

                pedidoResponse.setDataPedido(pedido.getDataPedido());
                pedidoResponse.setStatusPagamento("Pagamento confirmado");
                pedidoResponse.setTransacao(transacaoId);

                valorTotal += pedido.getValorItem();
                pedidoResponse.setValorTotal(valorTotal);
                var itemSalvo = itemRepository.findById(pedido.getItemId()).orElse(null);
                itens.add(itemSalvo.getNome());
                pedidoResponse.setItens(itens);

            }

            return pedidoResponse;
    }

    public Optional<List<Pedido>> buscarPorDocumentoCliente(String documentoCliente){
        return pedidoRepository.findByDocumentoCliente(documentoCliente);
    }

    public void deletarPedido(Long id){
        var existePedido = pedidoRepository.existsById(id);
        if(existePedido){
            restauranteRepository.deleteById(id);
        }
    }
}
