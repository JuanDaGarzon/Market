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
public class Administrador extends Persona implements Serializable {

    @ToString.Exclude
    @OneToMany(mappedBy = "administrador")
    private List<ProductoAdmin>listaProductos;

}
