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
        sql = "INSERT INTO grupo3_mascotas(nombres,cuidador,especies,raza,edad,requisitos,fecha_de_publicacion,sexo,info_adicional) " +
                "VALUES(?,?,?,?,?,?,?,?,?)";
        ps = Conn.prepareStatement(sql);
        ps.setString(1,mascota.getNombre());
        ps.setInt(2,mascota.getCuidador());
        ps.setString(3,mascota.getEspecie());
        ps.setString(4,mascota.getRaza());
        ps.setInt(5,mascota.getEdad());
        ps.setString(6,mascota.getRequisitos());
        ps.setDate(7,mascota.getFechaDePublicacion());
        ps.setString(8,String.valueOf(mascota.getSexo()));
        ps.setString(9,mascota.getInfoAdicional());
        ps.execute();
    }

    public List<MascotasDTO> obtenerListaMascotas() throws SQLException {
        sql = "SELECT id,nombres,cuidador,especies,raza,edad,requisitos,fecha_de_publicacion,sexo,info_adicional " +
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
                        rs.getDate("fecha_de_publicacion"),
                        rs.getString("sexo").charAt(0),
                        rs.getString("info_adicional"));
                listaMascotas.add(nuevoMascota);
            } while (rs.next());
        }
        return listaMascotas;
    }

    public MascotasDTO obtenerMascotasPorId(int id) throws SQLException {
        sql = "SELECT id,nombres,cuidador,especies,raza,edad,requisitos,fecha_de_publicacion,sexo,info_adicional " +
                "FROM grupo3_mascotas " +
                "WHERE id = ?";
        ps = Conn.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        if (rs.next()) {
            nuevoMascota= new MascotasDTO(rs.getInt("id"),
                    rs.getString("nombres"),
                    rs.getInt("cuidador"),
                    rs.getString("especies"),
                    rs.getString("raza"),
                    rs.getInt("edad"),
                    rs.getString("requisitos"),
                    rs.getDate("fecha_de_publicacion"),
                    rs.getString("sexo").charAt(0),
                    rs.getString("info_adicional"));
        }
        return nuevoMascota;
    }

    public List<MascotasDTO> obtenerMascotasPorCuidador(int cuidador) throws SQLException {
        sql = "SELECT id,nombres,cuidador,especies,raza,edad,requisitos,fecha_de_publicacion,sexo,sexo,info_adicional " +
                "FROM grupo3_mascotas " +
                "WHERE cuidador = ?";
        ps = Conn.prepareStatement(sql);
        ps.setInt(1, cuidador);
        rs = ps.executeQuery();
        if (rs.next()) {
            do {
                nuevoMascota = new MascotasDTO(rs.getInt("id"),
                        rs.getString("nombres"),
                        rs.getInt("cuidador"),
                        rs.getString("especies"),
                        rs.getString("raza"),
                        rs.getInt("edad"),
                        rs.getString("requisitos"),
                        rs.getDate("fecha_de_publicacion"),
                        rs.getString("sexo").charAt(0),
                        rs.getString("info_adicional"));
                listaMascotas.add(nuevoMascota);
            } while (rs.next());
        }
        return listaMascotas;
    }

    public void actualizarMascotas(MascotasDTO mascota,int id) throws SQLException {
        sql = "UPDATE grupo3_mascotas " +
                "SET nombres=?,cuidador=?,especies=?,raza=?,edad=?,requisitos=?,fecha_de_publicacion=?,sexo=?,info_adicional=? " +
                "WHERE id = ?";
        ps = Conn.prepareStatement(sql);
        ps.setString(1,mascota.getNombre());
        ps.setInt(2,mascota.getCuidador());
        ps.setString(3,mascota.getEspecie());
        ps.setString(4,mascota.getRaza());
        ps.setInt(5,mascota.getEdad());
        ps.setString(6,mascota.getRequisitos());
        ps.setDate(7,mascota.getFechaDePublicacion());
        ps.setString(8,String.valueOf(mascota.getSexo()));
        ps.setString(9,mascota.getInfoAdicional());
        ps.setInt(10,id);
        ps.execute();
    }

    public void eliminarMascota(int id)throws SQLException {
        sql = "DELETE FROM grupo3_mascotas " +
                "WHERE id = ?";
        ps = Conn.prepareCall(sql);
        ps.setInt(1,id);
        ps.execute();
    }

    public List<MascotasDTO> ListaMascotasFiltrada(int usuario)throws SQLException {
        sql = "SELECT DISTINCT usuario,grupo3_mascotas.id,nombres,cuidador,especies,raza,edad,requisitos,fecha_de_publicacion,sexo,info_adicional " +
                "FROM grupo3_mascotas " +
                "LEFT JOIN grupo3_postulaciones " +
                "ON grupo3_postulaciones.mascota = grupo3_mascotas.id " +
                "WHERE grupo3_postulaciones.usuario IS DISTINCT FROM ? " +
                "AND grupo3_mascotas.cuidador IS DISTINCT FROM ? " +
                "ORDER BY id asc";

        ps = Conn.prepareStatement(sql);
        ps.setInt(1, usuario);
        ps.setInt(2, usuario);
        rs = ps.executeQuery();
        if (rs.next()) {
            do {
                nuevoMascota = new MascotasDTO(rs.getInt("id"),
                        rs.getString("nombres"),
                        rs.getInt("cuidador"),
                        rs.getString("especies"),
                        rs.getString("raza"),
                        rs.getInt("edad"),
                        rs.getString("requisitos"),
                        rs.getDate("fecha_de_publicacion"),
                        rs.getString("sexo").charAt(0),
                        rs.getString("info_adicional"));
                listaMascotas.add(nuevoMascota);
            } while (rs.next());
        }
        return listaMascotas;
    }
}
