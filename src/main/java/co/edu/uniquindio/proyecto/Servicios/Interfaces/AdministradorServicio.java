package co.edu.uniquindio.proyecto.Servicios.Interfaces;

import co.edu.uniquindio.proyecto.DTO.AdministradorDTO;
import co.edu.uniquindio.proyecto.DTO.TokenDTO;
import co.edu.uniquindio.proyecto.Modelo.Estado;
import co.edu.uniquindio.proyecto.Modelo.Producto;

public interface AdministradorServicio {

    TokenDTO iniciarSesion(AdministradorDTO administradorDTO);
    Producto autorizarProducto(Producto producto, Estado estado );
    Producto rechazarProducto(Producto producto, Estado estado);

}
