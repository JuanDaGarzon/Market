package co.edu.uniquindio.proyecto.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AdministradorDTO {
    @NotNull
    private int codigo;
    @Email
    @NotBlank
    private String correo;
    @NotNull
    @NotBlank
    private String password;

}
