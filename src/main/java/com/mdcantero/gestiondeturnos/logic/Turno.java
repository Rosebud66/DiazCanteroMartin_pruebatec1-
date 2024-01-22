package com.mdcantero.gestiondeturnos.logic;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.mdcantero.gestiondeturnos.util.EnumEstadoTurno;

@Entity
public class Turno implements Serializable {

    // ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String numeroTurno;
    private LocalDate fecha;
    private String descripcionTramite;
    
    
    @Enumerated(EnumType.STRING)
    private EnumEstadoTurno estado;

    @ManyToOne
    @JoinColumn(name = "ciudadano_id")
    private Ciudadano ciudadano;

    // CONSTRUCTOR CON ID
    public Turno(int id, String numeroTurno, LocalDate fecha, String descripcionTramite, EnumEstadoTurno estado, Ciudadano ciudadano) {
        this.id = id;
        this.numeroTurno = numeroTurno;
        this.fecha = fecha;
        this.descripcionTramite = descripcionTramite;
        this.estado = estado;
        this.ciudadano = ciudadano;
    }

    // CONSTURCTOR SIN ID
    public Turno(String numeroTurno, LocalDate fecha, String descripcionTramite, EnumEstadoTurno estado, Ciudadano ciudadano) {
        this.numeroTurno = numeroTurno;
        this.fecha = fecha;
        this.descripcionTramite = descripcionTramite;
        this.estado = estado;
        this.ciudadano = ciudadano;
    }

    // CONSTRUCTOR VACÍO
    public Turno() {
    }

    // GETTERS
    public int getId() {
        return id;
    }

    public String getNumeroTurno() {
        return numeroTurno;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getDescripcionTramite() {
        return descripcionTramite;
    }

    public EnumEstadoTurno getEstado() {
        return estado;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    // SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setNumeroTurno(String numeroTurno) {     
        this.numeroTurno = numeroTurno;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setDescripcionTramite(String descripcionTramite) {
        this.descripcionTramite = descripcionTramite;
    }

    public void setEstado(EnumEstadoTurno estado) {
        this.estado = estado;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    // TOSTRING
    @Override
    public String toString() {
        return "Turno{" + "id=" + id + ", numeroTurno=" + numeroTurno + ", fecha=" + fecha + ", descripcionTramite=" + descripcionTramite + ", estado=" + estado + ", ciudadano=" + ciudadano + '}';
    }

}
