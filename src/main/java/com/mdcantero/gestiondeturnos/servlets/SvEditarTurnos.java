package com.mdcantero.gestiondeturnos.servlets;

import com.mdcantero.gestiondeturnos.logic.Controller;
import com.mdcantero.gestiondeturnos.logic.Turno;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mdcantero.gestiondeturnos.util.EnumEstadoTurno;
import com.mdcantero.gestiondeturnos.util.TurnoValidator;

@WebServlet(name = "SvEditarTurnos", urlPatterns = {"/SvEditarTurnos"})
public class SvEditarTurnos extends HttpServlet {

    private final Controller control = new Controller();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idEditar = Integer.parseInt(request.getParameter("idEdit"));

        Turno turno = control.buscarTurno(idEditar);

        if (turno == null) {
            response.sendRedirect("error.jsp");
        } else {
            HttpSession mySession = request.getSession();
            mySession.setAttribute("turno", turno);
            response.sendRedirect("editarTurnos.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // FECHA (STRING)
        String fechaString = request.getParameter("fecha");
        // convertir String a LocalDate
        LocalDate fecha = LocalDate.parse(fechaString);

        // DESCRIPCIÓN TRÁMITE
        String descripcionTramite = request.getParameter("descripcionTramite");

        // ESTADO
        EnumEstadoTurno estado = EnumEstadoTurno.valueOf(request.getParameter("estado"));

        // IDCIUDADANO
        int ciudadano_id;
        try {
            ciudadano_id = Integer.parseInt(request.getParameter("ciudadano_id"));
            if (!TurnoValidator.isValidCiudadanoId(ciudadano_id)) {
                response.sendRedirect("error.jsp");
                return;
            }
        } catch (NumberFormatException e) {
            response.sendRedirect("error.jsp");
            return;
        }

        Turno turno = (Turno) request.getSession().getAttribute("turno");
        turno.setFecha(fecha);
        turno.setDescripcionTramite(descripcionTramite);
        turno.setEstado(estado);

        control.editarTurno(turno);

    }

    @Override
    public String getServletInfo() {
        return "Servlet que controla la edición de Turnos en base a una búsqueda por id";
    }

}
