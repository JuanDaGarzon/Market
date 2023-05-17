package co.edu.uniquindio.proyecto.Controladores;

import co.edu.uniquindio.proyecto.DTO.MensajeDTO;
import co.edu.uniquindio.proyecto.DTO.SesionDTO;
import co.edu.uniquindio.proyecto.DTO.UsuarioDTO;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.SesionServicio;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sesion")
@AllArgsConstructor
public class ControladorSesionServicio {

    private final SesionServicio sesionServicio;
    private final UsuarioServicio usuarioServicio;

    @PostMapping("/sesion")
    public ResponseEntity<MensajeDTO> sesion(@RequestBody SesionDTO sesionDTO)  throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body( new MensajeDTO(HttpStatus.CREATED, false, sesionServicio.login(sesionDTO)) );
    }

    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearUsuario(@RequestBody UsuarioDTO usuarioDTO)  throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body( new MensajeDTO(HttpStatus.CREATED, false, usuarioServicio.crearUsuario(usuarioDTO)) );
    }

    @PutMapping("/cambioPassword/{correo}/{password}/{telefono}")
    public ResponseEntity<MensajeDTO> cambioPassword(@PathVariable String correo, @PathVariable String password, @PathVariable String telefono) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, sesionServicio.cambiarPassword(correo,password,telefono));
    }


}
