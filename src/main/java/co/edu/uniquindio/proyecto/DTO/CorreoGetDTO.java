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
public class CorreoGetDTO {


    private String asunto;
    private String cuerpo;
    private String destinatario;



}
