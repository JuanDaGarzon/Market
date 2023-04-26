package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.DTO.ComentarioDTO;
import co.edu.uniquindio.proyecto.DTO.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.DTO.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.Modelo.Comentario;
import co.edu.uniquindio.proyecto.Modelo.Usuario;
import co.edu.uniquindio.proyecto.Repositorios.ComentarioRepo;
import co.edu.uniquindio.proyecto.Servicios.Excepciones.NoSeHaEncontradoComentarioException;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.ComentarioServicio;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.CompraServicio;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.ProductoServicio;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    public ComentarioGetDTO obtenerComentario(int codigo) throws NoSeHaEncontradoComentarioException {
        Comentario comentario = comentarioRepo.findById(codigo).orElse(null);
        if (comentario==null){
            throw new NoSeHaEncontradoComentarioException("No se ha encontrado el comentario");
        }

        return convertir(comentario);
    }

    private ComentarioGetDTO convertir(Comentario comentario) {

        ComentarioGetDTO comentarioGetDTO = new ComentarioGetDTO(

                comentario.getCodigo(),
                comentario.getMensaje(),
                comentario.getFechaCreacion(),
                comentario.getProducto().getCodigo(),
                comentario.getUsuario().getCodigo()
        );
        return comentarioGetDTO;
    }

    @Override
    public List<ComentarioGetDTO> listarComentario() {
        List<Comentario>listaUsuarios = comentarioRepo.findAll();
        List<ComentarioGetDTO> lista = new ArrayList<>();
        for (Comentario c: listaUsuarios ){
            lista.add(convertir(c));
        }
        return lista;
    }


}
