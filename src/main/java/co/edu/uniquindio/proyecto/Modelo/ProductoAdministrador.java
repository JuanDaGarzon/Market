package co.edu.uniquindio.proyecto.Modelo;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductoAdministrador implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10)
    private Integer codigo;

    @Column(length = 10, nullable = false)
    private String motivo;

    private String mensaje;

    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @ManyToOne
    private Producto producto;

    @ManyToOne
    private Administrador administrador;

}
