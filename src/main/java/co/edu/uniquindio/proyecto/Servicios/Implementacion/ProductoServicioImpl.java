package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.DTO.ProductoDTO;
import co.edu.uniquindio.proyecto.DTO.ProductoGetDTO;
import co.edu.uniquindio.proyecto.Modelo.Categoria;
import co.edu.uniquindio.proyecto.Modelo.Estado;
import co.edu.uniquindio.proyecto.Modelo.Producto;
import co.edu.uniquindio.proyecto.Repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.Servicios.Excepciones.AtributoException;
import co.edu.uniquindio.proyecto.Servicios.Excepciones.ProductoNoEncontradoException;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.CloudinaryServicio;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.ProductoServicio;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoServicioImpl implements ProductoServicio {

    //Instanciar el repocitorio
    private final ProductoRepo productoRepo;
    private final UsuarioServicio usuarioServicio;
    private final CloudinaryServicio cloudinaryServicio;

    @Override
    public int crearProducto(ProductoDTO productoDTO) throws Exception {

        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setUnidades(productoDTO.getUnidades());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setUsuario(usuarioServicio.obtener(productoDTO.getCodigoVendedor()));
        producto.setCategoria(productoDTO.getCategoria());

        producto.setImagenes(productoDTO.getImagenes());

        producto.setEstado(Estado.SIN_REVISAR);
        producto.setDescripcion(productoDTO.getDescripcion());
        //.plusDays le da el numero de dias que el producto va a estar activo
        producto.setFechaLimite(LocalDateTime.now().plusDays(60));
        producto.setFechaCreacion(LocalDateTime.now());

        return productoRepo.save(producto).getCodigo();

    }

    @Override
    public ProductoGetDTO actualizarProducto(int codigoProducto, ProductoDTO productoDTO) throws Exception {

        validarExiste(codigoProducto);

        Producto producto = convertir(productoDTO);
        producto.setCodigo(codigoProducto);

        return convertir(productoRepo.save(producto));

    }

    @Override
    public ProductoGetDTO obtenerProducto(int codigoProducto) throws Exception {

        return convertir(obtener(codigoProducto));

    }

    public Producto obtener(int codigoProducto) throws AtributoException {

        Optional<Producto> producto =productoRepo.findById(codigoProducto);

        if (producto.isEmpty()){
            throw new AtributoException("El codigo "+codigoProducto+" no esta asociado a ningún producto");
        }

        return producto.get();

    }

    @Override
    public int eliminarProducto(int codigoProducto) throws ProductoNoEncontradoException {

        validarExiste(codigoProducto);

        productoRepo.deleteById(codigoProducto);

        return codigoProducto;

    }

    @Override
    public int actualizarUnidades(int codigoProducto, int unidades) throws ProductoNoEncontradoException {

        validarExiste(codigoProducto);
        Producto producto = productoRepo.findById(codigoProducto).orElse(null);
        producto.setUnidades(unidades);
        productoRepo.save(producto);
        return producto.getUnidades();

    }

    @Override
    public int actualizarEstado(int codigoProducto, Estado estado) throws ProductoNoEncontradoException {
        validarExiste(codigoProducto);
        Producto producto = productoRepo.findById(codigoProducto).orElse(null);
        producto.setEstado(estado);
        productoRepo.save(producto);
        return producto.getCodigo();
    }

    @Override
    public List<ProductoGetDTO> listarProductosUsuario(int codigoUsuario) {


        List<Producto>list = productoRepo.listarProductosUsuario(codigoUsuario);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for (Producto p:list){
            respuesta.add(convertir(p));
        }

        return respuesta;

    }

    @Override
    public List<ProductoGetDTO> listarProductosCategoriaVehiculo(Categoria categoria) throws Exception {

        List<Producto> lista =productoRepo.findAllByCategoria(Categoria.VEHICULO,PageRequest.of(0,2));
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p :lista){
            respuesta.add(convertir(p));
        }

        return respuesta ;

    }

    @Override
    public List<ProductoGetDTO> listarProductosCategoriaElectrodomestico(Categoria categoria) throws Exception {
        List<Producto> lista =productoRepo.findAllByCategoria(Categoria.ELECTRODOMESTICO,PageRequest.of(0,2));
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p :lista){
            respuesta.add(convertir(p));
        }

        return respuesta ;
    }

    @Override
    public List<ProductoGetDTO> listarProductosCategoriaInmueble(Categoria categoria) throws Exception {
        List<Producto> lista =productoRepo.findAllByCategoria(Categoria.INMUEBLE,PageRequest.of(0,2));
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p :lista){
            respuesta.add(convertir(p));
        }

        return respuesta ;
    }

    @Override
    public List<ProductoGetDTO> listarProductosCategoriaServicio(Categoria categoria) throws Exception {
        List<Producto> lista =productoRepo.findAllByCategoria(Categoria.SERVICIO,PageRequest.of(0,2));
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p :lista){
            respuesta.add(convertir(p));
        }

        return respuesta ;
    }

    @Override
    public List<ProductoGetDTO> listarProductoEstadoAceptado(Estado estado) {

        List<Producto> lista =productoRepo.findAllByEstado(Estado.ACEPTADO, PageRequest.of(0,3));
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p :lista){
            respuesta.add(convertir(p));
        }

        return respuesta ;

    }

    @Override
    public List<ProductoGetDTO> listarProductoEstadoDenegado(Estado estado) {
        List<Producto> lista =productoRepo.findAllByEstado(Estado.DENEGADO, PageRequest.of(0,3));
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p :lista){
            respuesta.add(convertir(p));
        }

        return respuesta ;
    }

    @Override
    public List<ProductoGetDTO> listarProductoEstadoSinRevisar(Estado estado) {
        List<Producto> lista =productoRepo.findAllByEstado(Estado.SIN_REVISAR, PageRequest.of(0,3));
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p :lista){
            respuesta.add(convertir(p));
        }

        return respuesta ;

    }

    @Override
    public List<ProductoGetDTO> listarProductosNombre(String nombreProucto) {
        List<Producto> lista =productoRepo.findAllByNombre(nombreProucto);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p :lista){
            respuesta.add(convertir(p));
        }

        return respuesta ;
    }

    @Override
    public List<ProductoGetDTO> listarProductosPrecio(double precioProducto) {

        List<Producto> lista =productoRepo.findAllByPrecio(precioProducto);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p :lista){
            respuesta.add(convertir(p));
        }

        return respuesta ;
    }

    @Override
    public List<ProductoGetDTO> listarProductosFavoritos(int codigoUsuario) {
        return null;
    }

    private ProductoGetDTO convertir(Producto producto){

        ProductoGetDTO productoDTO = new ProductoGetDTO(

                producto.getNombre(),
                producto.getUnidades(),
                producto.getPrecio(),
                producto.getDescripcion(),
                producto.getCodigo(),
                producto.getFechaLimite(),
                producto.getEstado(),
                producto.getUsuario().getCodigo(),
                producto.getCategoria(),
                producto.getImagenes(),
                producto.getUsuariosFavoritos());

        return productoDTO;

    }

    private Producto convertir(ProductoDTO productoDTO) throws Exception {

        Producto producto = new Producto();

        producto.setNombre(productoDTO.getNombre());
        producto.setUnidades(productoDTO.getUnidades());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setUsuario(usuarioServicio.obtener(productoDTO.getCodigoVendedor()));
        producto.setCategoria(productoDTO.getCategoria());
        producto.setImagenes(productoDTO.getImagenes());

        return producto;

    }

    private void validarExiste(int codigoProducto) throws ProductoNoEncontradoException {
        boolean existe = productoRepo.existsById(codigoProducto);
        if(!existe){
            throw new ProductoNoEncontradoException("No se encontro el producto con el codigo"+codigoProducto);
        }
    }



}
