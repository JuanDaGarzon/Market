package co.edu.uniquindio.proyecto.Servicios.Interfaces;

import co.edu.uniquindio.proyecto.DTO.ProductoDTO;
import co.edu.uniquindio.proyecto.DTO.ProductoGetDTO;
import co.edu.uniquindio.proyecto.Servicios.Excepciones.ProductoNoEncontradoException;

public interface ProductoServicio {

    int crearProducto(ProductoDTO productoDTO) throws Exception;

    ProductoGetDTO actualizarProducto(int codigoProducto, ProductoDTO productoDTO) throws Exception;
    int eliminarProducto(int codigoProducto) throws ProductoNoEncontradoException;


}
