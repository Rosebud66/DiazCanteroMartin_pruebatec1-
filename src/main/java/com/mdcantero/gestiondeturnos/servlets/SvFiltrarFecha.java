package com.mdcantero.gestiondeturnos.servlets;

import com.mdcantero.gestiondeturnos.logic.Controller;
import com.mdcantero.gestiondeturnos.logic.Turno;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvFiltrarFecha", urlPatterns = {"/SvFiltrarFecha"})
public class SvFiltrarFecha extends HttpServlet {

    private final Controller control = new Controller();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    // En SvFiltrarFecha
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fechaString = request.getParameter("fecha");
        // convertir String a LocalDate
        LocalDate fecha = LocalDate.parse(fechaString);
        List<Turno> listaFiltrada = control.filtrarTurnosPorFecha(fecha);
        request.getSession().setAttribute("listaTurnos", listaFiltrada);
        // Redireccionar a la página de visualización de turnos
        response.sendRedirect("verTurnos.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Servlet que controla el filtrado de Turnos en base al atributo fecha";
    }

}
