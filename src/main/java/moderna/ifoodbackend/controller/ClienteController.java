package moderna.ifoodbackend.controller;

import lombok.AllArgsConstructor;
import moderna.ifoodbackend.model.Cliente;
import moderna.ifoodbackend.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteController {

    private ClienteRepository clienteRepository;

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

    @PostMapping("/salvar-cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvarCliente(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);

    }


}

