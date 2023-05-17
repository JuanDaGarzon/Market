package co.edu.uniquindio.proyecto.Controladores;

import co.edu.uniquindio.proyecto.DTO.MensajeDTO;
import co.edu.uniquindio.proyecto.DTO.ProductoDTO;
import co.edu.uniquindio.proyecto.Modelo.Categoria;
import co.edu.uniquindio.proyecto.Modelo.Estado;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/producto")
@AllArgsConstructor
public class ControladorProducto {

    private final ProductoServicio productoServicio;

    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crear( @RequestBody ProductoDTO productoDTO) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body( new MensajeDTO( HttpStatus.CREATED, false, productoServicio.crearProducto(productoDTO) ) );
    }

    @PostMapping("/agregarFavorito/{codigoProducto}/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> agregarFavorito( @PathVariable int codigoProducto, @PathVariable int codigoUsuario) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body( new MensajeDTO( HttpStatus.CREATED, false, productoServicio.agregarFavorito(codigoProducto,codigoUsuario) ) );
    }

    @PutMapping("actualizar/{codigoProducto}")
    public ResponseEntity<MensajeDTO> actualizarProducto(@PathVariable int codigoProducto, @RequestBody ProductoDTO productoDTO)throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.actualizarProducto(codigoProducto,productoDTO)));
    }

    @PutMapping("/actualizarUnidades/{codigoProducto}/{unidades}")
    public ResponseEntity<MensajeDTO>actualizarUnidades(@PathVariable int codigoProducto, @PathVariable int unidades)throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.actualizarUnidades(codigoProducto,unidades)));
    }

    @PutMapping("/actualizarEstado/{codigoProducto}/{estado}")
    public ResponseEntity<MensajeDTO>actualizarEstado(@PathVariable int codigoProducto, @PathVariable Estado estado)throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.actualizarEstado(codigoProducto,estado)));
    }

    @DeleteMapping("/eliminar/{codigoProducto}")
    public ResponseEntity<MensajeDTO> eliminarProducto(@PathVariable int codigoProducto)throws Exception{
        productoServicio.eliminarProducto(codigoProducto);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false,"Producto eliminado correctamente") );
    }

    @DeleteMapping("/eliminarFavorito/{codigoProducto}/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> eliminarFavorito(@PathVariable int codigoProducto, @PathVariable int codigoUsuario)throws Exception{
        productoServicio.eliminarFavorito(codigoProducto,codigoUsuario);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false,"Producto eliminado de favoritos correctamente") );
    }

    @GetMapping("/obtener/{codigoProducto}")
    public ResponseEntity<MensajeDTO>obtenerProducto(@PathVariable int codigoProducto)throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.obtenerProducto(codigoProducto)));
    }

    @GetMapping("/listarProductosUsuario/{codigoUsuario}")
    public ResponseEntity<MensajeDTO>listarProductosUsuario(@PathVariable int codigoUsuario)throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.listarProductosUsuario(codigoUsuario)));
    }

    @GetMapping("/listarProductosCategoriaVehiculo/{categoria}")
    public ResponseEntity<MensajeDTO>listarProductosCategoriaVehiculo(@PathVariable Categoria categoria)throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.listarProductosCategoriaVehiculo(categoria)));
    }

    @GetMapping("/listarProductosCategoriaElectrodomesticos/{categoria}")
    public ResponseEntity<MensajeDTO>listarProductosCategoriaElectrodomesticos(@PathVariable Categoria categoria)throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.listarProductosCategoriaVehiculo(categoria)));
    }
    @GetMapping("/listarProductosCategoriaInmueble/{categoria}")
    public ResponseEntity<MensajeDTO>listarProductosCategoriaInmueble(@PathVariable Categoria categoria)throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.listarProductosCategoriaVehiculo(categoria)));
    }

    @GetMapping("/listarProductosCategoriaServicio/{categoria}")
    public ResponseEntity<MensajeDTO>listarProductosCategoriaServicio(@PathVariable Categoria categoria)throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.listarProductosCategoriaVehiculo(categoria)));
    }

    @GetMapping("/listarProductosEstadoAceptado/{estado}")
    public ResponseEntity<MensajeDTO>listarProductosEstadoAceptado(@PathVariable Estado estado)throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.listarProductoEstadoAceptado(estado)));
    }

    @GetMapping("/listarProductosEstadoDenegado/{estado}")
    public ResponseEntity<MensajeDTO>listarProductosEstadoDenegado(@PathVariable Estado estado)throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.listarProductoEstadoAceptado(estado)));
    }

    @GetMapping("/listarProductosEstadoSinRevisar/{estado}")
    public ResponseEntity<MensajeDTO>listarProductosEstadoSinRevisar(@PathVariable Estado estado)throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.listarProductoEstadoAceptado(estado)));
    }

    @GetMapping("/listarProductosNombre/{nombreProducto}")
    public ResponseEntity<MensajeDTO>listarProductosNombre(@PathVariable String nombreProducto)throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.listarProductosNombre(nombreProducto)));
    }

    @GetMapping("/listarProductosPrecio/{precio}")
    public ResponseEntity<MensajeDTO>listarProductosPrecio(@PathVariable double precio)throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.listarProductosPrecio(precio)));
    }

    @GetMapping("/listarProductosFavoritos/{codigoUsuario}")
    public ResponseEntity<MensajeDTO>listarProductosFavoritos(@PathVariable int codigoUsuario)throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.listarProductosFavoritos(codigoUsuario)));
    }


}
