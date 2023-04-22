package co.edu.uniquindio.proyecto.DTO;

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

    @Positive
    private int codigoProducto;

    @PositiveOrZero
    private int unidades;

    @PositiveOrZero
    private float precio;

}
