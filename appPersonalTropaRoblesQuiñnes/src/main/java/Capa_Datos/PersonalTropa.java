package Capa_Datos;

import java.util.Date;

/**
 *
 * @author LAB-01-LV
 */
public class PersonalTropa {
    // Atributos
    private String idTropa;
    private String nomApe;
    private Date fechaNac;
    private String rango;
    private String aPromo;
    private String mesPromo;
    private String cuerpo;
    private String grupoAereo;
    private Date fechaReg;

    // Constructor vacío
    public PersonalTropa() {
    }

    // Constructor con parámetros
    public PersonalTropa(String idTropa, String nomApe, Date fechaNac, String rango, String aPromo, String mesPromo, String cuerpo, String grupoAereo, Date fechaReg) {
        this.idTropa = idTropa;
        this.nomApe = nomApe;
        this.fechaNac = fechaNac;
        this.rango = rango;
        this.aPromo = aPromo;
        this.mesPromo = mesPromo;
        this.cuerpo = cuerpo;
        this.grupoAereo = grupoAereo;
        this.fechaReg = fechaReg;
    }

    // Getters y Setters
    public String getIdTropa() {
        return idTropa;
    }

    public void setIdTropa(String idTropa) {
        this.idTropa = idTropa;
    }

    public String getNomApe() {
        return nomApe;
    }

    public void setNomApe(String nomApe) {
        this.nomApe = nomApe;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public String getaPromo() {
        return aPromo;
    }

    public void setaPromo(String aPromo) {
        this.aPromo = aPromo;
    }

    public String getMesPromo() {
        return mesPromo;
    }

    public void setMesPromo(String mesPromo) {
        this.mesPromo = mesPromo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public String getGrupoAereo() {
        return grupoAereo;
    }

    public void setGrupoAereo(String grupoAereo) {
        this.grupoAereo = grupoAereo;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    // Método para mostrar información del personal de tropa (opcional)
    @Override
    public String toString() {
        return "PersonalTropa{" + "idTropa=" + idTropa + ", nomApe=" + nomApe + ", fechaNac=" + fechaNac + ", rango=" + rango + ", aPromo=" + aPromo + ", mesPromo=" + mesPromo + ", cuerpo=" + cuerpo + ", grupoAereo=" + grupoAereo + ", fechaReg=" + fechaReg + '}';
    }
}
