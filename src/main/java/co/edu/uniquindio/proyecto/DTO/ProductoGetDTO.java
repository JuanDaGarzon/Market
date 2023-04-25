package co.edu.uniquindio.proyecto.DTO;

import co.edu.uniquindio.proyecto.Modelo.Categoria;
import co.edu.uniquindio.proyecto.Modelo.Estado;
import co.edu.uniquindio.proyecto.Modelo.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ProductoGetDTO {

    private String nombre;
    private int unidades;
    private Double precio;
    private String descripcion;
    private Integer codigo;
    private LocalDateTime fechaLimite;
    private Estado estado;
    private Integer codigoVendedor;
    private Categoria categoria;
    private Map<String,String> imagenes;
    private List<Usuario>listaUsuariosFavoritos;


}
