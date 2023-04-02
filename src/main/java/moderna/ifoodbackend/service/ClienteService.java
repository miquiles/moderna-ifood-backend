package moderna.ifoodbackend.service;

import lombok.AllArgsConstructor;
import moderna.ifoodbackend.model.Cliente;
import moderna.ifoodbackend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteService {
    private ClienteRepository clienteRepository;

    public Cliente salvarCliente(Cliente cliente){
        Optional<Cliente> emailExiste = clienteRepository.findByEmail(cliente.getEmail());
        if(!emailExiste.isPresent()){
            return clienteRepository.save(cliente);
        }else{
            System.out.println("EMAIL EXISTENTE");
        }
        return null;
    }

}
