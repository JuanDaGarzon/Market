package co.edu.uniquindio.proyecto.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
@Getter
@Setter
@AllArgsConstructor
@ToString

public class ComentarioDTO {

    @NotBlank
    @Column(nullable = false)
    @Length(max = 400, message = "El comentario tiene maximo 400 caracteres")
    private String mensaje;

    @Positive
    private int codigoUsuario;

    @Positive
    private int codigoProducto;

}
