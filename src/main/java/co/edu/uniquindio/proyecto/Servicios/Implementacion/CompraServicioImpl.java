package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.DTO.CompraDTO;
import co.edu.uniquindio.proyecto.DTO.CompraGetDTO;
import co.edu.uniquindio.proyecto.Modelo.Carrito;
import co.edu.uniquindio.proyecto.Modelo.Compra;
import co.edu.uniquindio.proyecto.Modelo.MetodoPago;
import co.edu.uniquindio.proyecto.Modelo.Producto;
import co.edu.uniquindio.proyecto.Repositorios.CarritoRepo;
import co.edu.uniquindio.proyecto.Repositorios.CompraRepo;
import co.edu.uniquindio.proyecto.Servicios.Excepciones.NoSeHaEncontradoCompraException;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.CarritoServicio;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.CompraServicio;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompraServicioImpl implements CompraServicio {

    private final CarritoServicio carritoServicio;
    private final ProductoServicio productoServicio;
    private final CompraRepo compraRepo;


    @Override
    public int crearCompra(CompraDTO compraDTO) {
        return 0;
    }

    @Override
    public int eliminarCompra(int codigoCompra) {
        return 0;
    }

    @Override
    public Compra obtenerCompra(int codigoCompra) {
        return null;
    }

    @Override
    public List<CompraGetDTO> listarComprasGetDTO() {
        return null;
    }

    @Override
    public List<CompraGetDTO> listarCompraPorMetodoPagoTajetaCredito(MetodoPago metodoPago) {
        return null;
    }

    @Override
    public List<CompraGetDTO> listarCompraPorMetodoPagoTajetaDebito(MetodoPago metodoPago) {
        return null;
    }

    @Override
    public List<CompraGetDTO> listarCompraPorMetodoPagoEfectivo(MetodoPago metodoPago) {
        return null;
    }
}

