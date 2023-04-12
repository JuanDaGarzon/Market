package co.edu.uniquindio.proyecto.Repocitorios;

import co.edu.uniquindio.proyecto.Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Esta clase contiene los llamados a mysql a modo de metodos
 */

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario,Integer> {
    @Query("select u from Usuario u where u.correo = :correo")
    Usuario buscarUsuario(String correo);

}
