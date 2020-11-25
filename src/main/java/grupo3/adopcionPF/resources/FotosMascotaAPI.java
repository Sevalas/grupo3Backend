package grupo3.adopcionPF.resources;

import grupo3.adopcionPF.DAO.FotosMascotasDAO;
import grupo3.adopcionPF.DTO.FotosMascotasDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class FotosMascotaAPI {

    @RequestMapping(method = RequestMethod.POST,value = "/fotos_mascota")
    public void agregarFotoMascota(@ModelAttribute FotosMascotasDTO fotoMascota, @RequestPart MultipartFile imagen) throws SQLException, IOException {
        new FotosMascotasDAO().agregarFotosMascotas(fotoMascota,new imgbbAPI().ImgToUrl(imagen));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/fotos_mascota")
    public List<FotosMascotasDTO> obtenerListaFotoMascota() throws SQLException {
        return new FotosMascotasDAO().obtenerListaFotoMascotas();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/fotos_mascota/id={id}")
    public FotosMascotasDTO obtenerFotoMascotaPorId(@PathVariable(name = "id") int id) throws SQLException {
        return new FotosMascotasDAO().obtenerFotoMascotaPorId(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/fotos_mascota/mascota={mascota}")
    public List<FotosMascotasDTO> obtenerListaFotoMascotaPorMascota(@PathVariable(name = "mascota") int mascota) throws SQLException {
        return new FotosMascotasDAO().obtenerListaPorMascota(mascota);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/fotos_mascota/actualizar={id}")
    public void actualizarFotoMascota(@PathVariable("id") int id, @RequestPart MultipartFile imagen) throws SQLException, IOException {
        new FotosMascotasDAO().actualizarFotoMascota(id,new imgbbAPI().ImgToUrl(imagen));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/fotos_mascota/eliminar={id}")
    public void eliminarFotoMascota(@PathVariable(name = "id") int id) throws SQLException {
        new FotosMascotasDAO().eliminarFotoMascota(id);
    }

}
