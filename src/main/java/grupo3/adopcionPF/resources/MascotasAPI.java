package grupo3.adopcionPF.resources;

import grupo3.adopcionPF.DAO.MascotasDAO;
import grupo3.adopcionPF.DTO.MascotasDTO;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MascotasAPI {

    @RequestMapping(method = RequestMethod.POST,value = "/mascotas")
    public void AgregarMascota(@ModelAttribute MascotasDTO mascota) throws SQLException{
        new MascotasDAO().agregarMascota(mascota);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/mascotas")
    public List<MascotasDTO> obtenerListaUsuarios() throws SQLException {
        return new MascotasDAO().obtenerListaMascotas();
    }

}
