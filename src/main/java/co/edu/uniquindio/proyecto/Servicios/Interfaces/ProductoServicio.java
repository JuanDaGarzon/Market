package co.edu.uniquindio.proyecto.Servicios.Interfaces;

import co.edu.uniquindio.proyecto.DTO.ProductoDTO;
import co.edu.uniquindio.proyecto.DTO.ProductoGetDTO;
import co.edu.uniquindio.proyecto.Modelo.Categoria;
import co.edu.uniquindio.proyecto.Modelo.Estado;
import co.edu.uniquindio.proyecto.Modelo.Producto;
import co.edu.uniquindio.proyecto.Servicios.Excepciones.AtributoException;
import co.edu.uniquindio.proyecto.Servicios.Excepciones.ProductoNoEncontradoException;

import java.util.List;

public interface ProductoServicio {

    int crearProducto(ProductoDTO productoDTO) throws Exception;

    ProductoGetDTO actualizarProducto(int codigoProducto, ProductoDTO productoDTO) throws Exception;
    ProductoGetDTO obtenerProducto(int codigoProducto) throws Exception;
    Producto obtener(int codigoProducto) throws AtributoException;
    int eliminarProducto(int codigoProducto) throws ProductoNoEncontradoException;
    int actualizarUnidades(int codigoProducto, int unidades ) throws ProductoNoEncontradoException;
    int actualizarEstado(int codigoProducto, Estado estado) throws ProductoNoEncontradoException;
    List<ProductoGetDTO>listarProductosUsuario(int codigoUsuario);
    List<ProductoGetDTO>listarProductosCategoriaVehiculo(Categoria categoria) throws Exception;
    List<ProductoGetDTO>listarProductosCategoriaElectrodomestico(Categoria categoria) throws Exception;
    List<ProductoGetDTO>listarProductosCategoriaInmueble(Categoria categoria) throws Exception;
    List<ProductoGetDTO>listarProductosCategoriaServicio(Categoria categoria) throws Exception;
    List<ProductoGetDTO>listarProductoEstadoAceptado(Estado estado);
    List<ProductoGetDTO>listarProductoEstadoDenegado(Estado estado);
    List<ProductoGetDTO>listarProductoEstadoSinRevisar(Estado estado);
    List<ProductoGetDTO>listarProductosNombre(String nombreProucto);
    List<ProductoGetDTO>listarProductosPrecio(double precioProducto);
    List<ProductoGetDTO>listarProductosFavoritos(int codigoUsuario );


}
