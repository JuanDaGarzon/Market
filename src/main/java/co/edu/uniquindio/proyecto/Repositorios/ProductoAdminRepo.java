package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.DTO.ProductoAdminGetDTO;
import co.edu.uniquindio.proyecto.Modelo.Estado;
import co.edu.uniquindio.proyecto.Modelo.ProductoAdmin;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoAdminRepo extends JpaRepository<ProductoAdmin,Integer> {
    @Query("select p from ProductoAdmin p where p.estado = :estado")
    List<ProductoAdminGetDTO>listarProductosEstado(@Param("estado") Estado estado, Pageable pageable);

}
