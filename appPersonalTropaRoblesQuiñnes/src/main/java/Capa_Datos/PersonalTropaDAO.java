package Capa_Datos;

import Capa_Conexion.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author LAB-01-LV
 */
public class PersonalTropaDAO {

    // Método para agregar un nuevo personal de tropa usando procedimiento almacenado
    public boolean agregarPersonal(PersonalTropa tropa) {
        Connection cn = new ConexionMySQL().conexion(); 
        String sql = "CALL registrar_tropa(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, tropa.getIdTropa());
            ps.setString(2, tropa.getNomApe());
            ps.setDate(3, new java.sql.Date(tropa.getFechaNac().getTime()));
            ps.setString(4, tropa.getRango());
            ps.setString(5, tropa.getaPromo());
            ps.setString(6, tropa.getMesPromo());
            ps.setString(7, tropa.getCuerpo());
            ps.setString(8, tropa.getGrupoAereo());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar personal: " + e.getMessage());
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para actualizar personal de tropa usando procedimiento almacenado
    public boolean actualizarPersonal(PersonalTropa tropa) {
        Connection cn = new ConexionMySQL().conexion();
        String sql = "CALL actualizar_tropa(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, tropa.getNomApe());
            ps.setDate(2, new java.sql.Date(tropa.getFechaNac().getTime()));
            ps.setString(3, tropa.getRango());
            ps.setString(4, tropa.getaPromo());
            ps.setString(5, tropa.getMesPromo());
            ps.setString(6, tropa.getCuerpo());
            ps.setString(7, tropa.getGrupoAereo());
            ps.setString(8, tropa.getIdTropa());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar personal: " + e.getMessage());
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para eliminar personal de tropa usando procedimiento almacenado
    public boolean eliminarPersonal(String idTropa) {
        Connection cn = new ConexionMySQL().conexion();
        String sql = "CALL eliminar_tropa(?)";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, idTropa);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar personal: " + e.getMessage());
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para listar todo el personal de tropa usando procedimiento almacenado
    public List<PersonalTropa> listarPersonal() {
        Connection cn = new ConexionMySQL().conexion();
        String sql = "CALL listar_tropa()";
        List<PersonalTropa> lista = new ArrayList<>();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PersonalTropa tropa = new PersonalTropa();
                tropa.setIdTropa(rs.getString("id_tropa"));
                tropa.setNomApe(rs.getString("nomape"));
                tropa.setFechaNac(rs.getDate("fecha_nac"));
                tropa.setRango(rs.getString("rango"));
                tropa.setaPromo(rs.getString("a_promo"));
                tropa.setMesPromo(rs.getString("mes_promo"));
                tropa.setCuerpo(rs.getString("cuerpo"));
                tropa.setGrupoAereo(rs.getString("grupo_aereo"));
                tropa.setFechaReg(rs.getTimestamp("fecha_reg"));

                lista.add(tropa);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar personal: " + e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }

    // Método para contar el número de personal de tropa usando procedimiento almacenado
    public int contarPersonal() {
        Connection cn = new ConexionMySQL().conexion();
        String sql = "CALL numero_tropa()";
        int count = 0;
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);  // La consulta devuelve el número de personal
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al contar personal: " + e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }
}
