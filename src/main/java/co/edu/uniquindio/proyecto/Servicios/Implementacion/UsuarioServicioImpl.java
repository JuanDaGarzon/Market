package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.DTO.UsuarioDTO;
import co.edu.uniquindio.proyecto.DTO.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.Modelo.Usuario;
import co.edu.uniquindio.proyecto.Repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.Servicios.Excepciones.AtributoException;
import co.edu.uniquindio.proyecto.Servicios.Excepciones.AutentificacionException;
import co.edu.uniquindio.proyecto.Servicios.Excepciones.UsuarioNoEncontradoException;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor

public class UsuarioServicioImpl implements UsuarioServicio {

    //Instanciar Repositorio
    @Autowired
    private final UsuarioRepo usuarioRepo;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Override
    public int crearUsuario(UsuarioDTO usuarioDTO) throws Exception {

        Usuario buscado = usuarioRepo.buscarUsuario(usuarioDTO.getCorreo());

        if (buscado!=null){
            throw new AtributoException("El correo"+usuarioDTO.getCorreo()+"ya esta en uso");
        }

        Usuario usuario = convertir(usuarioDTO);

        return usuarioRepo.save(usuario).getCodigo();

    }

    @Override
    public UsuarioGetDTO actualizarUsuario(int codigoUsuario, UsuarioDTO usuarioDTO) throws Exception {

        validarExiste(codigoUsuario);

        Usuario usuario = convertir(usuarioDTO);
        usuario.setCodigo(codigoUsuario);

        return convertir(usuarioRepo.save(usuario));

    }

    @Override
    public int eliminiarUsuario(int codigoUsuario) throws Exception {

        //Validar que exista el usuario
        validarExiste(codigoUsuario);

        usuarioRepo.deleteById(codigoUsuario);
        return codigoUsuario;

    }

    @Override
    public UsuarioGetDTO obtenerUsuario(int codigoUsuario) throws Exception {

        return convertir(obtener(codigoUsuario));

    }

    @Override
    public Usuario obtener(int codigoUsuario) throws Exception {

        Optional<Usuario> usuario = usuarioRepo.findById(codigoUsuario);

        if (usuario.isEmpty()){
            throw new AtributoException("El codigo "+codigoUsuario+" no esta asociado a ningún usuario");
        }

        return usuario.get();

    }

    private void validarExiste(int codigoUsuario)throws Exception{

        boolean existe = usuarioRepo.existsById(codigoUsuario);

        if (!existe){
            throw new UsuarioNoEncontradoException("El codigo "+codigoUsuario+" no esta asociado a ningún usuario");
        }

    }

    private Usuario convertir(UsuarioDTO usuarioDTO) {

        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setCiudad(usuarioDTO.getCiudad());
        usuario.setCorreo(usuarioDTO.getCorreo());
        usuario.setPassword(passwordEncoder.encode(usuarioDTO.getPassword()));
        usuario.setTelefono(usuarioDTO.getTelefono());
        usuario.setDireccion(usuarioDTO.getDireccion());

        return usuario;
    }

    private UsuarioGetDTO convertir(Usuario usuario){

        UsuarioGetDTO usuarioGetDTO = new UsuarioGetDTO(

                usuario.getCodigo(),
                usuario.getNombre(),
                usuario.getCorreo(),
                usuario.getDireccion(),
                usuario.getTelefono(),
                usuario.getCiudad(),
                usuario.getPassword());

        return usuarioGetDTO;

    }

    @Override
    public List<UsuarioGetDTO> listarUsuariosDTO() {

        List<Usuario>listaUsuarios = usuarioRepo.findAll();
        List<UsuarioGetDTO> lista = new ArrayList<>();
        for (Usuario u: listaUsuarios ){
            lista.add(convertir(u));
        }
        return lista;

    }

    @Override
    public Usuario login(String correo, String password) throws Exception {

        Usuario usuario = usuarioRepo.comprobarAutenticacion(correo,password);

        if (usuario == null){
            throw new AutentificacionException("Los datos de autentificacion son incorrectos");
        }

        return usuario;

    }


}
