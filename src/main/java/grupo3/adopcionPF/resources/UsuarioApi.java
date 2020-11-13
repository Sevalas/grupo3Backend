package grupo3.adopcionPF.resources;

import grupo3.adopcionPF.DAO.UsuarioDAO;
import grupo3.adopcionPF.DTO.UsuarioDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")

public class UsuarioApi{

    @RequestMapping(method = RequestMethod.POST,value = "/usuarios")
    public void AgregarUsuario(@ModelAttribute UsuarioDTO usuario, @RequestPart MultipartFile imagen) throws SQLException, IOException {
        new UsuarioDAO().agregarUsuario(usuario,new imgbbAPI().ImgToUrl(imagen));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/usuarios")
    public List<UsuarioDTO> obtenerListaUsuarios() throws SQLException {
        return new UsuarioDAO().obtenerListaUsuarios();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/usuarios/id={id}")
    public UsuarioDTO obtenerUsuariosPorId(@PathVariable(name = "id") int id) throws SQLException {
        return new UsuarioDAO().obtenerUsuariosPorId(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/usuarios/nickname={nickname}")
    public UsuarioDTO obtenerUsuariosPorNickname(@PathVariable(name = "nickname") String nickname) throws SQLException {
        return new UsuarioDAO().obtenerUsuariosPorNickname(nickname);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/usuarios/actualizar={id}")
    public void actualizarUsuario(@PathVariable("id") int id, @ModelAttribute UsuarioDTO usuario, @RequestPart MultipartFile imagen) throws SQLException, IOException {
        new UsuarioDAO().actualizarUsuario(usuario,new imgbbAPI().ImgToUrl(imagen),id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/usuarios/eliminar={id}")
    public void eliminarUsuario(@PathVariable(name = "id") int id) throws SQLException {
        new UsuarioDAO().eliminarUsuario(id);
    }

}