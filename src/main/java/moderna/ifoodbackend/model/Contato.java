package moderna.ifoodbackend.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "db_contato")
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ddd;
    private String numero;
    private String email;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}
