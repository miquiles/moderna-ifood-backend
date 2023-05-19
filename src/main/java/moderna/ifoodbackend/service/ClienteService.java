package moderna.ifoodbackend.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import moderna.ifoodbackend.model.Cliente;
import moderna.ifoodbackend.repository.ClienteRepository;
import org.springframework.stereotype.Service;
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

    public void deletarPorId(Long id){
        Optional<Cliente> clienteRetorno = clienteRepository.findById(id);
        if(clienteRetorno.isPresent()){
            clienteRepository.deleteById(id);
            System.out.println("cliente deletado");
        }else{
            System.out.println("Id nao existe");
        }

    }
    public void deletarTodos(){
        clienteRepository.deleteAll();
    }

    @Transactional
    public void editarClientePorId(Cliente cliente, Long id){
        Optional<Cliente> clienteRetorno = clienteRepository.findById(id);
        if(clienteRetorno.isPresent()){
            clienteRepository.updateCliente(id, cliente.getNome(), cliente.getEmail(), cliente.getDocumento(), cliente.getDataNascimento());
        }else{
            System.out.println("Cliente nao existe");
        }
    }
}
