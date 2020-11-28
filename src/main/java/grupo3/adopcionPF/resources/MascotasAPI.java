package grupo3.adopcionPF.resources;

import grupo3.adopcionPF.DAO.MascotasDAO;
import grupo3.adopcionPF.DTO.MascotasDTO;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class MascotasAPI {

    @RequestMapping(method = RequestMethod.POST,value = "/mascotas")
    public int agregarMascota(@RequestBody MascotasDTO mascota) throws SQLException{
        return new  MascotasDAO().agregarMascota(mascota).getIdMascota();
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
    public void actualizarMascota(@PathVariable("id") int id, @RequestBody MascotasDTO mascota) throws SQLException{
        new MascotasDAO().actualizarMascotas(mascota,id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/mascotas/eliminar={id}")
    public void eliminarMascota(@PathVariable(name = "id") int id) throws SQLException {
        new MascotasDAO().eliminarMascota(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/mascotas/filtrada={usuario}")
    public List<MascotasDTO> ListaMascotasFiltrada(@PathVariable(name = "usuario") int usuario) throws SQLException {
        return new MascotasDAO().ListaMascotasFiltrada(usuario);
    }
}
