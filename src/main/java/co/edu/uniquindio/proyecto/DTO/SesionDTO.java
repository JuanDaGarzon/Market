package co.edu.uniquindio.proyecto.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SesionDTO {

    @NotBlank
    @Email
    @NotNull
    private String email;

    @NotBlank
    @NotNull
    private String password;

}
