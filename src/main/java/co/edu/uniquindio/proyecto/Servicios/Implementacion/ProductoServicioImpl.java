package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.DTO.ProductoDTO;
import co.edu.uniquindio.proyecto.DTO.ProductoGetDTO;
import co.edu.uniquindio.proyecto.Modelo.Estado;
import co.edu.uniquindio.proyecto.Modelo.Producto;
import co.edu.uniquindio.proyecto.Modelo.Usuario;
import co.edu.uniquindio.proyecto.Repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.Servicios.Excepciones.ProductoNoEncontradoException;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.ProductoServicio;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ProductoServicioImpl implements ProductoServicio {

    //Instanciar el repocitorio
    private final ProductoRepo productoRepo;
    private final UsuarioServicio usuarioServicio;

    @Override
    public int crearProducto(ProductoDTO productoDTO) throws Exception {

        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setUnidades(productoDTO.getUnidades());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setUsuario(usuarioServicio.obtener(productoDTO.getCodigoVendedor()));
        producto.setCategoria(productoDTO.getCategoria());
        producto.setImagenes(productoDTO.getImagenes());
        producto.setEstado(Estado.DENEGADO);
        producto.setDescripcion(productoDTO.getDescripcion());

        //.plusDays le da el numero de dias que el producto va a estar activo
        producto.setFechaLimite(LocalDateTime.now().plusDays(60));
        producto.setFechaCreacion(LocalDateTime.now());

        return productoRepo.save(producto).getCodigo();

    }

    @Override
    public ProductoGetDTO actualizarProducto(int codigoProducto, ProductoDTO productoDTO) throws Exception {

        validarExiste(codigoProducto);

        Producto producto = convertir(productoDTO);
        producto.setCodigo(codigoProducto);

        return convertir(productoRepo.save(producto));

    }

    @Override
    public int eliminarProducto(int codigoProducto) throws ProductoNoEncontradoException {

        validarExiste(codigoProducto);

        productoRepo.deleteById(codigoProducto);

        return codigoProducto;

    }



    private ProductoGetDTO convertir(Producto producto){

        ProductoGetDTO productoDTO = new ProductoGetDTO(

                producto.getNombre(),
                producto.getUnidades(),
                producto.getPrecio(),
                producto.getDescripcion(),
                producto.getUsuario().getCodigo(),
                producto.getCategoria(),
                producto.getImagenes());

        return productoDTO;

    }


    private Producto convertir(ProductoDTO productoDTO) throws Exception {
        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setUnidades(productoDTO.getUnidades());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setUsuario(usuarioServicio.obtener(productoDTO.getCodigoVendedor()));
        producto.setCategoria(productoDTO.getCategoria());
        producto.setImagenes(productoDTO.getImagenes());

        return producto;

    }



    private void validarExiste(int codigoProducto) throws ProductoNoEncontradoException {
        boolean existe = productoRepo.existsById(codigoProducto);
        if(!existe){
            throw new ProductoNoEncontradoException("No se encontro el producto con el codigo"+codigoProducto);
        }
    }
}
