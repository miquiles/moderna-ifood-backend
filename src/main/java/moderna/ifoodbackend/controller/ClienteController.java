package moderna.ifoodbackend.controller;

import lombok.AllArgsConstructor;
import moderna.ifoodbackend.model.Cliente;
import moderna.ifoodbackend.repository.ClienteRepository;
import moderna.ifoodbackend.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController {

    private ClienteRepository clienteRepository;
    private ClienteService clienteService;

    @PostMapping("salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvarCliente(@RequestBody Cliente cliente){
        return clienteService.salvarCliente(cliente);
    }

    @GetMapping("listar")
    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    @GetMapping("buscar/{id}")
    public Optional<Cliente> buscarClientePorId(@PathVariable("id") Long id){
        return clienteRepository.findById(id);
    }

    @DeleteMapping("deletar/{id}")
    public void deletarPorId(@PathVariable("id") Long id){
        clienteService.deletarPorId(id);
    }

    @DeleteMapping("deletar-todos")
    public void deletarTudo(){
        clienteService.deletarTodos();
    }

    @PutMapping("editar/{id}")
    public void editarCliente(@RequestBody Cliente cliente, @PathVariable("id") Long id){
        clienteService.editarClientePorId(cliente, id);
    }
}

