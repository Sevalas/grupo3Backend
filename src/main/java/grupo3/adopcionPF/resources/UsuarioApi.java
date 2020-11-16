package grupo3.adopcionPF.resources;

import grupo3.adopcionPF.DAO.UsuarioDAO;
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

public class UsuarioApi {
    public UsuarioApi() {
    }

    @RequestMapping(method = RequestMethod.POST, value = "/usuarios")
    public String agregarUsuario(@ModelAttribute UsuarioDTO usuario, @RequestPart MultipartFile imagen) throws SQLException, IOException, AddressException {
        timeOutControl.timeOutControl();
        if (new UsuarioDAO().obtenerUsuariosPorNickname(usuario.getNickname()) == null) {
            if (new UsuarioDAO().obtenerUsuariosPorEmail(usuario.getEmail()) == null) {
                new UsuarioDAO().agregarUsuario(usuario, new imgbbAPI().ImgToUrl(imagen));
                new mailApi().enviarConGMail(new InternetAddress(usuario.getEmail()), "Bienvenido a PetAdopt", "Hola " + usuario.getNickname() + " Muchas Gracias por unirte a nuestra comunidad :D");
                return "Correo Enviado";
            }
            return "Este Correo ya existe";
        }
        return "Este Nickname ya existe";

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
    public UsuarioDTO obtenerUsuariosPorNickname(@PathVariable(name = "nickname") String nickname) throws
            SQLException {
        return new UsuarioDAO().obtenerUsuariosPorNickname(nickname);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/usuarios/email={email}")
    public UsuarioDTO obtenerUsuariosPorEmail(@PathVariable(name = "email") String email) throws SQLException {
        return new UsuarioDAO().obtenerUsuariosPorEmail(email);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/usuarios/actualizar={id}")
    public void actualizarUsuario(@PathVariable("id") int id, @ModelAttribute UsuarioDTO usuario,
                                  @RequestPart MultipartFile imagen) throws SQLException, IOException {
        new UsuarioDAO().actualizarUsuario(usuario, new imgbbAPI().ImgToUrl(imagen), id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/usuarios/eliminar={id}")
    public void eliminarUsuario(@PathVariable(name = "id") int id) throws SQLException {
        new UsuarioDAO().eliminarUsuario(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/usuarios/login")
    public @ResponseBody
    Boolean loginCredenciales(@RequestParam("nickname") String
                                      nickname, @RequestParam("password") String password) throws SQLException {
        UsuarioDTO usuario = new UsuarioDAO().obtenerUsuariosPorNickname(nickname);

        if (usuario == null) {
            return null;
        } else if (usuario.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}