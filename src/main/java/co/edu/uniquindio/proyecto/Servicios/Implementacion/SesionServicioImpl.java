package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.DTO.CorreoDTO;
import co.edu.uniquindio.proyecto.DTO.SesionDTO;
import co.edu.uniquindio.proyecto.DTO.TokenDTO;
import co.edu.uniquindio.proyecto.Modelo.Usuario;
import co.edu.uniquindio.proyecto.Repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.CorreoServicio;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.SesionServicio;
import co.edu.uniquindio.proyecto.seguridad.modelo.UserDetailsImpl;
import co.edu.uniquindio.proyecto.seguridad.servicios.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SesionServicioImpl implements SesionServicio {

    @Autowired
    private final JwtService jwtService;
    @Autowired
    private final UsuarioRepo usuarioRepo;
    @Autowired
    private final AuthenticationManager authenticationManager;
    @Autowired
    private  final PasswordEncoder passwordEncoder;
    private final CorreoServicio correoServicio;
    @Override
    public TokenDTO login(SesionDTO sesionDTO) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        sesionDTO.getEmail(),
                        sesionDTO.getPassword())

        );
        UserDetails user = (UserDetailsImpl) authentication.getPrincipal();
        String jwtToken = jwtService.generateToken(user);

        return new TokenDTO(jwtToken);

    }

    @Override
    public void cambiarPassword(String correo, String password, String telefono) throws Exception {
        Usuario usuario = usuarioRepo.buscarUsuario(correo);
        if (usuario==null){
            throw new Exception("El correo ingresado no esta asociado a ningun usuario");
        }
        if (!usuario.getTelefono().equals(telefono)){
            throw new Exception("No se encontro a ningun usuario con el telefono ingrezado");
        }
        usuario.setPassword(passwordEncoder.encode(password));
        usuarioRepo.save(usuario);
        correoServicio.enviarCorreo(new CorreoDTO(
                "Cambio de contraseña",
                "Se ha cambiado la contraseña de forma correcta",
                correo
        ));

    }

    public void linkCambioPassword(String correo) throws Exception {
        Usuario usuario = usuarioRepo.buscarUsuario(correo);
        if (usuario==null){
            throw new Exception("No se ha encontrado el usuario con el correo que se ha ingrezado");
        }else{
            correoServicio.enviarCorreo(new CorreoDTO(
                    "Solicitud de cambio de contrraseña",
                    "Para el cambio de contraseña debe dar click al siguiente enlace",
                    correo
            ));
        }
    }


}
