package co.edu.uniquindio.proyecto.Servicios.Interfaces;

import co.edu.uniquindio.proyecto.DTO.UsuarioDTO;
import co.edu.uniquindio.proyecto.DTO.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.Modelo.Usuario;

import java.util.List;

public interface UsuarioServicio {

        int crearUsuario(UsuarioDTO usuarioDTO)  throws Exception;

        UsuarioGetDTO actualizarUsuario(int codigoUsuario, UsuarioDTO usuarioDTO) throws Exception;

        int eliminiarUsuario(int codigoUsuario) throws Exception;

        UsuarioGetDTO obtenerUsuario(int codigoUsuario) throws Exception;

        Usuario obtener(int codigoUsuario) throws Exception;

        List<UsuarioGetDTO> listarUsuariosDTO();

        Usuario login (String correo, String password) throws Exception;

}
