/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Datos;

/**
 *
 * @author Taquiri Rojas Phol Edwin
 */
public class usuarios {
    private String idUsuario;
    private String nombre;
    private String contraseña;
    private String email;
    private String edad;
    private String ocupacion;
    private String fechaRegistro;
    
     // Constructor vacío
    public usuarios() {}

    // Constructor con parámetros
    public usuarios(String idUsuario, String nombre, String contraseña, String email, String edad, String ocupacion, String fechaRegistro) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.email = email;
        this.edad = edad;
        this.ocupacion = ocupacion;
        this.fechaRegistro = fechaRegistro;
    }

    // Getters y Setters
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    @Override
    public String toString() {
        return "Usuario{" +"idUsuario='" + idUsuario + '\'' +
            ", nombre='" + nombre + '\'' +
            ", contraseña='" + contraseña + '\'' +
            ", email='" + email + '\'' +
            ", edad='" + edad + '\'' +
            ", ocupacion='" + ocupacion + '\'' +
            ", fechaRegistro='" + fechaRegistro + '\'' +
            '}';
    }
}
