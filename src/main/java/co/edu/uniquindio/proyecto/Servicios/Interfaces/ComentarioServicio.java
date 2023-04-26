package co.edu.uniquindio.proyecto.Servicios.Interfaces;

import co.edu.uniquindio.proyecto.DTO.ComentarioDTO;
import co.edu.uniquindio.proyecto.DTO.ComentarioGetDTO;

import java.util.List;

public interface ComentarioServicio {

    int crearComentario(ComentarioDTO comentarioDTO) throws Exception;



    List<ComentarioGetDTO> listarComentario(int codigoProducto);

}
