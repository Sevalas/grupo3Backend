package grupo3.adopcionPF.DAO;

import grupo3.adopcionPF.Conexion.connectionManager;
import grupo3.adopcionPF.DTO.FotosMascotasDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FotosMascotasDAO {
    private Connection Conn;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    private List<FotosMascotasDTO> listaFotoMascota = new ArrayList<>();
    private FotosMascotasDTO nuevaFotoMascota;

    public FotosMascotasDAO() throws SQLException {
        Conn = connectionManager.obtenerConexion();
    }

    public void agregarFotosMascotas(FotosMascotasDTO FotoMascota, String foto) throws SQLException {
        sql = "INSERT INTO grupo3_fotos_mascotas(mascota,foto) " +
                "VALUES(?,?)";
        ps = Conn.prepareStatement(sql);
        ps.setInt(1, FotoMascota.getMascota());
        ps.setString(2, foto);
        ps.execute();
    }
    public List<FotosMascotasDTO> obtenerListaFotoMascotas() throws SQLException {
        sql = "SELECT id,mascota,foto " +
                "FROM grupo3_fotos_mascotas ";
        ps = Conn.prepareStatement(sql);
        rs = ps.executeQuery();
        if (rs.next()) {
            do {
                nuevaFotoMascota = new FotosMascotasDTO(rs.getInt("id"),
                        rs.getInt("mascota"),
                        rs.getString("foto"));
                listaFotoMascota.add(nuevaFotoMascota);
            } while (rs.next());
        }
        return listaFotoMascota;
    }

    public FotosMascotasDTO obtenerFotoMascotaPorId(int id) throws SQLException {
        sql = "SELECT id,mascota,foto " +
                "FROM grupo3_fotos_mascotas " +
                "WHERE id = ?";
        ps = Conn.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        if (rs.next()) {
            nuevaFotoMascota = new FotosMascotasDTO(rs.getInt("id"),
                    rs.getInt("mascota"),
                    rs.getString("foto"));
        }
        return nuevaFotoMascota;
    }

    public List<FotosMascotasDTO> obtenerListaPorMascota(int idMascota) throws SQLException {
        sql = "SELECT id,mascota,foto " +
                "FROM grupo3_fotos_mascotas " +
                "WHERE mascota = ?";
        ps = Conn.prepareStatement(sql);
        ps.setInt(1, idMascota);
        rs = ps.executeQuery();
        if (rs.next()) {
            do {
            nuevaFotoMascota = new FotosMascotasDTO(rs.getInt("id"),
                    rs.getInt("mascota"),
                    rs.getString("foto"));
            listaFotoMascota.add(nuevaFotoMascota);
            } while (rs.next());
        }
        return listaFotoMascota;
    }

    public void actualizarFotoMascota(int id,String foto) throws SQLException {
        sql = "UPDATE grupo3_fotos_mascotas " +
                "SET foto = ? " +
                "WHERE id = ?;";
        ps = Conn.prepareStatement(sql);
        ps.setString(1,foto);
        ps.setInt(2,id);
        ps.execute();
    }

    public void eliminarFotoMascota(int id)throws SQLException {
        sql = "DELETE FROM grupo3_fotos_mascotas " +
                "WHERE id = ?";
        ps = Conn.prepareCall(sql);
        ps.setInt(1,id);
        ps.execute();
    }
}
