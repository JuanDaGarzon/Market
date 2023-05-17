package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.DTO.ProductoAdminDTO;
import co.edu.uniquindio.proyecto.DTO.ProductoAdminGetDTO;
import co.edu.uniquindio.proyecto.DTO.ProductoGetDTO;
import co.edu.uniquindio.proyecto.Modelo.Estado;
import co.edu.uniquindio.proyecto.Modelo.Producto;
import co.edu.uniquindio.proyecto.Modelo.ProductoAdmin;
import co.edu.uniquindio.proyecto.Repositorios.ProductoAdminRepo;
import co.edu.uniquindio.proyecto.Repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.AdministradorServicio;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.ProductoAdminServicio;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class ProductoAdminServicioImpl implements ProductoAdminServicio {

    private final ProductoAdminRepo productoAdminRepo;
    private final ProductoServicio productoServicio;
    private final AdministradorServicio administradorServicio;
    private final ProductoRepo productoRepo;

    @Override
    public ProductoAdminGetDTO autorizarProducto(ProductoAdminDTO productoAdminDTO) throws Exception {

        ProductoAdmin productoAdmin = new ProductoAdmin();

        productoAdmin.setMotivo(productoAdminDTO.getMotivo());
        productoAdmin.setFecha(LocalDateTime.now());
        productoAdmin.setEstado(Estado.ACEPTADO);
        productoAdmin.setAdministrador(administradorServicio.obtenerAdministrador(productoAdminDTO.getCodigoAdmin()));
        productoAdmin.setProducto(productoServicio.obtener(productoAdminDTO.getCodigoProducto()));

        productoAdminRepo.save(productoAdmin);
        productoServicio.actualizarEstado(productoAdminDTO.getCodigoProducto(), Estado.ACEPTADO);

        return convertir(productoAdmin);

    }

    @Override
    public ProductoAdminGetDTO rechazarProducto(ProductoAdminDTO productoAdminDTO) throws Exception {

        ProductoAdmin productoAdmin = new ProductoAdmin();

        productoAdmin.setMotivo(productoAdminDTO.getMotivo());
        productoAdmin.setFecha(LocalDateTime.now());
        productoAdmin.setEstado(Estado.DENEGADO);
        productoAdmin.setAdministrador(administradorServicio.obtenerAdministrador(productoAdminDTO.getCodigoAdmin()));
        productoAdmin.setProducto(productoServicio.obtener(productoAdminDTO.getCodigoProducto()));

        productoAdminRepo.save(productoAdmin);
        productoServicio.actualizarEstado(productoAdminDTO.getCodigoProducto(), Estado.DENEGADO);

        return convertir(productoAdmin);

    }

    private ProductoAdminGetDTO convertir(ProductoAdmin productoAdmin) {

        ProductoAdminGetDTO productoAdminGetDTO = new ProductoAdminGetDTO(

                productoAdmin.getCodigo(),
                productoAdmin.getMotivo(),
                productoAdmin.getMensaje(),
                productoAdmin.getFecha(),
                productoAdmin.getEstado(),
                productoAdmin.getProducto().getCodigo(),
                productoAdmin.getAdministrador().getCodigo()

        );

        return productoAdminGetDTO;

    }

    @Override
    public List<ProductoGetDTO> listarProductosSinRevisar(Estado estado) throws Exception {

        List<ProductoAdminGetDTO> lista = productoAdminRepo.listarProductosEstado(Estado.SIN_REVISAR,
                PageRequest.of(0,3));
        List<ProductoGetDTO> listaProductos = new ArrayList<>();

        for (ProductoAdminGetDTO p :lista) {
            listaProductos.add(encontrarProducto(p));
        }

        return listaProductos;

    }
    @Override
    public List<ProductoGetDTO> listarProductosEstado(Estado estado) throws Exception {

        List<ProductoAdminGetDTO> lista = productoAdminRepo.listarProductosEstado(estado,
                PageRequest.of(0,3));

        List<ProductoGetDTO> listaProductos = new ArrayList<>();

        for (ProductoAdminGetDTO p :lista) {
            listaProductos.add(encontrarProducto(p));
        }

        return listaProductos;

    }
    private ProductoGetDTO encontrarProducto(ProductoAdminGetDTO productoAdminGetDTO) throws Exception {

        ProductoGetDTO productoGetDTO = productoServicio.obtenerProducto(productoAdminGetDTO.getCodigoProducto());

        return productoGetDTO;

    }
}
