package co.edu.uniquindio.proyecto.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CorreoDTO {

    @NotNull
    @NotBlank
    private String asunto;

    @NotNull
    @NotBlank
    private String cuerpo;

    @NotNull
    @NotBlank
    private String destinatario;
}
