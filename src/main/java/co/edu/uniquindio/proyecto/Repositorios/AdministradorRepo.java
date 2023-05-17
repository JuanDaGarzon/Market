package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.Modelo.Administrador;
import co.edu.uniquindio.proyecto.Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministradorRepo extends JpaRepository<Administrador,Integer> {

    @Query("select a from Administrador a where a.correo = :correo")
    Administrador buscarAdmin(String correo);

    @Query("select a from Administrador a where a.correo = :correo and a.password = :password")
    Administrador comprobarAutenticacionAdmin(String correo, String password);
    @Query("select a from Administrador a where a.correo = :email")
    Optional<Administrador> findByEmail(String email);
}
