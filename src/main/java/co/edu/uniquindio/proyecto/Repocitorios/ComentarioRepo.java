package co.edu.uniquindio.proyecto.Repocitorios;

import ch.qos.logback.core.model.INamedModel;
import co.edu.uniquindio.proyecto.Modelo.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepo extends JpaRepository<Comentario, Integer> {
}
