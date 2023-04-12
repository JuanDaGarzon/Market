package co.edu.uniquindio.proyecto.Repocitorios;

import co.edu.uniquindio.proyecto.Modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepo extends JpaRepository<Producto,Integer> {
}
