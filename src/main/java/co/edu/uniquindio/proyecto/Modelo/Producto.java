package co.edu.uniquindio.proyecto.Modelo;



import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
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
    private Double precio;

    @Column(nullable = false)
    @PositiveOrZero
    private int unidades;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = false)
    private LocalDateTime fechaLimite;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Categoria categoria;


    @ElementCollection
    private Map<String,String>imagenes;

    @ToString.Exclude
    @OneToMany(mappedBy = "producto")
    private List<ProductoAdmin>listaAdministradores;

    @ToString.Exclude
    @OneToMany(mappedBy = "producto")
    private List<Comentario>comentarios;

    @ManyToMany
    @JoinTable(name = "favorito",
            joinColumns = @JoinColumn(name = "producto"),
            inverseJoinColumns = @JoinColumn(name = "usuario"))
    private List<Usuario>usuariosFavoritos;

    @ManyToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "producto")
    @ToString.Exclude
    private List<Carrito>Carritos;

}
