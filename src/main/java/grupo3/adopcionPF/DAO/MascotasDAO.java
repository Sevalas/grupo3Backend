package grupo3.adopcionPF.DAO;

import grupo3.adopcionPF.Conexion.connectionManager;
import grupo3.adopcionPF.DTO.MascotasDTO;

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
    private List<MascotasDTO> listaMascotas = new ArrayList<>();
    private MascotasDTO nuevoMascota;

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

    public List<MascotasDTO> obtenerListaMascotas() throws SQLException {
        sql = "SELECT id,nombres,cuidador,especies,raza,edad,requisitos,fecha_de_publicacion " +
                "FROM grupo3_mascotas";
        ps = Conn.prepareStatement(sql);
        rs = ps.executeQuery();
        if (rs.next()) {
            do {
                nuevoMascota= new MascotasDTO(rs.getInt("id"),
                        rs.getString("nombres"),
                        rs.getInt("cuidador"),
                        rs.getString("especies"),
                        rs.getString("raza"),
                        rs.getInt("edad"),
                        rs.getString("requisitos"),
                        rs.getDate("fecha_de_publicacion"));
                listaMascotas.add(nuevoMascota);
            } while (rs.next());
        }
        return listaMascotas;
    }
}
