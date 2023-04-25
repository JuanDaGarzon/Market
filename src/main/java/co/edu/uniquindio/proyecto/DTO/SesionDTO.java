package co.edu.uniquindio.proyecto.DTO;

import jakarta.validation.constraints.Email;
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
public class SesionDTO {

    @NotBlank
    @Email
    @NotNull
    private String email;

    @NotBlank
    @NotNull
    private String password;

    @NotNull
    @NotBlank
    private int tipo;

}
