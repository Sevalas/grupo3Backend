package grupo3.adopcionPF.DAO;

import grupo3.adopcionPF.Conexion.connectionManager;
import grupo3.adopcionPF.DTO.MascotasDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MascotasDAO {

    private Connection conectarBD;

    public MascotasDAO() throws SQLException {
        this.conectarBD = connectionManager.obtenerConexion();
    }

    //AGREGAR NUEVA MASCOTA
    public void agregarMascota(MascotasDTO nuevaMascota)throws SQLException{
        String sqlRegistrar ="INSERT INTO grupo3_mascotas(nombres,cuidador,especies," +
                "raza,edad,requisitos,fecha_de_publicacion)" +
                "VALUES(?,?,?,?,?,?,?)";

        PreparedStatement ps = conectarBD.prepareStatement(sqlRegistrar);

        ps.setString(1,nuevaMascota.getNombre());
        ps.setInt(2,nuevaMascota.getCuidador());
        ps.setString(3,nuevaMascota.getEspecie());
        ps.setString(4, nuevaMascota.getRaza());
        ps.setInt(5,nuevaMascota.getEdad());
        ps.setString(6,nuevaMascota.getRequisitos());
        ps.setDate(7,nuevaMascota.getFechaDePublicacion());
        ps.execute();
    }
}
