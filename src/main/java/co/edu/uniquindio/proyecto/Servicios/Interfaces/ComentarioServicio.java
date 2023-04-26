package co.edu.uniquindio.proyecto.Servicios.Interfaces;

import co.edu.uniquindio.proyecto.DTO.ComentarioDTO;
import co.edu.uniquindio.proyecto.DTO.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.Servicios.Excepciones.NoSeHaEncontradoComentarioException;

import java.util.List;

public interface ComentarioServicio {

    int crearComentario(ComentarioDTO comentarioDTO) throws Exception;

    ComentarioGetDTO obtenerComentario(int codigo) throws NoSeHaEncontradoComentarioException;

    List<ComentarioGetDTO> listarComentario();

}
