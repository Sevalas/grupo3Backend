package grupo3.adopcionPF.resources;

import grupo3.adopcionPF.DAO.FotosMascotasDAO;
import grupo3.adopcionPF.DAO.PostulacionesDAO;
import grupo3.adopcionPF.DTO.FotosMascotasDTO;
import grupo3.adopcionPF.DTO.PostulacionesDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PostulacionesAPI {

    @RequestMapping(method = RequestMethod.POST,value = "/postulaciones")
    public void AgregarPostulacion(@ModelAttribute PostulacionesDTO postulacion, @RequestPart MultipartFile imagen) throws SQLException, IOException {
        new PostulacionesDAO().agregarPostulacion(postulacion,new imgbbAPI().ImgToUrl(imagen));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/postulaciones")
    public List<PostulacionesDTO> obtenerListaPostulaciones() throws SQLException {
        return new PostulacionesDAO().obtenerListaFotoMascotas();
    }
}
