package co.edu.uniquindio.proyecto.Servicios.Interfaces;

import co.edu.uniquindio.proyecto.DTO.CorreoDTO;

public interface CorreoServicio {

    void enviarCorreo(CorreoDTO correoDTO)throws Exception;

}
