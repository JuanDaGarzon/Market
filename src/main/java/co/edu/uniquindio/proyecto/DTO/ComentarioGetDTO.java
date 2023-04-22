package co.edu.uniquindio.proyecto.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@ToString

public class ComentarioGetDTO {

    private int codigo;
    private String mensaje;
    private LocalDateTime fecha;
    private int codigoProducto;
    private int codigoUsuario;

}
