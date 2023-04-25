package co.edu.uniquindio.proyecto.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@AllArgsConstructor
public class SesionGetDTO {

    private String nombre;

    private String password;

    private int tipo;

}
