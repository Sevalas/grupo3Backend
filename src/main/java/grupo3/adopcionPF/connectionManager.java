package grupo3.adopcionPF;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionManager {
    private static Connection connection = null;
    private static String URL = "jdbc:postgresql://forgedb.netbyteoss.com:5443/forge_alumnos";
    private static String Usuario = "svalencia";
    private static String Pass = "V24.98";

    public static Connection obtenerConexion() throws SQLException {
        if(connection==null){
            connection = DriverManager.getConnection(URL,Usuario,Pass);
        }
        return connection;
    }

}

