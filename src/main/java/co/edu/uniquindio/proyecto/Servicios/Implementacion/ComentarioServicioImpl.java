package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.DTO.ComentarioDTO;
import co.edu.uniquindio.proyecto.DTO.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.DTO.CorreoDTO;
import co.edu.uniquindio.proyecto.DTO.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.Modelo.Comentario;
import co.edu.uniquindio.proyecto.Modelo.Producto;
import co.edu.uniquindio.proyecto.Modelo.Usuario;
import co.edu.uniquindio.proyecto.Repositorios.ComentarioRepo;
import co.edu.uniquindio.proyecto.Servicios.Excepciones.NoSeHaEncontradoComentarioException;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.*;
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
    private final CorreoServicio correoServicio;

    @Override
    public int crearComentario(ComentarioDTO comentarioDTO) throws Exception {

        Comentario comentario = new Comentario();
        Producto producto = productoServicio.obtener(comentarioDTO.getCodigoProducto());

        comentario.setMensaje(comentarioDTO.getMensaje());
        comentario.setUsuario(usuarioServicio.obtener(comentarioDTO.getCodigoUsuario()));
        comentario.setProducto(producto);
        comentario.setFechaCreacion(LocalDateTime.now());

        int codigo = comentarioRepo.save(comentario).getCodigo();

        correoServicio.enviarCorreo( new CorreoDTO(
                "Nuevo comentario",
                "El comentario del usuario es: "+comentarioDTO.getMensaje(),
                producto.getUsuario().getCorreo()
        ));

        return codigo;

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
