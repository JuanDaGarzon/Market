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

        validarCompra(compraDTO);
        List<Carrito>listaCarritos= new ArrayList<>();

        Compra compra = new Compra();
        compra.setCarritos();
        compra.setUsuario();
        compra.setFechaCeacion();
        compra.setMetodoPago();
        compra.setValorTotal();

        return 0;
    }

    @Override
    public List<CompraGetDTO> listarCompras(int codigoUsuario) {
        return null;
    }

    @Override
    public Compra obtenerCompra(int codigoCompra) throws NoSeHaEncontradoCompraException {
        Optional<Compra> compra = compraRepo.findById(codigoCompra);
        if (compra.isEmpty())
            throw new NoSeHaEncontradoCompraException("El codigo "+codigoCompra+" no esta asociado a ninguna compra");
        return compra.get();
    }


    }

