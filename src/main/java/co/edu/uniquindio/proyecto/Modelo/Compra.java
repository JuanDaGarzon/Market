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
public class Compra implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10)
    private Integer codigo;

    @Column(nullable = false)
    private LocalDateTime fechaCeacion;

    @Column(nullable = false)
    private double valorTotal;

    @Enumerated(EnumType.STRING)
    private MetodoPago metodoPago;

    @OneToMany(mappedBy = "compra")
    private  List<Carrito>carritos;

    @ManyToOne
    private Usuario usuario;
}
