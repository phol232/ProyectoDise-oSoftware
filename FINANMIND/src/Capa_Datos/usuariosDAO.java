package Capa_Datos;

import Capa_Conexion.ConexionSqlserver;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;

public class usuariosDAO {

    public boolean guardarUsuario(usuarios usuario) {
        Connection conexion = null;
        CallableStatement cs = null;
        boolean resultado = false;

        try {
            // Obtener la conexión
            conexion = ConexionSqlserver.getConexion();

            // Llamar al procedimiento almacenado
            String sql = "{CALL spInsertarUsuario(?, ?, ?, ?, ?, ?, ?)}";
            cs = conexion.prepareCall(sql);

            // Asignar parámetros
            cs.setString(1, usuario.getIdUsuario());
            cs.setString(2, usuario.getNombre());
            cs.setString(3, usuario.getContraseña());
            cs.setString(4, usuario.getEmail());
            cs.setString(5, usuario.getEdad());
            cs.setString(6, usuario.getOcupacion());
            cs.setString(7, usuario.getFechaRegistro());

            // Ejecutar procedimiento
            resultado = cs.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al guardar el usuario: " + e.getMessage());
        } finally {
            try {
                if (cs != null) cs.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }

        return resultado;
    }
    
    // Método para validar usuario y contraseña
    public boolean validarUsuario(String idUsuario, String contraseña) {
    Connection conexion = null;
    CallableStatement cs = null;
    ResultSet rs = null;
    boolean resultado = false;

    try {
        // Obtener la conexión
        conexion = ConexionSqlserver.getConexion();

        // Llamar al procedimiento almacenado
        String sql = "{CALL spIniciarSesion(?, ?)}";
        cs = conexion.prepareCall(sql);
        cs.setString(1, idUsuario);
        cs.setString(2, contraseña);

        // Ejecutar el procedimiento
        rs = cs.executeQuery();

        // Verificar el resultado
        if (rs.next()) {
            int codigoResultado = rs.getInt("Resultado");
            resultado = (codigoResultado == 1); // Credenciales válidas si Resultado es 1
        }
    } catch (SQLException e) {
        System.err.println("Error al validar usuario: " + e.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (cs != null) cs.close();
        } catch (SQLException e) {
            System.err.println("Error al cerrar recursos: " + e.getMessage());
        }
    }

    return resultado;
}
}
