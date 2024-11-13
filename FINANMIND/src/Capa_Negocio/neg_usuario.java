package Capa_Negocio;

import Capa_Datos.usuarios;
import Capa_Datos.usuariosDAO;
import javax.swing.JOptionPane;

/**
 * Clase de negocio para gestionar los usuarios
 */
public class neg_usuario {

    // Atributo del DAO
    private usuariosDAO dao;

    // Constructor
    public neg_usuario() {
        this.dao = new usuariosDAO();
    }

    // Método para agregar un nuevo usuario
    public boolean agregarUsuario(String idUsuario, String nombre, String contraseña, String email, String edad, String ocupacion, String fechaRegistro) {
        // Validar campos obligatorios
        if (idUsuario.isEmpty() || nombre.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ID, Nombre y Email son campos obligatorios");
            return false;
        }

        // Crear objeto usuario con los datos
        usuarios usuario = new usuarios(idUsuario, nombre, contraseña, email, edad, ocupacion, fechaRegistro);

        // Llamar al DAO para guardar el usuario
        boolean resultado = dao.guardarUsuario(usuario);

        if (resultado) {
            JOptionPane.showMessageDialog(null, "Usuario agregado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al agregar el usuario.");
        }

        return resultado;
    }
    
    // Método para validar el inicio de sesión
    public boolean validarLogin(String idUsuario, String contraseña) {
        if (idUsuario.isEmpty() || contraseña.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Usuario y Contraseña no pueden estar vacíos.");
            return false;
        }

        // Validar las credenciales llamando al DAO
        return dao.validarUsuario(idUsuario, contraseña);
    }
}
