package co.edu.uniquindio.proyecto.DTO;

import co.edu.uniquindio.proyecto.Modelo.Ciudad;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Esta clase nos permite obtener los datos que necesitamos al realizar
 * los metodos en la implementación
*/

@AllArgsConstructor
@Getter
@Setter
@ToString
public class UsuarioGetDTO {

    private int codigo;

    private String nombre;

    private String email;

    private String direccion;

    private String telefono;

    private Ciudad ciudad;

}
