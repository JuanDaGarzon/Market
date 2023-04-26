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
import org.springframework.data.domain.PageRequest;
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
            //Se intancia un DTO,
            UsuarioDTO usuarioDTO = new UsuarioDTO(

                    "Pepito",
                    "pepe@email.com",
                    "1234",
                    "Calle 123",
                    "3432521026",
                    Ciudad.BOGOTA);

            int codigo = usuarioServicio.crearUsuario(usuarioDTO);

            Assertions.assertNotEquals(0, codigo);

        }

        @Test
        @Sql("classpath:dataset.sql")
        public void eliminarUsuarioTest() throws Exception{
            Usuario buscado=usuarioRepo.findById(1).orElse(null);
            usuarioRepo.delete(buscado);
            Assertions.assertNull(usuarioRepo.findById(1).orElse(null));
            Assertions.assertThrows(Exception.class, () -> usuarioServicio.obtenerUsuario(1));

        }

        @Test
        @Sql("classpath:dataset.sql")
        public void obtenerUsuarioTest()throws Exception{

            Optional<Usuario>buscado = usuarioRepo.findById(4);
            System.out.println(buscado.orElse(null));

        }

        @Test
        @Sql("classpath:dataset.sql")
        public void actualizar() throws Exception {

            Usuario guardado = usuarioServicio.obtener(1);
            guardado.setCorreo("Ssandro@gmail.com");
            System.out.println(guardado);
            usuarioRepo.save(guardado);

            Assertions.assertEquals("Ssandro@gmail.com",guardado.getCorreo());
        }

        @Test
        @Sql("classpath:dataset.sql")
        public void listarUsuarios(){
            List<Usuario> listaUsuarios =usuarioRepo.findAll(PageRequest.of(0,5)).toList();
            listaUsuarios.forEach(System.out::println);
        }

        @Test
        @Sql("classpath:dataset.sql")
        public void comprobarAutentificacion(){

            Usuario usuario = usuarioRepo.comprobarAutenticacion("sandro@gmail.com","1234" );
            Assertions.assertNotNull(usuario);

        }



}
