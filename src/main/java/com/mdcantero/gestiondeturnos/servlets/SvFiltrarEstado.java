
package com.mdcantero.gestiondeturnos.servlets;

import com.mdcantero.gestiondeturnos.logic.Controller;
import com.mdcantero.gestiondeturnos.logic.Turno;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mdcantero.gestiondeturnos.util.EnumEstadoTurno;


@WebServlet(name = "SvFiltrarEstado", urlPatterns = {"/SvFiltrarEstado"})
public class SvFiltrarEstado extends HttpServlet {

    private final Controller control = new Controller();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");  
        
        EnumEstadoTurno estadoFiltrar = EnumEstadoTurno.valueOf(request.getParameter("estado"));
        List<Turno> listaFiltrada = control.filtrarTurnosPorEstado(estadoFiltrar);
        request.getSession().setAttribute("listaTurnos", listaFiltrada);
        // Redireccionar a la página de visualización de turnos
        response.sendRedirect("verTurnos.jsp");
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Servlet que controla el filtrado de Turnos en base al atributo estado";
    }

}
