package co.edu.uniquindio.proyecto.Controladores;

import co.edu.uniquindio.proyecto.DTO.MensajeDTO;
import co.edu.uniquindio.proyecto.DTO.ProductoDTO;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/producto")
@AllArgsConstructor
public class ControladorProducto {

    private final ProductoServicio productoServicio;

    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crear( @RequestBody ProductoDTO productoDTO) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body( new MensajeDTO( HttpStatus.CREATED, false, productoServicio.crearProducto(productoDTO) ) );
    }


}
