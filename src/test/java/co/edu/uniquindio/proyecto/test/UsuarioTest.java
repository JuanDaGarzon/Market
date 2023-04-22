package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.DTO.UsuarioDTO;
import co.edu.uniquindio.proyecto.DTO.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.Modelo.Ciudad;

import co.edu.uniquindio.proyecto.Modelo.Usuario;
import co.edu.uniquindio.proyecto.Repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;


@SpringBootTest
@Transactional

public class UsuarioTest {

        @Autowired
        private UsuarioServicio usuarioServicio;
        @Autowired
        private  UsuarioRepo usuarioRepo;


        @Test
        public void crearUsuarioTest() throws Exception{

            //Se crea el usuario con el servicio de crearUsuario
            UsuarioDTO usuarioDTO = new UsuarioDTO(

                    "Pepito 1",
                    "pepe1@email.com",
                    "1234",
                    "Calle 123",
                    "343",
                    Ciudad.BOGOTA);

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
                    Ciudad.BOGOTA);

            int codigo = usuarioServicio.crearUsuario(usuarioDTO);

            //Una vez creado, lo borramos
            int codigoBorrado = usuarioServicio.eliminiarUsuario(codigo);

            //Si intentamos buscar un usuario con el codigo del usuario borrado debemos obtener una excepción indicando que ya no existe
            Assertions.assertThrows(Exception.class, () -> usuarioServicio.obtenerUsuario(codigoBorrado));

        }
        /**
        @Test
        @Sql("classpath:dataset.sql")
        public void obtenerUsuarioTest()throws Exception{

            Optional<Usuario>buscado = usuarioRepo.findById(4);
            System.out.println(buscado.orElse(null));

        }
        */
        @Test
        @Sql("classpath:dataset.sql")
        public void actualizar() throws Exception {

            Usuario guardado = usuarioServicio.obtener(1);
            guardado.setCorreo("Ssandro@gmail.com");
            System.out.println(guardado);
            usuarioRepo.save(guardado);

            Assertions.assertEquals("Ssandro@gmail.com",guardado.getCorreo());
        }

        /**
        @Test
        @Sql("classpath:dataset.sql")
        public void listar(){
            List<UsuarioGetDTO> lista =usuarioRepo.findAll();
            System.out.println(lista);
        }
        */



}
