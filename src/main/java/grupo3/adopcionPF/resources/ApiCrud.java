package grupo3.adopcionPF.resources;

import grupo3.adopcionPF.DAO.UsuarioDAO;
import grupo3.adopcionPF.DTO.UsuarioDTO;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")

public class ApiCrud{

    //REGISTRAR USUARIO
    @RequestMapping(method = RequestMethod.POST,value = "/registro")
    public void registrarNuevoUsuario(@RequestBody UsuarioDTO dtoUsuario)throws SQLException{
        new UsuarioDAO().registrarUsuario(dtoUsuario);
    }

    //ELIMINAR USUARIO
    @RequestMapping(method = RequestMethod.DELETE,value = "/eliminarCuenta/{id}")
    public  void eliminarUsuario(@PathVariable(name = "id")int id) throws SQLException{
        new UsuarioDAO().eliminarUsuario(id);
    }

    







}