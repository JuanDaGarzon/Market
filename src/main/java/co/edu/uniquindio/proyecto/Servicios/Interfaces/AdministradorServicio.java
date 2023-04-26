package co.edu.uniquindio.proyecto.Servicios.Interfaces;

import co.edu.uniquindio.proyecto.DTO.AdministradorDTO;
import co.edu.uniquindio.proyecto.DTO.ProductoGetDTO;
import co.edu.uniquindio.proyecto.DTO.TokenDTO;
import co.edu.uniquindio.proyecto.Modelo.Administrador;
import co.edu.uniquindio.proyecto.Modelo.Estado;
import co.edu.uniquindio.proyecto.Modelo.Producto;
import co.edu.uniquindio.proyecto.Servicios.Excepciones.AutentificacionException;
import co.edu.uniquindio.proyecto.Servicios.Excepciones.NoSeHaEncontradoAdministradorException;

public interface AdministradorServicio {

    Administrador login (String correo, String password) throws AutentificacionException;
    Administrador obtenerAdministrador (int codigo) throws NoSeHaEncontradoAdministradorException;

}
