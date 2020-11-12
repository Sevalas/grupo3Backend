package grupo3.adopcionPF.DAO;

import grupo3.adopcionPF.Conexion.connectionManager;
import grupo3.adopcionPF.DTO.PostulacionesDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostulacionesDAO {
    private Connection Conn;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    private List<PostulacionesDTO> listaPostulaciones = new ArrayList<>();
    private PostulacionesDTO nuevaPostulacion;

    public PostulacionesDAO() throws SQLException {
        Conn = connectionManager.obtenerConexion();
    }

    public void agregarPostulacion(PostulacionesDTO postulacion, String foto) throws SQLException {
        sql = "INSERT INTO grupo3_postulaciones(usuario,pregunta1,pregunta2,descripcion,foto_ref_url,mascota) " +
                "VALUES(?,?,?,?,?,?)";
        ps = Conn.prepareStatement(sql);
        ps.setInt(1, postulacion.getUsuario());
        ps.setString(2, postulacion.getPregunta1());
        ps.setString(3, postulacion.getPregunta2());
        ps.setString(4, postulacion.getDescripcion());
        ps.setString(5, foto);
        ps.setInt(6, postulacion.getMascota());
        ps.execute();
    }

    public List<PostulacionesDTO> obtenerListaFotoMascotas() throws SQLException {
        sql = "SELECT id,usuario,pregunta1,pregunta2,descripcion,foto_ref_url,mascota,estado " +
                "FROM grupo3_postulaciones";
        ps = Conn.prepareStatement(sql);
        rs = ps.executeQuery();
        if (rs.next()) {
            do {
                nuevaPostulacion = new PostulacionesDTO(rs.getInt("id"),
                        rs.getInt("usuario"),
                        rs.getString("pregunta1"),
                        rs.getString("pregunta2"),
                        rs.getString("descripcion"),
                        rs.getString("foto_ref_url"),
                        rs.getInt("mascota"),
                        rs.getString("estado"));
                listaPostulaciones.add(nuevaPostulacion);
            } while (rs.next());
        }
        return listaPostulaciones;
    }

}
