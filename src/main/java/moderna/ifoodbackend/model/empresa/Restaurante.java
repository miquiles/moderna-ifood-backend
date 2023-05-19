package moderna.ifoodbackend.model.empresa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import moderna.ifoodbackend.model.Contato;
import moderna.ifoodbackend.model.Endereco;

import java.util.List;

@Entity
@Data
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String documento;
    private String categoria;
    private double avaliacao;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurante_id")
    private List<Item> itens;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurante_id")
    private List<Contato> contatos;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurante_id")
    private List<Endereco> enderecos;

}
