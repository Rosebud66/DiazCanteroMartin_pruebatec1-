<%@page import="java.util.List"%>
<%@page import="com.mdcantero.gestiondeturnos.logic.Turno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Lista de Turnos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

        <script>
            function goBack() {
                window.history.back();
            }
        </script>
    </head>
    <body class="bg-light d-flex align-items-center justify-content-center p-5">
        <div class="text-center text-dark">
            <h1 class="display-5">LISTA DE TURNOS</h1>

            <!-- FILTRAR POR ESTADO -->
            <form action="SvFiltrarFecha" method="post" class="mb-3">
                <label for="fechaFiltro" class="form-label">Filtrar por Fecha:</label>
                <input type="date" id="fecha" name="fecha" class="form-control">
                <button type="submit" class="btn btn-sm btn-primary">Filtrar por Fecha</button>
            </form>

            <!-- FILTRADO POR ESTADO -->
            <form action="SvFiltrarEstado" method="post" class="mb-3">
                <label for="estado" class="form-label">Filtrar por Estado:</label>
                <select id="estado" name="estado" class="form-select">
                    <option value="EN_ESPERA">En espera</option>
                    <option value="YA_ATENDIDO">Ya atendido</option>
                </select>
                <button type="submit" class="btn btn-sm btn-primary mt-3">Filtrar</button>
            </form>

            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Número de Turno</th>
                        <th>Fecha</th>
                        <th>Descripción del Trámite</th>
                        <th>Estado</th>
                        <th>Ciudadano</th>
                    </tr>
                </thead>

                <tfoot>
                    <tr>
                        <th>ID</th>
                        <th>Número de Turno</th>
                        <th>Fecha</th>
                        <th>Descripción del Trámite</th>
                        <th>Estado</th>
                        <th>Ciudadano</th>                       
                    </tr>
                </tfoot>
                <%
                    // Obtenemos el atributo listaTurnos de nuestra sesion, se almacena en Lista de tipo Turno
                    List<Turno> listaTurnos = (List<Turno>) request.getSession().getAttribute("listaTurnos");
                %>
                <tbody>

                    <%
                        // Iteramos sobre la lista de turnos
                        for (Turno turno : listaTurnos) 
                    {%>
                    <tr>
                        <td><%=turno.getId()%></td>
                        <td><%=turno.getNumeroTurno()%></td>
                        <td><%=turno.getFecha()%></td>
                        <td><%=turno.getDescripcionTramite()%></td>
                        <td><%=turno.getEstado()%></td>
                        <td><%=turno.getCiudadano()%></td>  
                       
                    </tr>
                    <%}%>

                </tbody>
            </table>
            <button onclick="goBack()" class="btn btn-sm btn-secondary">Volver Atrás</button>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    </body>
</html>




