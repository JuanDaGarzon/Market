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
    int eliminarCompra(int codigoCompra);
    Compra obtenerCompra(int codigoCompra) ;
    List<CompraGetDTO>listarComprasGetDTO();
    List<CompraGetDTO> listarCompraPorMetodoPagoTajetaCredito(MetodoPago metodoPago);
    List<CompraGetDTO> listarCompraPorMetodoPagoTajetaDebito(MetodoPago metodoPago);
    List<CompraGetDTO> listarCompraPorMetodoPagoEfectivo(MetodoPago metodoPago);

}
