package grupo3.adopcionPF.resources;

import grupo3.adopcionPF.DAO.MascotasDAO;
import grupo3.adopcionPF.DTO.MascotasDTO;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@RestController
@RequestMapping("/api")
public class MascotasAPI {

    @RequestMapping(method = RequestMethod.POST,value = "/mascotas")
    public void AgregarUsuario(@ModelAttribute MascotasDTO mascota) throws SQLException{
        new MascotasDAO().agregarMascota(mascota);
    }
}
