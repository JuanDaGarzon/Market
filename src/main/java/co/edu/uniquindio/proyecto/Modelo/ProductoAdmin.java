package co.edu.uniquindio.proyecto.Modelo;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductoAdmin implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10)
    private Integer codigo;

    @Column(length = 400, nullable = false)
    private String motivo;

    @Column(length = 400, nullable = false)
    private String mensaje;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estado estado;

    @ManyToOne
    private Producto producto;

    @ManyToOne
    private Administrador administrador;

}
