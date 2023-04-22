package co.edu.uniquindio.proyecto.Servicios.Interfaces;

import co.edu.uniquindio.proyecto.DTO.SesionDTO;
import co.edu.uniquindio.proyecto.DTO.TokenDTO;

public interface SesionServicio {
    TokenDTO login(SesionDTO sesioDTO);
    void logout(int codigoUsuario);
}
