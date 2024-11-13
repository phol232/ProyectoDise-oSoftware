package Capa_Negocio;

import Capa_Datos.ingresosDAO;
import Capa_Datos.ingresos;
import java.util.List;

public class neg_ingreso {

    private ingresosDAO ingresoDAO;

    // Constructor
    public neg_ingreso() {
        ingresoDAO = new ingresosDAO();
    }

    public boolean agregarIngreso(String idIngreso, String idUsuario, double monto, String fechaIngreso, String tipoIngreso, String descripcion) {
    // Llamar al método del DAO para guardar los datos
    ingresosDAO dao = new ingresosDAO();
    return dao.insertarIngreso(new ingresos(idIngreso, idUsuario, monto, fechaIngreso, tipoIngreso, descripcion));
}

public boolean actualizarIngreso(String idIngreso, String idUsuario, double monto, String fechaIngreso, String tipoIngreso, String descripcion) {
    // Llamar al método del DAO para actualizar los datos
    ingresosDAO dao = new ingresosDAO();
    return dao.actualizarIngreso(new ingresos(idIngreso, idUsuario, monto, fechaIngreso, tipoIngreso, descripcion));
}


    // Método para eliminar un ingreso
    public boolean eliminarIngreso(String idIngreso) {
        // Validar campos obligatorios
        if (idIngreso == null || idIngreso.isEmpty()) {
            System.err.println("El ID del ingreso es obligatorio.");
            return false;
        }

        // Llamar al método de la capa de datos
        return ingresoDAO.eliminarIngreso(idIngreso);
    }

    // Método para listar ingresos simplificados
    public List<ingresos> listarIngresos() {
        // Llamar al método de la capa de datos
        return ingresoDAO.listarIngresosSimplificados();
    }
}
