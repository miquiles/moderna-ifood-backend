package moderna.ifoodbackend.controller;

import moderna.ifoodbackend.model.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

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

    @GetMapping("/listar-clientes")
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


}
