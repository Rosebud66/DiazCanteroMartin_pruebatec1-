
package com.mdcantero.gestiondeturnos.logic;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ciudadano implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String nombre;

    @OneToMany(mappedBy = "ciudadano", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Turno> turnos;
    
    // CONSTRUCTOR CON ID
    public Ciudadano(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // CONSTRUCTOR SIN ID
    public Ciudadano(String nombre) {
        this.nombre = nombre;
    }

    public Ciudadano() {
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    /*
    @Override
    public String toString() {
        return "Ciudadano{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    */
    
    
    
}
