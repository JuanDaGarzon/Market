package co.edu.uniquindio.proyecto.DTO;

import co.edu.uniquindio.proyecto.Modelo.MetodoPago;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CompraGetDTO {

    private int codigo;

    private int codigoUsuario;

    private List<CarritoDTO> carritoDTO;

    private List<MetodoPago> metodoPago;

    private LocalDateTime fechaCreacion;

    private Double valorTotal;


}
