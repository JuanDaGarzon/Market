package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.DTO.ComentarioDTO;
import co.edu.uniquindio.proyecto.DTO.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.ComentarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ComentarioServicioImpl implements ComentarioServicio {

    @Override
    public int crearComentario(ComentarioDTO comentarioDTO) {


        return 0;
    }

    @Override
    public List<ComentarioGetDTO> listarComentario(int codigoProducto) {
        return null;
    }
}
