package co.edu.uniquindio.proyecto.Controladores;


import co.edu.uniquindio.proyecto.DTO.MensajeDTO;
import co.edu.uniquindio.proyecto.DTO.ProductoAdminDTO;
import co.edu.uniquindio.proyecto.DTO.UsuarioDTO;
import co.edu.uniquindio.proyecto.Modelo.Estado;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.ProductoAdminServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/adminProducto")
@AllArgsConstructor
public class ControladorAdminProducto {

    private final ProductoAdminServicio productoAdminServicio;

    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> autorizar(@RequestBody ProductoAdminDTO productoAdminDTO) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, productoAdminServicio.autorizarProducto(productoAdminDTO)));
    }

    @PostMapping("/rechazar")
    public ResponseEntity<MensajeDTO> rechazar(@RequestBody ProductoAdminDTO productoAdminDTO) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, productoAdminServicio.rechazarProducto(productoAdminDTO)));
    }

    @GetMapping("/listarProductosSinRevisar/{estado}")
    public ResponseEntity<MensajeDTO> obtenerUsuario(@PathVariable Estado estado) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, productoAdminServicio.listarProductosSinRevisar(estado)));
    }

    @GetMapping("/listarProductosEstado/{estado}")
    public ResponseEntity<MensajeDTO> listarProductosEstado(@PathVariable Estado estado) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, productoAdminServicio.listarProductosEstado(estado)));
    }

}
