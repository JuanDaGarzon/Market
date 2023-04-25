package co.edu.uniquindio.proyecto.DTO;

import co.edu.uniquindio.proyecto.Modelo.MetodoPago;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CompraDTO {

    @NotNull
    private MetodoPago metodoPago;

    @NotNull
    private List<CarritoDTO>carritoDTO;

    @Positive
    private int codigoUsuario;

}
