package com.mdcantero.gestiondeturnos.logic;

import com.mdcantero.gestiondeturnos.persistence.PersistenceController;
import java.time.LocalDate;
import java.util.List;
import com.mdcantero.gestiondeturnos.util.EnumEstadoTurno;

public class Controller {

    PersistenceController persisControl = new PersistenceController();

    // CREAR
    public void crearTurno(String numeroTurno, LocalDate fecha, String descripcionTramite, EnumEstadoTurno estado, int ciudadano_id) {

        Ciudadano ciudadano = persisControl.buscarCiudadanoPorId(ciudadano_id);

        persisControl.crearTurno(new Turno(numeroTurno, fecha, descripcionTramite, estado, ciudadano));

    }

    // LISTAR
    public List<Turno> traerTurnos() {
        return persisControl.traerTurnos();
    }

    //BORRAR
    public void borrarTurno(int idEliminar) {
        persisControl.borrarTurno(idEliminar);
    }
    
    // BUSCAR
    public Turno buscarTurno(int idEditar) {
        return persisControl.buscarTurno(idEditar);
    }

    // EDITAR
    public void editarTurno(Turno turno) {
        persisControl.editarTurno(turno);
    }

    // LISTAR POR ESTADO
    public List<Turno> filtrarTurnosPorEstado(EnumEstadoTurno estado) {
        return persisControl.filtrarTurnosPorEstado(estado);
    }

    // LISTAR POR FECHA
    public List<Turno> filtrarTurnosPorFecha(LocalDate fechaFiltro) {
        return persisControl.filtrarTurnosPorFecha(fechaFiltro);
    }

    // COMPROBAR SI EXISTE EN BASE A UN ID
    public boolean existeTurno(int id) {
       return persisControl.existeTurno(id);
    }

}
