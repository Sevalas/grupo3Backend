package grupo3.adopcionPF.DAO;

import grupo3.adopcionPF.Conexion.connectionManager;
import grupo3.adopcionPF.DTO.UsuarioDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {

    private Connection conectarBD;

    public UsuarioDAO() throws SQLException{
        this.conectarBD = connectionManager.obtenerConexion();
    }

    //REGISTRO DE USUARIO

    public void registrarUsuario(UsuarioDTO nuevoUsuario) throws SQLException{
        String sqlRegistrar = "INSERT INTO grupo3_usuarios(nickname,password,nombres,apellidos,"+
                "fecha_nacimiento,email,fono,region,comuna,foto_perfil_url) "+
                "VALUES (?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement ps = conectarBD.prepareStatement(sqlRegistrar);
        ps.setString(1,nuevoUsuario.getNickname());
        ps.setString(2,nuevoUsuario.getPassword());
        ps.setString(3,nuevoUsuario.getNombres());
        ps.setString(4,nuevoUsuario.getApellidos());
        ps.setDate(5,nuevoUsuario.getFechaNacimiento());
        ps.setString(6,nuevoUsuario.getEmail());
        ps.setInt(7,nuevoUsuario.getFono());
        ps.setString(8,nuevoUsuario.getRegion());
        ps.setString(9,nuevoUsuario.getComuna());
        ps.setString(10,nuevoUsuario.getFotoPerfilUrl());
        ps.execute();

    }
}