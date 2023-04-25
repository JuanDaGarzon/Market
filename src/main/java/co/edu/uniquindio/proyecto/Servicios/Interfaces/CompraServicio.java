package co.edu.uniquindio.proyecto.Servicios.Interfaces;

import co.edu.uniquindio.proyecto.DTO.CarritoGetDTO;
import co.edu.uniquindio.proyecto.DTO.CompraDTO;
import co.edu.uniquindio.proyecto.DTO.CompraGetDTO;
import co.edu.uniquindio.proyecto.Modelo.Compra;
import co.edu.uniquindio.proyecto.Modelo.MetodoPago;
import co.edu.uniquindio.proyecto.Servicios.Excepciones.NoSeHaEncontradoCompraException;

import java.util.List;

public interface CompraServicio {

    int crearCompra(CompraDTO compraDTO);
    CompraGetDTO listarCompras(int codigoUsuario);
    Compra obtenerCompra(int codigoCompra) throws NoSeHaEncontradoCompraException;
    List<CompraGetDTO>lisatrCompra();
    List<CompraGetDTO> listarCarritoMetodoPagoTajetaCredito(MetodoPago metodoPago);
    List<CompraGetDTO> listarCarritoMetodoPagoTajetaDebito(MetodoPago metodoPago);
    List<CompraGetDTO> listarCarritoMetodoPagoEfectivo(MetodoPago metodoPago);
}
