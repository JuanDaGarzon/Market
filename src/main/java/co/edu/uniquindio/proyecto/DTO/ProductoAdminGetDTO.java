package co.edu.uniquindio.proyecto.DTO;

import co.edu.uniquindio.proyecto.Modelo.Administrador;
import co.edu.uniquindio.proyecto.Modelo.Estado;
import co.edu.uniquindio.proyecto.Modelo.Producto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
public class ProductoAdminGetDTO {

    private Integer codigo;

    private String motivo;

    private String mensaje;

    private LocalDateTime fecha;

    private Estado estado;

    private int codigoProducto;

    private int codigoAdministrador;

}
