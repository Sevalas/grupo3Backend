package grupo3.adopcionPF.resources;

import grupo3.adopcionPF.DAO.UsuarioDAO;
import grupo3.adopcionPF.DTO.UploadData;
import grupo3.adopcionPF.DTO.UploadResponse;
import grupo3.adopcionPF.DTO.UsuarioDTO;
import grupo3.adopcionPF.Interfaces.ImgbbService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.sql.SQLException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")

public class UsuarioApi{

    //REGISTRAR USUARIO
    @RequestMapping(method = RequestMethod.POST,value = "/registro/imagen")
    public void registrarNuevoUsuario(@RequestPart("imagen") MultipartFile imagen,@ModelAttribute UsuarioDTO dtoUsuario) throws SQLException, IOException {

        new UsuarioDAO().registrarUsuario(dtoUsuario,new imgbbAPI().ImgToUrl(imagen));
    }

    //ELIMINAR USUARIO
    @RequestMapping(method = RequestMethod.DELETE,value = "/eliminarCuenta/{id}")
    public  void eliminarUsuario(@PathVariable(name = "id")int id) throws SQLException{
        new UsuarioDAO().eliminarUsuario(id);
    }
}