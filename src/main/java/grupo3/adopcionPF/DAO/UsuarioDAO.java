package grupo3.adopcionPF.DAO;

import grupo3.adopcionPF.Conexion.connectionManager;
import grupo3.adopcionPF.DTO.UsuarioDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private Connection Conn;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    private List<UsuarioDTO> listaUsuarios = new ArrayList<>();
    private UsuarioDTO nuevoUsuario;

    public UsuarioDAO() throws SQLException{
        Conn = connectionManager.obtenerConexion();
    }

    public void agregarUsuario(UsuarioDTO usuario, String image) throws SQLException {
        sql = "INSERT INTO grupo3_usuarios(nickname,password,nombres,apellidos,fecha_nacimiento,email,fono,region,comuna,foto_perfil_url) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?)";
        ps = Conn.prepareStatement(sql);
        ps.setString(1,usuario.getNickname());
        ps.setString(2,usuario.getPassword());
        ps.setString(3,usuario.getNombres());
        ps.setString(4,usuario.getApellidos());
        ps.setDate(5,usuario.getFechaNacimiento());
        ps.setString(6,usuario.getEmail());
        ps.setInt(7, usuario.getFono());
        ps.setString(8,usuario.getRegion());
        ps.setString(9,usuario.getComuna());
        ps.setString(10,image);
        ps.execute();
    }

    public List<UsuarioDTO> obtenerListaUsuarios() throws SQLException {
        sql = "SELECT id,nickname,password,nombres,apellidos,fecha_nacimiento,email,fono,region,comuna,foto_perfil_url " +
                "FROM grupo3_usuarios";
        ps = Conn.prepareStatement(sql);
        rs = ps.executeQuery();
        if (rs.next()) {
            do {
                nuevoUsuario= new UsuarioDTO(rs.getInt("id"),
                        rs.getString("nickname"),
                        rs.getString("password"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getDate("fecha_nacimiento"),
                        rs.getString("email"),
                        rs.getInt("fono"),
                        rs.getString("region"),
                        rs.getString("comuna"),
                        rs.getString("foto_perfil_url"));
                listaUsuarios.add(nuevoUsuario);
            } while (rs.next());
        }
        return listaUsuarios;
    }

    public UsuarioDTO obtenerUsuariosPorId(int id) throws SQLException {
        sql = "SELECT id,nickname,password,nombres,apellidos,fecha_nacimiento,email,fono,region,comuna,foto_perfil_url " +
                "FROM grupo3_usuarios " +
                "WHERE id = ?";
        ps = Conn.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        if (rs.next()) {
            nuevoUsuario= new UsuarioDTO(rs.getInt("id"),
                    rs.getString("nickname"),
                    rs.getString("password"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getDate("fecha_nacimiento"),
                    rs.getString("email"),
                    rs.getInt("fono"),
                    rs.getString("region"),
                    rs.getString("comuna"),
                    rs.getString("foto_perfil_url"));
        }
        return nuevoUsuario;
    }

    public UsuarioDTO obtenerUsuariosPorNickname(String nickname) throws SQLException {
        sql = "SELECT id,nickname,password,nombres,apellidos,fecha_nacimiento,email,fono,region,comuna,foto_perfil_url " +
                "FROM grupo3_usuarios " +
                "WHERE nickname = ?";
        ps = Conn.prepareStatement(sql);
        ps.setString(1, nickname);
        rs = ps.executeQuery();
        if (rs.next()) {
            nuevoUsuario= new UsuarioDTO(rs.getInt("id"),
                    rs.getString("nickname"),
                    rs.getString("password"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getDate("fecha_nacimiento"),
                    rs.getString("email"),
                    rs.getInt("fono"),
                    rs.getString("region"),
                    rs.getString("comuna"),
                    rs.getString("foto_perfil_url"));
        }
        return nuevoUsuario;
    }

    public UsuarioDTO obtenerUsuariosPorEmail(String email) throws SQLException {
        sql = "SELECT id,nickname,password,nombres,apellidos,fecha_nacimiento,email,fono,region,comuna,foto_perfil_url " +
                "FROM grupo3_usuarios " +
                "WHERE email = ?";
        ps = Conn.prepareStatement(sql);
        ps.setString(1, email);
        rs = ps.executeQuery();
        if (rs.next()) {
            nuevoUsuario= new UsuarioDTO(rs.getInt("id"),
                    rs.getString("nickname"),
                    rs.getString("password"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getDate("fecha_nacimiento"),
                    rs.getString("email"),
                    rs.getInt("fono"),
                    rs.getString("region"),
                    rs.getString("comuna"),
                    rs.getString("foto_perfil_url"));
        }
        return nuevoUsuario;
    }

    public UsuarioDTO obtenerUsuariosPorFono(int fono) throws SQLException {
        sql = "SELECT id,nickname,password,nombres,apellidos,fecha_nacimiento,email,fono,region,comuna,foto_perfil_url " +
                "FROM grupo3_usuarios " +
                "WHERE fono = ?";
        ps = Conn.prepareStatement(sql);
        ps.setInt(1, fono);
        rs = ps.executeQuery();
        if (rs.next()) {
            nuevoUsuario= new UsuarioDTO(rs.getInt("id"),
                    rs.getString("nickname"),
                    rs.getString("password"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getDate("fecha_nacimiento"),
                    rs.getString("email"),
                    rs.getInt("fono"),
                    rs.getString("region"),
                    rs.getString("comuna"),
                    rs.getString("foto_perfil_url"));
        }
        return nuevoUsuario;
    }

    public void actualizarUsuario(UsuarioDTO usuario,String foto,int id) throws SQLException {
        sql = "UPDATE grupo3_usuarios " +
                "SET nickname=?,password=?,nombres=?,apellidos=?,fecha_nacimiento=?,email=?,fono=?,region=?,comuna=?,foto_perfil_url=? " +
                "WHERE id = ?";
        ps = Conn.prepareStatement(sql);
        ps = Conn.prepareStatement(sql);
        ps.setString(1,usuario.getNickname());
        ps.setString(2,usuario.getPassword());
        ps.setString(3,usuario.getNombres());
        ps.setString(4,usuario.getApellidos());
        ps.setDate(5,usuario.getFechaNacimiento());
        ps.setString(6,usuario.getEmail());
        ps.setInt(7,usuario.getFono());
        ps.setString(8,usuario.getRegion());
        ps.setString(9,usuario.getComuna());
        ps.setString(10,foto);
        ps.setInt(11,id);
        ps.execute();
    }

    public void eliminarUsuario(int id)throws SQLException {
        sql = "DELETE FROM grupo3_usuarios " +
                "WHERE id = ?";
        ps = Conn.prepareCall(sql);
        ps.setInt(1,id);
        ps.execute();
    }

    public String obtenerFotoUsuario(int id)throws SQLException {
        sql = "SELECT foto_perfil_url " +
                "FROM grupo3_usuarios " +
                "WHERE id = ?";
        ps = Conn.prepareCall(sql);
        ps.setInt(1,id);
        rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getString("foto_perfil_url");
        }
        return null;
    }
    public UsuarioDTO obtenerUsuariosPorNicknameExceptId(String nickname,int id) throws SQLException {
        sql = "SELECT id,nickname,password,nombres,apellidos,fecha_nacimiento,email,fono,region,comuna,foto_perfil_url " +
                "FROM grupo3_usuarios " +
                "WHERE nickname = ? " +
                "EXCEPT " +
                "SELECT id,nickname,password,nombres,apellidos,fecha_nacimiento,email,fono,region,comuna,foto_perfil_url " +
                "FROM grupo3_usuarios " +
                "WHERE id = ?";
        ps = Conn.prepareStatement(sql);
        ps.setString(1, nickname);
        ps.setInt(2, id);
        rs = ps.executeQuery();
        if (rs.next()) {
            nuevoUsuario= new UsuarioDTO(rs.getInt("id"),
                    rs.getString("nickname"),
                    rs.getString("password"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getDate("fecha_nacimiento"),
                    rs.getString("email"),
                    rs.getInt("fono"),
                    rs.getString("region"),
                    rs.getString("comuna"),
                    rs.getString("foto_perfil_url"));
        }
        return nuevoUsuario;
    }

    public UsuarioDTO obtenerUsuariosPorEmailExceptId(String email, int id) throws SQLException {
        sql = "SELECT id,nickname,password,nombres,apellidos,fecha_nacimiento,email,fono,region,comuna,foto_perfil_url " +
                "FROM grupo3_usuarios " +
                "WHERE email = ?" +
                "EXCEPT " +
                "SELECT id,nickname,password,nombres,apellidos,fecha_nacimiento,email,fono,region,comuna,foto_perfil_url " +
                "FROM grupo3_usuarios " +
                "WHERE id = ?";
        ps = Conn.prepareStatement(sql);
        ps.setString(1, email);
        ps.setInt(2, id);
        rs = ps.executeQuery();
        if (rs.next()) {
            nuevoUsuario= new UsuarioDTO(rs.getInt("id"),
                    rs.getString("nickname"),
                    rs.getString("password"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getDate("fecha_nacimiento"),
                    rs.getString("email"),
                    rs.getInt("fono"),
                    rs.getString("region"),
                    rs.getString("comuna"),
                    rs.getString("foto_perfil_url"));
        }
        return nuevoUsuario;
    }

    public UsuarioDTO obtenerUsuariosPorFonoExceptId(int fono,int id) throws SQLException {
        sql = "SELECT id,nickname,password,nombres,apellidos,fecha_nacimiento,email,fono,region,comuna,foto_perfil_url " +
                "FROM grupo3_usuarios " +
                "WHERE fono = ?" +
                "EXCEPT " +
                "SELECT id,nickname,password,nombres,apellidos,fecha_nacimiento,email,fono,region,comuna,foto_perfil_url " +
                "FROM grupo3_usuarios " +
                "WHERE id = ?";
        ps = Conn.prepareStatement(sql);
        ps.setInt(1, fono);
        ps.setInt(2, id);
        rs = ps.executeQuery();
        if (rs.next()) {
            nuevoUsuario= new UsuarioDTO(rs.getInt("id"),
                    rs.getString("nickname"),
                    rs.getString("password"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getDate("fecha_nacimiento"),
                    rs.getString("email"),
                    rs.getInt("fono"),
                    rs.getString("region"),
                    rs.getString("comuna"),
                    rs.getString("foto_perfil_url"));
        }
        return nuevoUsuario;
    }
}