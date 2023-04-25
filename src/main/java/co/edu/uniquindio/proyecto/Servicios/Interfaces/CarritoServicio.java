package co.edu.uniquindio.proyecto.Servicios.Interfaces;

import co.edu.uniquindio.proyecto.DTO.CarritoDTO;
import co.edu.uniquindio.proyecto.DTO.CarritoGetDTO;
import co.edu.uniquindio.proyecto.Modelo.Carrito;
import co.edu.uniquindio.proyecto.Modelo.MetodoPago;
import co.edu.uniquindio.proyecto.Modelo.Producto;
import co.edu.uniquindio.proyecto.Servicios.Excepciones.AtributoException;
import co.edu.uniquindio.proyecto.Servicios.Excepciones.NoSeHaEncontradoCarritoException;
import co.edu.uniquindio.proyecto.Servicios.Excepciones.NoSeHaEncontradoCompraException;

import java.util.List;

public interface CarritoServicio {

    int crearCarrito(CarritoDTO carritoDTO) throws Exception;
    int eliminarCarrito(int codigoCarrito) throws NoSeHaEncontradoCarritoException;
    CarritoGetDTO actualizarCarrito(int codigoCarrito, CarritoDTO carritoDTO) throws AtributoException, NoSeHaEncontradoCarritoException;
    CarritoGetDTO obetenerCarrito(int codigoCarrito) throws NoSeHaEncontradoCompraException;

    List<CarritoGetDTO> listarCarrtito();
    CarritoGetDTO añadirProducto(int codigoProducto,int codigoCarrito) throws Exception;

}
