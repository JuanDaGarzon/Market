package co.edu.uniquindio.proyecto.Modelo;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
@Entity
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Usuario extends Persona implements Serializable {

    @Column(length = 50, nullable = false)
    private String direccion;

    @Column(nullable = false, unique = true)
    private String telefono;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Ciudad ciudad;

    @ToString.Exclude
    @OneToMany(mappedBy = "usuario")
    private List<Comentario>listaComentarios;

    @ManyToMany(mappedBy = "usuariosFavoritos")
    private List<Producto> productosFavoritos;

    @ToString.Exclude
    @OneToMany(mappedBy = "usuario")
    private List<Producto>listaProductos;

    @ToString.Exclude
    @OneToMany(mappedBy = "usuario")
    private List<Compra>compras;

}
