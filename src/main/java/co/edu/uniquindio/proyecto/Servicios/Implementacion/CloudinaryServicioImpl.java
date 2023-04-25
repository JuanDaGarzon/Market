package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.Servicios.Interfaces.CloudinaryServicio;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class CloudinaryServicioImpl implements CloudinaryServicio {

    private final Cloudinary cloudinary;

    public CloudinaryServicioImpl(){
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dcabxchxb");
        config.put("api_key", "125593646187625");
        config.put("api_secret", "j4Y0a3zYLOrcu98WRKWc2sD7Yog");
        cloudinary = new Cloudinary(config);
    }

    @Override
    public Map subirImagen(File file, String carpeta) throws Exception{
        return cloudinary.uploader().upload(file, ObjectUtils.asMap("folder",
                String.format("uniquindio/proyecto/%s", carpeta)));
    }
    @Override
    public Map eliminarImagen(String idImagen) throws Exception{
        return cloudinary.uploader().destroy(idImagen, ObjectUtils.emptyMap());
    }
    @Override
    public File convertir(MultipartFile imagen) throws IOException {
        File file = File.createTempFile(imagen.getOriginalFilename(), null);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(imagen.getBytes());
        fos.close();
        return file;
    }
}
