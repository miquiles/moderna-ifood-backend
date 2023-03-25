package moderna.ifoodbackend.controller;

import lombok.AllArgsConstructor;
import moderna.ifoodbackend.model.Cliente;
import moderna.ifoodbackend.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

    private ClienteRepository clienteRepository;


    @GetMapping("/exibe-texto")
    public String retornaTextoBoasVindas(){
        return "Seja Bem-vindo ao serviço de cliente do IfoodModerna";
    }

    @GetMapping("/exibir-cliente")
    @ResponseStatus(HttpStatus.OK)
    public Cliente retornaCliente(){
        Cliente cliente1 = new Cliente();
        cliente1.setEmail("thebestactor@gmail.com");
        cliente1.setDataNascimento("12/10/1970");
        cliente1.setNome("Joey Tribiani");
        return cliente1;

        }

    @GetMapping("/listar-clientes")
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> retornaClientes(){
        Cliente cliente1 = new Cliente();
        cliente1.setEmail("thebestactor@gmail.com");
        cliente1.setDataNascimento("12/10/1970");
        cliente1.setNome("Joey Tribiani");

        Cliente cliente2 = new Cliente();
        cliente1.setEmail("green@ralphlauren.com");
        cliente1.setDataNascimento("14/11/1975");
        cliente1.setNome("Rachel Green");

        Cliente cliente3 = new Cliente();
        cliente1.setEmail("paleontólogo@gmail.com");
        cliente1.setDataNascimento("12/10/1972");
        cliente1.setNome("Ross Geller");

        List listaClientes = new ArrayList();
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);

        return listaClientes;

    }
    //forma simples
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }
    //com responseEntity
    @PostMapping("/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cliente> saves(@RequestBody Cliente cliente){
        return new ResponseEntity(clienteRepository.save(cliente), HttpStatus.CREATED);
    }


}

