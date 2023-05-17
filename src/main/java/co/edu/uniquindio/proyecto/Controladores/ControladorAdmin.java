package co.edu.uniquindio.proyecto.Controladores;

import co.edu.uniquindio.proyecto.DTO.MensajeDTO;
import co.edu.uniquindio.proyecto.Modelo.Administrador;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.AdministradorServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/administrador")
@AllArgsConstructor
public class ControladorAdmin {

    private final AdministradorServicio administradorServicio;

    @GetMapping("/obtenerAdmin/{codigoAdmin}")
    public ResponseEntity<MensajeDTO> obtenerAdmin(@PathVariable int codigoAdmin)throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, administradorServicio.obtenerAdministrador(codigoAdmin)));
    }



}
