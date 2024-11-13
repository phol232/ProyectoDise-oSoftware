package Capa_Datos;

import Capa_Conexion.ConexionSqlserver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ingresosDAO {

    public boolean insertarIngreso(ingresos ingreso) {
    String sql = "{CALL spInsertarIngreso(?, ?, ?, ?, ?, ?, ?)}";
    try (Connection conn = ConexionSqlserver.getConexion();
         CallableStatement stmt = conn.prepareCall(sql)) {
        stmt.setString(1, ingreso.getIdIngreso());
        stmt.setString(2, ingreso.getIdUsuario());
        stmt.setDouble(3, ingreso.getMonto());
        stmt.setString(4, ingreso.getFuente());
        stmt.setString(5, ingreso.getFechaIngreso());
        stmt.setString(6, ingreso.getTipoIngreso());
        stmt.setString(7, ingreso.getDescripcion());

        return stmt.executeUpdate() > 0; // Devuelve true si se insertó
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

public boolean actualizarIngreso(ingresos ingreso) {
    String sql = "{CALL spActualizarIngreso(?, ?, ?, ?, ?, ?, ?)}";
    try (Connection conn = ConexionSqlserver.getConexion();
         CallableStatement stmt = conn.prepareCall(sql)) {
        stmt.setString(1, ingreso.getIdIngreso());
        stmt.setString(2, ingreso.getIdUsuario());
        stmt.setDouble(3, ingreso.getMonto());
        stmt.setString(4, ingreso.getFuente());
        stmt.setString(5, ingreso.getFechaIngreso());
        stmt.setString(6, ingreso.getTipoIngreso());
        stmt.setString(7, ingreso.getDescripcion());

        return stmt.executeUpdate() > 0; // Devuelve true si se actualizó
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}


    // Método para eliminar un ingreso
    public boolean eliminarIngreso(String idIngreso) {
        Connection conexion = null;
        CallableStatement cs = null;
        boolean resultado = false;

        try {
            conexion = ConexionSqlserver.getConexion();
            String sql = "{CALL spEliminarIngreso(?)}";
            cs = conexion.prepareCall(sql);

            cs.setString(1, idIngreso);

            resultado = cs.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar ingreso: " + e.getMessage());
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

    public List<ingresos> listarIngresosSimplificados() {
    List<ingresos> lista = new ArrayList<>();
    String sql = "{CALL spListarIngresosSimplificados()}";

    try (Connection conexion = ConexionSqlserver.getConexion();
         CallableStatement cs = conexion.prepareCall(sql);
         ResultSet rs = cs.executeQuery()) {

        while (rs.next()) {
            ingresos ingreso = new ingresos();
            ingreso.setIdIngreso(rs.getString("id_ingreso"));
            ingreso.setIdUsuario(rs.getString("id_usuario"));
            ingreso.setMonto(rs.getDouble("monto"));
            ingreso.setFechaIngreso(rs.getString("fecha_ingreso"));
            ingreso.setTipoIngreso(rs.getString("tipo_ingreso"));
            lista.add(ingreso);
        }

    } catch (SQLException e) {
        System.err.println("Error al listar ingresos: " + e.getMessage());
    }

    return lista;
}

}
