package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.DTO.UsuarioDTO;
import co.edu.uniquindio.proyecto.DTO.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.Modelo.Ciudad;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class UsuarioTest {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    public void crearUsuarioTest() throws Exception{

        //Se crea el usuario con el servicio de crearUsuario
        UsuarioDTO usuarioDTO = new UsuarioDTO( "pedro","pedro@email.com","123","calle 41"
                ,"3170902910", Ciudad.ARMENIA );

        int codigo = usuarioServicio.crearUsuario(usuarioDTO);

        //Se espera que si se registra correctamente entonces el servicio no debe retornar 0
        Assertions.assertNotEquals(0, codigo);

    }

    @Test
    public void eliminarUsuarioTest() throws Exception{

        //Para eliminar el usuario primero se debe crear
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "Pepito 1",
                "pepe1@email.com",
                "1234",
                "Calle 123",
                "343",
                Ciudad.ARMENIA);

        int codigo = usuarioServicio.crearUsuario(usuarioDTO);

        //Una vez creado, lo borramos
        int codigoBorrado = usuarioServicio.eliminiarUsuario(codigo);

        //Si intentamos buscar un usuario con el codigo del usuario borrado debemos obtener una excepción indicando que
        // ya no existe
        Assertions.assertThrows(Exception.class, () -> usuarioServicio.obtenerUsuario(codigoBorrado));

    }

    @Test
    public void actualizarUsuarioTest() throws Exception{

        //Para actualizar el usuario primero se debe crear
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "Pepito 1",
                "pepe1@email.com",
                "1234",
                "Calle 123",
                "343",
                Ciudad.ARMENIA);

        int codigoNuevo = usuarioServicio.crearUsuario(usuarioDTO);

        //El servicio de actualizar nos retorna el usuario
        UsuarioGetDTO usuarioActualizado = usuarioServicio.actualizarUsuario(codigoNuevo, new UsuarioDTO("Pepito Perez",
                "pepe1@email.com", "1234", "Calle 123", "1111", Ciudad.ARMENIA));

        //Se comprueba que ahora el teléfono del usuario no es el que se usó cuando se creó inicialmente
        Assertions.assertNotEquals("2782", usuarioActualizado.getTelefono());

    }

    @Test
    public void obtenerUsuarioTest()throws Exception{

        //Para obtener el usuario primero se debe crear
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "Pepito 1",
                "pepe1@email.com",
                "1234",
                "Calle 123",
                "343",
                Ciudad.ARMENIA);

        int codigoNuevo = usuarioServicio.crearUsuario(usuarioDTO);

        //Se llama el servicio para obtener el usuario completo dado su código
        UsuarioGetDTO usuarioGetDTO = usuarioServicio.obtenerUsuario(codigoNuevo);

        //Comprobamos que la dirección que está en la base de datos coincide con la que esperamos
        Assertions.assertEquals("Calle 123", usuarioGetDTO.getDireccion());

    }

}