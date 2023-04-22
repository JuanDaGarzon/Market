package co.edu.uniquindio.proyecto.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class TokenDTO {
    private String token;
    private String estado;
}
