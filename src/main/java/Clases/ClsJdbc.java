package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

/**
 *
 * @author FREDDY GALVEZ - ALEX ORJUELA - WILSON LOPEZ
 */
public class ClsJdbc {

    String driver = "com.mysql.cj.jdbc.Driver";
    String usuario = "root";
    String contrasenia = "";
    String bd = "bd_elecciones_g9";
    String puerto = "3306";
    String url = "jdbc:mysql://localhost:" + puerto + "/" + bd;
    public Connection conexion;

    public void CrearConexion() {

        try {

            Class.forName(driver);
            this.conexion = DriverManager.getConnection(url, usuario, contrasenia);
            if (conexion != null) {
                System.out.println("conexion exitosa");
            }

        } catch (Exception e) {
            System.out.println("ups ocurrio un error en la conexion" + e.getMessage());
        }

    }

}
