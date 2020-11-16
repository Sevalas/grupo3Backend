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
    public void agregarMascota(@ModelAttribute MascotasDTO mascota) throws SQLException{
        new MascotasDAO().agregarMascota(mascota);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/mascotas")
    public List<MascotasDTO> obtenerListaMascotas() throws SQLException {
        return new MascotasDAO().obtenerListaMascotas();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/mascotas/id={id}")
    public MascotasDTO obtenerMascotaPorId(@PathVariable(name = "id") int id) throws SQLException {
        return new MascotasDAO().obtenerMascotasPorId(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/mascotas/cuidador={cuidador}")
    public List<MascotasDTO> obtenerMascotaPorCuidador(@PathVariable(name = "cuidador") int cuidador) throws SQLException {
        return new MascotasDAO().obtenerMascotasPorCuidador(cuidador);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/mascotas/actualizar={id}")
    public void actualizarMascota(@PathVariable("id") int id, @ModelAttribute MascotasDTO mascota) throws SQLException{
        new MascotasDAO().actualizarMascotas(mascota,id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/mascotas/eliminar={id}")
    public void eliminarMascota(@PathVariable(name = "id") int id) throws SQLException {
        new MascotasDAO().eliminarMascota(id);
    }

}
