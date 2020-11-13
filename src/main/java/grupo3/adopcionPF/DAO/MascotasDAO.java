package grupo3.adopcionPF.DAO;

import grupo3.adopcionPF.Conexion.connectionManager;
import grupo3.adopcionPF.DTO.MascotasDTO;
import grupo3.adopcionPF.DTO.UsuarioDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MascotasDAO {

    private Connection Conn;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    private List<MascotasDAO> listaMascotas = new ArrayList<>();
    private MascotasDAO nuevoMascota;

    public MascotasDAO() throws SQLException{
        Conn = connectionManager.obtenerConexion();
    }

    public void agregarMascota(MascotasDTO mascota) throws SQLException {
        sql = "INSERT INTO grupo3_mascotas(nombres,cuidador,especies,raza,edad,requisitos,fecha_de_publicacion) " +
                "VALUES(?,?,?,?,?,?,?)";
        ps = Conn.prepareStatement(sql);
        ps.setString(1,mascota.getNombre());
        ps.setInt(2,mascota.getCuidador());
        ps.setString(3,mascota.getEspecie());
        ps.setString(4,mascota.getRaza());
        ps.setInt(5,mascota.getEdad());
        ps.setString(6,mascota.getRequisitos());
        ps.setDate(7,mascota.getFechaDePublicacion());
        ps.execute();
    }
}
