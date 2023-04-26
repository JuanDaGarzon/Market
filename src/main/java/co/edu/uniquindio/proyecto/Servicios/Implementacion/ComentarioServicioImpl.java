package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.DTO.ComentarioDTO;
import co.edu.uniquindio.proyecto.DTO.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.Modelo.Comentario;
import co.edu.uniquindio.proyecto.Repositorios.ComentarioRepo;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.ComentarioServicio;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.CompraServicio;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.ProductoServicio;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@AllArgsConstructor
public class ComentarioServicioImpl implements ComentarioServicio {

    private final ComentarioRepo comentarioRepo;
    private final UsuarioServicio usuarioServicio;
    private final ProductoServicio productoServicio;

    @Override
    public int crearComentario(ComentarioDTO comentarioDTO) throws Exception {

        Comentario comentario = new Comentario();

        comentario.setMensaje(comentarioDTO.getMensaje());
        comentario.setUsuario(usuarioServicio.obtener(comentarioDTO.getCodigoUsuario()));
        comentario.setProducto(productoServicio.obtener(comentarioDTO.getCodigoProducto()));
        comentario.setFechaCreacion(LocalDateTime.now());

        return comentario.getCodigo();

    }

    @Override
    public List<ComentarioGetDTO> listarComentario(int codigoProducto) {
        return null;
    }
}
