package co.edu.uniquindio.proyecto.DTO;

import co.edu.uniquindio.proyecto.Modelo.Categoria;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ProductoDTO {

    @NotNull
    @NotBlank
    @Length(max = 100, message = "El nombre debe de tener maximo 100 caracteres")
    private String nombre;

    @Column(nullable = false)
    @PositiveOrZero
    private int unidades;

    @Column(nullable = false)
    @PositiveOrZero
    private Double precio;

    @Column(nullable = false)
    @NotBlank
    private String descripcion;

    @Positive
    private Integer codigoVendedor;

    private Map<String,String>imagenes;

    @NotNull
    @NotBlank
    private Categoria categoria;

}
