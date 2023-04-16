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
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteController {

    private ClienteRepository clienteRepository;
    private ClienteService clienteService;

    @GetMapping("/exibe-texto")
    public String retornaTextoBoasVindas(){
        return "Seja Bem-vindo ao serviço de cliente do IfoodModerna";
    }

    @GetMapping("/exibir-cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente retornaCliente(){
        Cliente cliente1 = new Cliente();
        cliente1.setEmail("thebestactor@gmail.com");
        cliente1.setDataNascimento("12/10/1970");
        cliente1.setNome("Joey Tribiani");
        return cliente1;

        }

    @PostMapping("salvar-cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvarCliente(@RequestBody Cliente cliente){
        return clienteService.salvarCliente(cliente);
    }

    @GetMapping("/listar-clientes")
    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    @GetMapping("buscar-cliente/{id}")
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

