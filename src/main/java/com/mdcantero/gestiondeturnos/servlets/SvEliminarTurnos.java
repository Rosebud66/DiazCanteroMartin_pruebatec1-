package com.mdcantero.gestiondeturnos.servlets;

import com.mdcantero.gestiondeturnos.logic.Controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvEliminarTurnos", urlPatterns = {"/SvEliminarTurnos"})
public class SvEliminarTurnos extends HttpServlet {

    private final Controller control = new Controller();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener el ID a eliminar desde los parámetros de la solicitud
        String idEliminarStr = request.getParameter("idElim");

        // Verificar si el ID proporcionado es un número entero válido
        if (idEliminarStr != null && idEliminarStr.matches("\\d+")) {
            int idEliminar = Integer.parseInt(idEliminarStr);

            // Verificar si el turno con el ID dado existe antes de intentar eliminar
            if (control.existeTurno(idEliminar)) {
                // Si existe, realizar la eliminación
                control.borrarTurno(idEliminar);
                response.sendRedirect("index.jsp");
            } else {
                // Si no existe, redirigir a una página de error o hacer algo apropiado
                response.sendRedirect("error.jsp"); // Cambia "error.jsp" por la página que desees
            }
        } else {
            // Si el ID no es un número entero válido, redirigir a una página de error
            response.sendRedirect("error.jsp"); // Cambia "error.jsp" por la página que desees
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet que controla la eliminación de Turnos en base a una búsqueda por id";
    }

}
