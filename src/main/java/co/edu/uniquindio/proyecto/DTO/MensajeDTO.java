package co.edu.uniquindio.proyecto.DTO;

import lombok.*;
import org.springframework.http.HttpStatus;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MensajeDTO<T> {

    private HttpStatus codigo;
    private boolean error;
    private T respuesta;

}
