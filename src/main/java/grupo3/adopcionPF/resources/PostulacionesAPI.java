package grupo3.adopcionPF.resources;

import grupo3.adopcionPF.DAO.PostulacionesDAO;
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
        return new PostulacionesDAO().obtenerListaPostulaciones();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/postulaciones/id={id}")
    public PostulacionesDTO obtenerPostulacionPorId(@PathVariable(name = "id") int id) throws SQLException {
        return new PostulacionesDAO().obtenerPostulacionPorId(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/postulaciones/usuario={usuario}")
    public List<PostulacionesDTO> obtenerPostulacionPorUsuario(@PathVariable(name = "usuario") int usuario) throws SQLException {
        return new PostulacionesDAO().obtenerListaPorUsuario(usuario);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/postulaciones/mascota={mascota}")
    public List<PostulacionesDTO> obtenerPostulacionPorMascota(@PathVariable(name = "mascota") int mascota) throws SQLException {
        return new PostulacionesDAO().obtenerListaPorMascota(mascota);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/postulaciones/actualizar={id}")
    public void actualizarPostulacion(@PathVariable("id") int id, @ModelAttribute PostulacionesDTO postulacion, @RequestPart MultipartFile imagen) throws SQLException, IOException {
        new PostulacionesDAO().actualizarPostulacion(postulacion,new imgbbAPI().ImgToUrl(imagen),id);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/postulaciones/{id}_estado={estado}")
    public void actualizarEstado(@PathVariable("id") int id, @PathVariable("estado") boolean estado) throws SQLException, IOException {
        new PostulacionesDAO().actualizarEstado(estado,id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/postulaciones/eliminar={id}")
    public void eliminarPostulacion(@PathVariable(name = "id") int id) throws SQLException {
        new PostulacionesDAO().eliminarFotoMascota(id);
    }

}
