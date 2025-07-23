package ec.sasf.Cafeteria.persistence.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "clientes")
@Data
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente",nullable = false)
    private Long idCliente;

    private String nombre;

    private String correo;

    private String telefono;
}
