package co.edu.uniquindio.proyecto.DTO;

import co.edu.uniquindio.proyecto.Modelo.Estado;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
@Getter
@Setter
@ToString
@AllArgsConstructor
public class ProductoAdminDTO {

    @NotBlank
    @NotNull
    @Column(length = 400, nullable = false)
    private String motivo;

    @NotBlank
    @NotNull
    @Column(length = 400, nullable = false)
    private String mensaje;

    @NotBlank
    @NotNull
    private int codigoProducto;

    @NotBlank
    @NotNull
    private int codigoAdmin;

}
