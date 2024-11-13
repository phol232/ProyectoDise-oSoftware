package Capa_Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSqlserver {
    // Cambia la URL a la que apunta a tu base de datos SQL Server
    private static final String URL = "jdbc:sqlserver://DESKTOP-SANR9NS\\SQLDEVELOPPER:1433;databaseName=GESTIONFINANCIERA;encrypt=false;";
    private static final String USUARIO = "sa";  
    private static final String PASSWORD = "230902";  

    // Método para obtener una nueva conexión
    public static Connection getConexion() {
        try {
            // Cargar el controlador de SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(URL, USUARIO, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("Controlador no encontrado: " + e.getMessage());
            return null;
        } catch (SQLException se) {
            System.err.println("Error al conectar a la base de datos: " + se.getMessage());
            return null;
        }
    }

    // Método principal para probar la conexión
    public static void main(String[] args) {
        try (Connection con = ConexionSqlserver.getConexion()) {
            if (con != null) {
                System.out.println("Conexión exitosa a SQL Server.");
            } else {
                System.err.println("No se pudo conectar a la base de datos.");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
