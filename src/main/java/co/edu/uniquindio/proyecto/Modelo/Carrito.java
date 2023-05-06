package co.edu.uniquindio.proyecto.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Carrito implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false)
    private int unidades;

    @Column(nullable = false)
    private double precioUnitario;

    @ManyToOne
    private Producto producto;

    @ManyToOne
    private Compra compra;

    public Carrito(int unidades, double precioUnitario, Producto producto) {
        this.unidades = unidades;
        this.precioUnitario = precioUnitario;
        this.producto = producto;
    }
}
