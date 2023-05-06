package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.DTO.CarritoDTO;
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
import co.edu.uniquindio.proyecto.Servicios.Interfaces.UsuarioServicio;
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

    private final ProductoServicio productoServicio;
    private final CompraRepo compraRepo;
    private final UsuarioServicio usuarioServicio;
    private final CarritoRepo carritoRepo;


    @Override
    public int crearCompra(CompraDTO compraDTO) throws Exception{

        //Se asignan los valores del DTO
        Compra compra = new Compra();
        compra.setUsuario( usuarioServicio.obtener( compraDTO.getCodigoUsuario() ) );
        compra.setMetodoPago( compraDTO.getMetodoPago() );
        compra.setFechaCeacion( LocalDateTime.now() );

        double valorTotal = 0;
        List<Carrito> lista = new ArrayList<>();

        //Se recorre la lista del carritoDTO para calcular el valor total de la compra y crear la lista de Carrito
        for(CarritoDTO item : compraDTO.getCarritoDTO()){
            valorTotal += item.getUnidades() * item.getPrecio();
            lista.add( new Carrito(item.getUnidades(), item.getPrecio(), productoServicio.obtener(item.getCodigoProducto())) );
        }

        //Una vez el ciclo acaba, se asigna en la compra el valor total y la lista del carrito
        compra.setCarritos(lista);
        compra.setValorTotal(valorTotal);

        //Se guarda la compra en la base de datos para asignarla a cada elemento del carrito
        Compra guardada = compraRepo.save(compra);

        //Se asigna la compra a cada elemento del carrito y se guarda cada elemento en la base de datos
        for(Carrito item: lista){
            item.setCompra( guardada );
            carritoRepo.save(item);
        }

        //retorna el código de la compra
        return guardada.getCodigo();
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
    public List<CompraGetDTO> listarComprasGetDTO(int codigoUsuario) {
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

