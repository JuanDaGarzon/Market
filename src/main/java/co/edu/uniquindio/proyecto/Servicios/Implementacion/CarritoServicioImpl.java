package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.DTO.CarritoDTO;
import co.edu.uniquindio.proyecto.DTO.CarritoGetDTO;
import co.edu.uniquindio.proyecto.DTO.ProductoGetDTO;
import co.edu.uniquindio.proyecto.Modelo.*;
import co.edu.uniquindio.proyecto.Repositorios.CarritoRepo;
import co.edu.uniquindio.proyecto.Servicios.Excepciones.AtributoException;
import co.edu.uniquindio.proyecto.Servicios.Excepciones.NoSeHaEncontradoCarritoException;
import co.edu.uniquindio.proyecto.Servicios.Excepciones.NoSeHaEncontradoCompraException;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.CarritoServicio;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.CompraServicio;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarritoServicioImpl implements CarritoServicio {


    private final CarritoRepo carritoRepo;
    private final ProductoServicio productoServicio;
    private final CompraServicio compraServicioa;

    @Override
    public int crearCarrito(CarritoDTO carritoDTO) throws Exception {

        Compra compra = new Compra();

        Carrito carrito = new Carrito();
        carrito.setUnidades(carritoDTO.getUnidades());
        carrito.setPrecioUnitario(carritoDTO.getPrecio());
        carrito.setProducto(productoServicio.obtener(carritoDTO.getCodigoProducto()));
        carrito.setCompra(compra);

        return carrito.getCodigo();
    }

    @Override
    public int eliminarCarrito(int codigoCarrito) throws NoSeHaEncontradoCarritoException {
        validarExiste(codigoCarrito);
        carritoRepo.deleteById(codigoCarrito);
        return codigoCarrito;
    }

    @Override
    public CarritoGetDTO actualizarCarrito(int codigoCarrito, CarritoDTO carritoDTO) throws AtributoException, NoSeHaEncontradoCarritoException {
        validarExiste(codigoCarrito);
        Carrito carrito = convertir(carritoDTO);
        carrito.setCodigo(codigoCarrito);
        return convertir(carritoRepo.save(carrito));
    }

    private Carrito convertir(CarritoDTO carritoDTO) throws AtributoException {

        Carrito carrito = new Carrito();
        Compra compra = new Compra();
        carrito.setUnidades(carritoDTO.getUnidades());
        carrito.setPrecioUnitario(carritoDTO.getPrecio());
        carrito.setProducto(productoServicio.obtener(carritoDTO.getCodigoProducto()));
        carrito.setCompra(compra);

        return carrito;

    }

    private CarritoGetDTO convertir(Carrito carrito) {
        CarritoGetDTO carritoGetDTO = new CarritoGetDTO(
                carrito.getCodigo(),
                carrito.getPrecioUnitario(),
                carrito.getUnidades(),
                carrito.getProducto().getCodigo(),
                carrito.getCompra().getCodigo()
        );
        return carritoGetDTO;
    }

    private void validarExiste(int codigoCarrito) throws NoSeHaEncontradoCarritoException {
        boolean existe = carritoRepo.existsById(codigoCarrito);
        if (!existe) {
            throw new NoSeHaEncontradoCarritoException("No se ha encontrado ningun carrito con el codigo: "+codigoCarrito);
        }
    }

    @Override
    public CarritoGetDTO obetenerCarrito(int codigoCarrito) throws NoSeHaEncontradoCompraException {

        return convertir(obtener(codigoCarrito));

    }

    private Carrito obtener(int codigoCarrito) throws NoSeHaEncontradoCompraException {
        Optional<Carrito>carrito = carritoRepo.findById(codigoCarrito);
        if (carrito.isEmpty()){
            throw new NoSeHaEncontradoCompraException("No se ha encontrado un carrito con el codigo: "+codigoCarrito);
        }
        return carrito.get();
    }

    @Override
    public List<CarritoGetDTO> listarCarrtito() {

        List<Carrito> lista =carritoRepo.findAll();
        List<CarritoGetDTO> respuesta = new ArrayList<>();

        for(Carrito c :lista){
            respuesta.add(convertir(c));
        }

        return respuesta ;
    }

    @Override
    public CarritoGetDTO añadirProducto(int codigoProducto, int codigoCarrito) throws Exception {
        validarExiste(codigoCarrito);
        productoServicio.obtenerProducto(codigoProducto);
        CarritoGetDTO carritoGetDTO = convertir(obtener(codigoCarrito));
        carritoGetDTO.setCodigoProducto(codigoProducto);


        return carritoGetDTO;
    }
}
