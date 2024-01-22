<%@page import="com.mdcantero.gestiondeturnos.util.EnumEstadoTurno"%>
<%@page import="com.mdcantero.gestiondeturnos.logic.Turno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Editar Turno</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
    <body class="bg-light d-flex align-items-center justify-content-center vh-100">
        <div class="text-center text-dark">
            <h1 class="display-4">Editar Turno</h1>

            <%
                Turno turno = (Turno) request.getSession().getAttribute("turno");
            %>

            <form action="SvEditarTurnos" method="POST">

                <!-- FECHA -->
                <div class="mb-3">
                    <label for="fecha" class="form-label">Fecha:</label>
                    <input type="date" id="fecha" name="fecha" class="form-control" value="<%=turno.getFecha()%>">
                </div>

                <!-- DESCRIPCIÓN TRÁMITE -->
                <div class="mb-3">
                    <label for="descripcionTramite" class="form-label">Descripción del Trámite:</label>
                    <textarea id="descripcionTramite" name="descripcionTramite" rows="4" class="form-control"><%=turno.getDescripcionTramite()%></textarea>
                </div>

                <!-- ESTADO -->
                <div class="mb-3">
                    <label for="estado" class="form-label">Estado:</label>
                    <select id="estado" name="estado" class="form-select">
                        <option value="<%= EnumEstadoTurno.EN_ESPERA.name()%>" <%= turno.getEstado().equals(EnumEstadoTurno.EN_ESPERA.name()) ? "selected" : ""%>>En espera</option>
                        <option value="<%= EnumEstadoTurno.YA_ATENDIDO.name()%>" <%= turno.getEstado().equals(EnumEstadoTurno.YA_ATENDIDO.name()) ? "selected" : ""%>>Ya atendido</option>
                    </select>
                </div>

                <!-- CIUDADANO -->
                <div class="mb-3">
                    <label for="ciudadano_id" class="form-label">ID del Ciudadano:</label>
                    <input type="number" id="ciudadano_id" name="ciudadano_id" class="form-control" value="<%=turno.getCiudadano().getId()%>">
                </div>

                <!-- ENVIAR FORMULARIO -->
                <button type="submit" class="btn btn-danger">Editar Turno</button>
            </form>

            <button class="btn btn-dark" onclick="goBack()">Volver Atrás</button>
        </div>
        <script>
            function goBack() {
                window.history.back();
            }
        </script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    </body>
</html>
