package moderna.ifoodbackend.controller;

import lombok.AllArgsConstructor;
import moderna.ifoodbackend.model.Pedido;
import moderna.ifoodbackend.model.response.PedidoResponse;
import moderna.ifoodbackend.repository.PedidoRepository;
import moderna.ifoodbackend.service.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
@AllArgsConstructor
public class PedidoController {

    private PedidoService pedidoService;
    private PedidoRepository pedidoRepository;
    @PostMapping("/criar")
    public PedidoResponse criar(@RequestBody List<Pedido> pedido){
        return pedidoService.salvarPedido(pedido);
    }

    @GetMapping("mok")
    public Pedido mok(){
        return new Pedido();
    }
    @GetMapping("listar/{id}")
    public Optional<Pedido> buscarPorId(@PathVariable Long id){
        return pedidoRepository.findById(id);
    }

    @GetMapping("buscar/")
    public Optional<List<Pedido>> buscarPorId(@RequestParam(value = "documento-cliente") String documentoCliente){
        return pedidoService.buscarPorDocumentoCliente(documentoCliente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        pedidoService.deletarPedido(id);
    }
}
