package com.mdcantero.gestiondeturnos.servlets;

import com.mdcantero.gestiondeturnos.logic.Controller;
import com.mdcantero.gestiondeturnos.logic.Turno;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.http.HttpSession;
import com.mdcantero.gestiondeturnos.util.EnumEstadoTurno;
import com.mdcantero.gestiondeturnos.util.NumeroTurnoGenerator;
import com.mdcantero.gestiondeturnos.util.TurnoValidator;

@WebServlet(name = "SvTurnos", urlPatterns = {"/SvTurnos"})
public class SvTurnos extends HttpServlet {

    private final Controller control = new Controller();
    private final NumeroTurnoGenerator numTurnoGenerator = new NumeroTurnoGenerator();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Turno> listaTurnos = control.traerTurnos();

        HttpSession mySession = request.getSession();
        mySession.setAttribute("listaTurnos", listaTurnos);

        response.sendRedirect("verTurnos.jsp");

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

        // NÚMERO TURNO
        // Se genera un número de turno aleatorio conformado por char e int
        String numeroTurno = numTurnoGenerator.generarNumeroTurno();

        control.crearTurno(numeroTurno, fecha, descripcionTramite, estado, ciudadano_id);

        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Servlet que controla la creación de turnos";
    }

}
