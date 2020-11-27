package grupo3.adopcionPF.resources;

import grupo3.adopcionPF.DAO.MascotasDAO;
import grupo3.adopcionPF.DAO.PostulacionesDAO;
import grupo3.adopcionPF.DAO.UsuarioDAO;
import grupo3.adopcionPF.DTO.MascotasDTO;
import grupo3.adopcionPF.DTO.PostulacionesDTO;
import grupo3.adopcionPF.DTO.UsuarioDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class PostulacionesAPI {

    @RequestMapping(method = RequestMethod.POST,value = "/postulaciones")
    public void agregarPostulacion(@ModelAttribute PostulacionesDTO postulacion, @RequestPart MultipartFile imagen) throws SQLException, IOException {
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

    @RequestMapping(method = RequestMethod.PUT,value = "/postulaciones/{id}_estado={estado}_cuidador={cuidador}_postulante={postulante}")
    public void actualizarEstado(@PathVariable("id") int id, @PathVariable("estado") boolean estado,@PathVariable("cuidador") int idCuidador,@PathVariable("postulante") int idPostulante) throws SQLException, IOException, AddressException {
        new PostulacionesDAO().actualizarEstado(estado,id);
        if(estado==true){
            UsuarioDTO cuidador = new UsuarioDAO().obtenerUsuariosPorId(idCuidador);
            UsuarioDTO postulante = new UsuarioDAO().obtenerUsuariosPorId(idPostulante);
            PostulacionesDTO postulacion = new PostulacionesDAO().obtenerPostulacionPorId(id);
            MascotasDTO mascota = new MascotasDAO().obtenerMascotasPorId(postulacion.getMascota());
            new mailApi().enviarConGMail(new InternetAddress(cuidador.getEmail()),
                    "Has aceptado una solicitud de "+mascota.getNombre(),
                    "Hola "+cuidador.getNickname()+", recientemente aceptaste una solicitud de adopcion que realizo el usuario "+postulante.getNickname()+" para "+mascota.getNombre()+"\n"+
                            "   -Datos de "+postulante.getNickname()+"-\n" +
                            "- Nombre: "+postulante.getNombres()+":\n" +
                            "- Apellido: "+postulante.getApellidos()+":\n" +
                            "- Email: "+postulante.getEmail()+":\n" +
                            "- Fono: "+postulante.getFono()+":\n" +
                            "- Región: "+postulante.getRegion()+":\n" +
                            "- Comuna: "+postulante.getComuna()+":\n");
            new mailApi().enviarConGMail(new InternetAddress(postulante.getEmail()),
                    "Ha sido aceptada tu solicitud de "+mascota.getNombre(),
                    "Hola "+postulante.getNickname()+", recientemente "+cuidador.getNickname()+" ha aceptado la solicitud de adopcion que realizaste para "+mascota.getNombre()+"\n"+
                            "   -Datos de "+cuidador.getNickname()+"-\n" +
                            "- Nombre: "+cuidador.getNombres()+":\n" +
                            "- Apellido: "+cuidador.getApellidos()+":\n" +
                            "- Email: "+cuidador.getEmail()+":\n" +
                            "- Fono: "+cuidador.getFono()+":\n" +
                            "- Región: "+cuidador.getRegion()+":\n" +
                            "- Comuna: "+cuidador.getComuna()+":\n");
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/postulaciones/eliminar={id}")
    public void eliminarPostulacion(@PathVariable(name = "id") int id) throws SQLException {
        new PostulacionesDAO().eliminarFotoMascota(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/postulaciones/filtrada={usuario}")
    public List<PostulacionesDTO> obtenerListaPostulacionesFiltrada(@PathVariable(name = "usuario") int usuario) throws SQLException {
        return new PostulacionesDAO().obtenerListaPostulacionesFiltrada(usuario);
    }

}
