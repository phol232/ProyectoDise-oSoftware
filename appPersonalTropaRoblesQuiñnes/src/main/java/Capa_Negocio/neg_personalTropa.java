package Capa_Negocio;

import Capa_Datos.PersonalTropa;
import Capa_Datos.PersonalTropaDAO;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author LAB-01-LV
 */
public class neg_personalTropa {

    // Atributo del DAO
    private PersonalTropaDAO dao;

    // Constructor
    public neg_personalTropa() {
        this.dao = new PersonalTropaDAO();
    }

    // Método para agregar un nuevo personal de tropa
    public boolean agregarPersonal(String idTropa, String nomApe, java.util.Date fechaNac, String rango, String aPromo, String mesPromo, String cuerpo, String grupoAereo) {
        if (idTropa.isEmpty() || nomApe.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ID y Nombre no pueden estar vacíos");
            return false;
        }
        
        PersonalTropa tropa = new PersonalTropa(idTropa, nomApe, fechaNac, rango, aPromo, mesPromo, cuerpo, grupoAereo, null); // Fecha de registro se genera automáticamente en la BD
        
        return dao.agregarPersonal(tropa);
    }

    // Método para actualizar personal de tropa
    public boolean actualizarPersonal(String idTropa, String nomApe, java.util.Date fechaNac, String rango, String aPromo, String mesPromo, String cuerpo, String grupoAereo) {
        if (idTropa.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ID no puede estar vacío");
            return false;
        }

        PersonalTropa tropa = new PersonalTropa(idTropa, nomApe, fechaNac, rango, aPromo, mesPromo, cuerpo, grupoAereo, null);
        return dao.actualizarPersonal(tropa);
    }

    // Método para eliminar personal de tropa
    public boolean eliminarPersonal(String idTropa) {
        if (idTropa.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ID no puede estar vacío");
            return false;
        }
        return dao.eliminarPersonal(idTropa);
    }

    // Método para listar todo el personal de tropa
    public List<PersonalTropa> listarPersonal() {
        return dao.listarPersonal();
    }

    // Método para contar el número de personal de tropa
    public int contarPersonal() {
        return dao.contarPersonal();
    }
}
