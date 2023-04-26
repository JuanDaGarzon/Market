package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.Modelo.Administrador;
import co.edu.uniquindio.proyecto.Repositorios.AdministradorRepo;
import co.edu.uniquindio.proyecto.Servicios.Excepciones.AutentificacionException;
import co.edu.uniquindio.proyecto.Servicios.Excepciones.NoSeHaEncontradoAdministradorException;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.AdministradorServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdministradoServicioImpl implements AdministradorServicio {


    private final AdministradorRepo administradorRepo;

    @Override
    public Administrador login(String correo, String password) throws AutentificacionException {

        Administrador admin = administradorRepo.comprobarAutenticacionAdmin(correo,password);
        if (admin == null){
            throw new AutentificacionException("Los datos de autentificacion son incorrectos");
        }
        return admin;

    }

    @Override
    public Administrador obtenerAdministrador(int codigo) throws NoSeHaEncontradoAdministradorException {
        Administrador administrador = validarAdministrador(codigo);
        return administrador;
    }

    private Administrador validarAdministrador(int codigo) throws NoSeHaEncontradoAdministradorException {
        Administrador administrador = administradorRepo.findById(codigo).orElse(null);
        if (administrador==null){
            throw new NoSeHaEncontradoAdministradorException("No se ha encontrado administrador con el codigo: "+codigo);
        }
        return administrador;
    }

}
