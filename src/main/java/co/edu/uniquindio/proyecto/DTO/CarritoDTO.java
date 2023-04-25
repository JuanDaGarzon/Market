package co.edu.uniquindio.proyecto.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString

public class CarritoDTO {

    @NotBlank
    @Positive
    private int codigoProducto;

    @NotBlank
    @PositiveOrZero
    private int unidades;

    @NotBlank
    @PositiveOrZero
    private double precio;

}
