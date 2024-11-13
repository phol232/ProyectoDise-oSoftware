package Capa_Conexion;

import java.sql.*;

public class ConexionMySQL {

    String url = "jdbc:mysql://localhost:3306/bdTropa";
    String usuario = "root";
    String pass = "230902trph";
    Connection cn;
    
    public Connection conexion() {
        try {
            //cargar el controlador
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Establecer la conexion
             cn = DriverManager.getConnection(url, usuario, pass);

            if (cn != null) {
                System.out.println("Conexion Exitosa");
            }
            
        } catch (ClassNotFoundException e) {
            System.err.println("Controlador no encontrado " + e.getMessage());
        } catch (SQLException se) {
            System.err.println("error al conectar la BD " + se.getMessage());
        }
        return cn;
    }
    
        public static void main(String[] args) {
        ConexionMySQL con=new ConexionMySQL();
        con.conexion();
    }

}
