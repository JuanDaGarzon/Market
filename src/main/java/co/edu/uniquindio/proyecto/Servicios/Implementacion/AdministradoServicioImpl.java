package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.DTO.AdministradorDTO;
import co.edu.uniquindio.proyecto.DTO.TokenDTO;
import co.edu.uniquindio.proyecto.Modelo.Estado;
import co.edu.uniquindio.proyecto.Modelo.Producto;
import co.edu.uniquindio.proyecto.Repositorios.AdministradorRepo;
import co.edu.uniquindio.proyecto.Repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.AdministradorServicio;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdministradoServicioImpl implements AdministradorServicio {

    private final ProductoRepo productoRepo;
    private final AdministradorRepo administradorRepo;
    private final ProductoServicio productoServicio;

    @Override
    public TokenDTO iniciarSesion(AdministradorDTO administradorDTO) {

        return null;
    }

    @Override
    public Producto autorizarProducto(Producto producto, Estado estado) {
        return null;
    }

    @Override
    public Producto rechazarProducto(Producto producto, Estado estado) {

        return null;
    }
}
