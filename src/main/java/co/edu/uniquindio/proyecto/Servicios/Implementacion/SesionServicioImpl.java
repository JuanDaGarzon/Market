package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.DTO.SesionDTO;
import co.edu.uniquindio.proyecto.DTO.TokenDTO;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.SesionServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SesionServicioImpl implements SesionServicio {
    @Override
    public TokenDTO login(SesionDTO sesioDTO) {
        return null;
    }

    @Override
    public void logout(int codigoUsuario) {

    }
}
