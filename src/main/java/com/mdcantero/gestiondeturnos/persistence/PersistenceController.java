package com.mdcantero.gestiondeturnos.persistence;

import com.mdcantero.gestiondeturnos.logic.Ciudadano;
import com.mdcantero.gestiondeturnos.logic.Turno;
import com.mdcantero.gestiondeturnos.persistence.exceptions.NonexistentEntityException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mdcantero.gestiondeturnos.util.EnumEstadoTurno;

public class PersistenceController {

    private CiudadanoJpaController ciudadanoJpa = new CiudadanoJpaController();
    private TurnoJpaController turnoJpa = new TurnoJpaController();

    public void crearTurno(Turno turno) {
        turnoJpa.create(turno);
    }

    public Ciudadano buscarCiudadanoPorId(int id) {
        return ciudadanoJpa.findCiudadano(id);
    }

    public List<Turno> traerTurnos() {
        return turnoJpa.findTurnoEntities();
    }

    public boolean existeTurno(int id) {
        return turnoJpa.findTurno(id) != null;
    }

    public void borrarTurno(int idEliminar) {
        try {
            turnoJpa.destroy(idEliminar);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Turno buscarTurno(int id) {
        return turnoJpa.findTurno(id);
    }

    public void editarTurno(Turno turno) {
        try {
            turnoJpa.edit(turno);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Turno> filtrarTurnosPorEstado(EnumEstadoTurno estado) {
        return turnoJpa.findTurnoByEstado(estado);
    }

    public List<Turno> filtrarTurnosPorFecha(LocalDate fecha) {
        return turnoJpa.findTurnoByFecha(fecha);
    }
}
