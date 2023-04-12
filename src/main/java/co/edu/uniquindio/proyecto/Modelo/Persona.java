package co.edu.uniquindio.proyecto.Modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.io.Serializable;
import java.util.List;
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@MappedSuperclass
public class Persona implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10)
    private int codigo;

    @Column(length = 80, nullable = false)
    private String nombre;

    @Email
    private String correo;

    @Column(unique = true,nullable = false)
    private String password;


}