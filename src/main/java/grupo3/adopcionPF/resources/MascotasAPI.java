package grupo3.adopcionPF.resources;

import grupo3.adopcionPF.DAO.MascotasDAO;
import grupo3.adopcionPF.DTO.MascotasDTO;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")

public class MascotasAPI {

    //REGISTRAR MASCOTA
    @RequestMapping(method = RequestMethod.POST,value = "/registroMascota")
    public void registrarNuevaMascota(@RequestBody MascotasDTO dtoMascota)throws SQLException{
        new MascotasDAO().agregarMascota(dtoMascota);
    }
}
