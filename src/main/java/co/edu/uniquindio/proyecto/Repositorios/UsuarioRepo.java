package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Esta clase contiene los llamados a mysql a modo de metodos
 */

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario,Integer> {

    @Query("select u from Usuario u where u.correo = :correo")
    Usuario buscarUsuario(String correo);

    @Query("select u from Usuario u where u.correo = :correo and u.password = :password")
    Usuario comprobarAutenticacion(String correo, String password);
    @Query("select u from Usuario u where u.correo = :email")
    Optional<Usuario> findByEmail(String email);
}
