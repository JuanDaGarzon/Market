package co.edu.uniquindio.proyecto.Servicios.Interfaces;

import co.edu.uniquindio.proyecto.DTO.AdministradorDTO;
import co.edu.uniquindio.proyecto.DTO.ProductoAdminDTO;
import co.edu.uniquindio.proyecto.DTO.ProductoAdminGetDTO;
import co.edu.uniquindio.proyecto.DTO.ProductoGetDTO;
import co.edu.uniquindio.proyecto.Modelo.Administrador;
import co.edu.uniquindio.proyecto.Modelo.Estado;

import java.util.List;

public interface ProductoAdminServicio {

    ProductoAdminGetDTO autorizarProducto(ProductoAdminDTO productoAdminDTO) throws Exception;
    ProductoAdminGetDTO rechazarProducto(ProductoAdminDTO productoAdminDTO) throws Exception;
    List<ProductoGetDTO> listarProductosSinRevisar(Estado estado) throws Exception;
    List<ProductoGetDTO>listarProductosEstado(Estado estado) throws Exception;

}
