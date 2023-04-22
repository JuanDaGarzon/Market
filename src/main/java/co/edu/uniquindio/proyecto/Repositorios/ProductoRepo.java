package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.Modelo.Categoria;
import co.edu.uniquindio.proyecto.Modelo.Estado;
import co.edu.uniquindio.proyecto.Modelo.Producto;
import co.edu.uniquindio.proyecto.Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepo extends JpaRepository<Producto,Integer> {

    @Query("select p from Producto p where p.precio = :costo")
    Optional<Producto> findAllByPrecio(@Param("costo") Double costo);

    @Query("select p from  Producto p where p.categoria = :categoria")
    List<Producto> findAllByCategoria(@Param("categoria") Categoria categoria);

    @Query("select p from Producto  p where p.usuario = :usuario")
    List<Producto> findAllByUsuario(@Param("usuario") Usuario usuario);

    @Query("select p from Producto p where p.estado = :estado")
    List<Producto> findAllByEstado(@Param("estado") Estado estado);

    @Query("select p from Producto p where p.nombre= :nombre")
    List<Producto> findAllByNombre(@Param("nombre") String nombre);



}
