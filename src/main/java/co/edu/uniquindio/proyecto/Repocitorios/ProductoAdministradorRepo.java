package co.edu.uniquindio.proyecto.Repocitorios;

import co.edu.uniquindio.proyecto.Modelo.ProductoAdministrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoAdministradorRepo extends JpaRepository<ProductoAdministrador,Integer> {

}
