package co.edu.uniquindio.proyecto.Servicios.Implementacion;

import co.edu.uniquindio.proyecto.DTO.CorreoDTO;
import co.edu.uniquindio.proyecto.Servicios.Interfaces.CorreoServicio;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CorreoServicioImpl implements CorreoServicio {

    private final JavaMailSender javaMailSender;
    @Override
    public void enviarCorreo(CorreoDTO correoDTO) throws MessagingException {
        MimeMessage mensaje = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensaje);

        helper.setSubject(correoDTO.getAsunto());
        helper.setText(correoDTO.getCuerpo(), true);
        helper.setTo(correoDTO.getDestinatario());
        helper.setFrom("no_reply@dominio.com");
        javaMailSender.send(mensaje);

    }
}



