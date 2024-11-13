package Capa_Datos;

public class ingresos {
    private String idIngreso;
    private String idUsuario;
    private double monto;
    private String fuente; // Este puede ser opcional
    private String fechaIngreso;
    private String tipoIngreso;
    private String descripcion; // Este puede ser opcional
    
    public ingresos() {
     
    }
    // Constructor con todos los campos
    public ingresos(String idIngreso, String idUsuario, double monto, String fechaIngreso, String tipoIngreso, String descripcion) {
        this.idIngreso = idIngreso;
        this.idUsuario = idUsuario;
        this.monto = monto;
        this.fechaIngreso = fechaIngreso;
        this.tipoIngreso = tipoIngreso;
        this.descripcion = descripcion;
    }

    // Constructor para simplificados (sin fuente y descripción)
    public ingresos(String idIngreso, String idUsuario, double monto, String fechaIngreso, String tipoIngreso) {
        this.idIngreso = idIngreso;
        this.idUsuario = idUsuario;
        this.monto = monto;
        this.fechaIngreso = fechaIngreso;
        this.tipoIngreso = tipoIngreso;
        this.descripcion = null; // Descripción opcional
    }

    // Getters y setters
    public String getIdIngreso() {
        return idIngreso;
    }

    public void setIdIngreso(String idIngreso) {
        this.idIngreso = idIngreso;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getTipoIngreso() {
        return tipoIngreso;
    }

    public void setTipoIngreso(String tipoIngreso) {
        this.tipoIngreso = tipoIngreso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
