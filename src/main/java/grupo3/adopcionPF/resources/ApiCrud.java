package grupo3.adopcionPF.resources;

import grupo3.adopcionPF.DAO.UsuarioDAO;
import grupo3.adopcionPF.DTO.UsuarioDTO;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")

public class ApiCrud{

    @RequestMapping(method = RequestMethod.POST,value = "/registro")
    public void registrarNuevoUsuario(@RequestBody UsuarioDTO dtoUsuario)throws SQLException{
        new UsuarioDAO().registrarUsuario(dtoUsuario);
    }





}