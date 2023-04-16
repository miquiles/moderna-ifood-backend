package moderna.ifoodbackend.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;

@Entity
@Data
@Table(name = "db_endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rua;
    private String numero;
    private String CEP;
    private String bairro;
    private String cidade;
    private String estado;

}
