package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.DTO.ProductoDTO;
import co.edu.uniquindio.proyecto.DTO.ProductoGetDTO;
import co.edu.uniquindio.proyecto.Modelo.Categoria;
import co.edu.uniquindio.proyecto.Modelo.Estado;
import co.edu.uniquindio.proyecto.Modelo.Producto;
import co.edu.uniquindio.proyecto.Modelo.Usuario;
import co.edu.uniquindio.proyecto.Repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.Repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.Servicios.Excepciones.ProductoNoEncontradoException;
import co.edu.uniquindio.proyecto.Servicios.Excepciones.UsuarioNoEncontradoException;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.ProductoServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@SpringBootTest
@Transactional
public class ProductoTest {

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private ProductoRepo productoRepo;

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void comprobarAutentificacion(){

        List<Producto> productos = productoRepo.findAll(PageRequest.of(2,2)).toList();
        productos.forEach(System.out::println);

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void paginadorEstadoProductoAceptados(){

        List<Producto> productos = productoRepo.findAllByEstado(Estado.ACEPTADO, PageRequest.of(0,2));
        productos.forEach(System.out::println);

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void paginadorEstadoProductoDenegados(){

        List<Producto> productos = productoRepo.findAllByEstado(Estado.DENEGADO, PageRequest.of(0,2));
        productos.forEach(System.out::println);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void paginadorEstadoProductoSinRevisar(){

        List<Producto> productos = productoRepo.findAllByEstado(Estado.SIN_REVISAR, PageRequest.of(0,2));
        productos.forEach(System.out::println);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void crearProducto() throws Exception {

        Usuario buscado = usuarioRepo.findById(1).orElse(null);

        if (buscado==null){
            throw new UsuarioNoEncontradoException("No se encontro un usuario con el codigo:"+buscado.getCodigo());
        }

        ProductoDTO productoDTO = new ProductoDTO(
                "Audifonos",
                30,
                34000.00,
                "Audifonos con servicio bluetooth",
                buscado.getCodigo(),
                Map.of("Id imagen","ruta"),
                Categoria.ELECTRODOMESTICO);

        int codigoProducto = productoServicio.crearProducto(productoDTO);
        Assertions.assertNotEquals(0, codigoProducto);

    }


    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarUnidadesProducto() throws ProductoNoEncontradoException {
        int nuevasUnidades = productoServicio.actualizarUnidades(1,3);

        System.out.println(nuevasUnidades);

        Producto producto = productoRepo.findById(1).orElse(null);

        System.out.println(producto);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarEstadoProducto() throws ProductoNoEncontradoException {

        Producto producto = productoRepo.findById(1).orElse(null);

        System.out.println(producto);

        int codigoProducto = productoServicio.actualizarEstado(1,Estado.DENEGADO);

        System.out.println(codigoProducto+" "+producto.getEstado());

        System.out.println(producto);

    }
}
