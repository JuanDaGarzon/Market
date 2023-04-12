package co.edu.uniquindio.proyecto.Repocitorios;

import co.edu.uniquindio.proyecto.Modelo.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoRepo extends JpaRepository<Carrito,Integer> {
}
