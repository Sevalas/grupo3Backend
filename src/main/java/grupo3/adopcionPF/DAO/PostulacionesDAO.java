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

    public List<PostulacionesDTO> obtenerListaPostulaciones() throws SQLException {
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

    public PostulacionesDTO obtenerPostulacionPorId(int id) throws SQLException {
        sql = "SELECT id,usuario,pregunta1,pregunta2,descripcion,foto_ref_url,mascota,estado " +
                "FROM grupo3_postulaciones " +
                "WHERE id = ?";
        ps = Conn.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        if (rs.next()) {
            nuevaPostulacion = new PostulacionesDTO(rs.getInt("id"),
                    rs.getInt("usuario"),
                    rs.getString("pregunta1"),
                    rs.getString("pregunta2"),
                    rs.getString("descripcion"),
                    rs.getString("foto_ref_url"),
                    rs.getInt("mascota"),
                    rs.getString("estado"));
        }
        return nuevaPostulacion;
    }

    public List<PostulacionesDTO> obtenerListaPorUsuario(int idUsuario) throws SQLException {
        sql = "SELECT id,usuario,pregunta1,pregunta2,descripcion,foto_ref_url,mascota,estado " +
                "FROM grupo3_postulaciones " +
                "WHERE usuario = ?";
        ps = Conn.prepareStatement(sql);
        ps.setInt(1, idUsuario);
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

    public List<PostulacionesDTO> obtenerListaPorMascota(int idMascota) throws SQLException {
        sql = "SELECT id,usuario,pregunta1,pregunta2,descripcion,foto_ref_url,mascota,estado " +
                "FROM grupo3_postulaciones " +
                "WHERE mascota = ?";
        ps = Conn.prepareStatement(sql);
        ps.setInt(1, idMascota);
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

    public void actualizarPostulacion(PostulacionesDTO postulacion,String foto,int id) throws SQLException {
        sql = "UPDATE grupo3_postulaciones " +
                "SET pregunta1=?, pregunta2=?, descripcion=?, foto_ref_url=? " +
                "WHERE id = ?";
        ps = Conn.prepareStatement(sql);
        ps.setString(1,postulacion.getPregunta1());
        ps.setString(2, postulacion.getPregunta2());
        ps.setString(3, postulacion.getDescripcion());
        ps.setString(4,foto);
        ps.setInt(5,id);
        ps.execute();
    }

    public void actualizarEstado(Boolean estado,int id) throws SQLException {
        sql = "UPDATE grupo3_postulaciones " +
                "SET estado=? " +
                "WHERE id = ?";
        ps = Conn.prepareStatement(sql);
        ps.setString(1,estado.toString());
        ps.setInt(2,id);
        ps.execute();
    }

    public void eliminarFotoMascota(int id)throws SQLException {
        sql = "DELETE FROM grupo3_postulaciones " +
                "WHERE id = ?";
        ps = Conn.prepareCall(sql);
        ps.setInt(1,id);
        ps.execute();
    }
}
