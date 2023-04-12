package co.edu.uniquindio.proyecto.Modelo;



import com.fasterxml.jackson.databind.ser.std.UUIDSerializer;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.awt.*;
import java.io.Serializable;
import java.nio.MappedByteBuffer;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Producto implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10)
    private Integer codigo;

    @Column (length=50, nullable = false)
    private String nombre;

    @Column(nullable = false)
    @EqualsAndHashCode.Include
    private double precio;

    @Column(nullable = false)
    @PositiveOrZero
    private int unidades;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = false)
    private LocalDateTime fechalimite;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @OneToMany(mappedBy = "producto")
    private List<ProductoAdministrador>listaAdministradores;

    @OneToMany(mappedBy = "producto")
    private List<Comentario>comentarios;

    @ManyToMany
    @TableGenerator(name = "favorito")
    private List<Usuario>usuarios;

    @ManyToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "producto")
    private List<Carrito>Carritos;
}
