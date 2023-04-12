package co.edu.uniquindio.proyecto.Repocitorios;

import co.edu.uniquindio.proyecto.Modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepo extends JpaRepository<Persona,Integer> {
}
