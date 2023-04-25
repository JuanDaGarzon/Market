package co.edu.uniquindio.proyecto.DTO;

import co.edu.uniquindio.proyecto.Modelo.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
@Getter
@Setter
@ToString
@AllArgsConstructor
public class CarritoGetDTO {

    private int codigo;

    private double precioUnitario;

    private int unidades;

    private int codigoProducto;

    private int codigoCompra;




}
