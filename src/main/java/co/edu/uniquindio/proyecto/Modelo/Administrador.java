package co.edu.uniquindio.proyecto.Modelo;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Administrador extends Persona implements Serializable {

    @OneToMany(mappedBy = "administrador")
    private List<ProductoAdministrador>listaProductos;

}
