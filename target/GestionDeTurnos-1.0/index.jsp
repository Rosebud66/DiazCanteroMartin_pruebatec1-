<%@page import="com.mdcantero.gestiondeturnos.util.EnumEstadoTurno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Agregar Turno</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <style>
            body {
                overflow-x: hidden;
            }
            .scroll-container {
                max-height: 100vh;
                overflow-y: auto;
            }
        </style>
    </head>
    <body class="bg-light d-flex align-items-center justify-content-center flex-column">
        <div class="text-center text-dark">
            <h1 class="display-4">Agregar Turno</h1>
            <p class="lead">Apartado para dar de alta nuevos turnos</p>

            <form action="SvTurnos" method="post">

                <!-- FECHA -->
                <div class="mb-2">
                    <label for="fecha" class="form-label">Fecha:</label>
                    <input type="date" id="fecha" name="fecha" class="form-control" required>
                </div>

                <!-- DESCRIPCIÓN TRÁMITE -->
                <div class="mb-2">
                    <label for="descripcionTramite" class="form-label">Descripción del Trámite:</label>
                    <textarea id="descripcionTramite" name="descripcionTramite" rows="2" class="form-control" required></textarea>
                </div>

                <!-- ESTADO -->
                <div class="mb-2">
                    <label for="estado" class="form-label">Estado:</label>
                    <select id="estado" name="estado" class="form-select" required>
                        <option value="<%= EnumEstadoTurno.EN_ESPERA.name()%>">En espera</option>
                        <option value="<%= EnumEstadoTurno.YA_ATENDIDO.name()%>">Ya atendido</option>
                    </select>
                </div>

                <!-- CIUDADANO -->
                <div class="mb-2">
                    <label for="ciudadano_id" class="form-label">ID del Ciudadano:</label>
                    <input type="number" id="ciudadano_id" name="ciudadano_id" class="form-control" required>
                </div>

                <!-- ENVIAR FORMULARIO -->
                <button type="submit" class="btn btn-danger">Guardar Turno</button>
            </form>


            <!-- CONSULTAR -->
            <h1 class="mt-3">CONSULTAR TURNOS</h1>
            <form action="SvTurnos" method="GET">
                <button type="submit" class="btn btn-dark">
                    Ver Turnos
                </button>
            </form>

            <!-- ELIMINAR -->
            <h1 class="mt-3">ELIMINAR TURNOS</h1>
            <form action="SvEliminarTurnos" method="POST">
                <div class="mb-2">
                    <input type="number" id="idElim" name="idElim" placeholder="Id eliminar" class="form-control" required>
                </div>
                <button type="submit" class="btn btn-dark">
                    Eliminar turnos
                </button>
            </form>

            <!-- EDITAR -->
            <h1 class="mt-3">EDITAR TURNOS</h1>
            <form action="SvEditarTurnos" method="GET">
                <div class="mb-2">
                    <input type="number" id="idEdit" name="idEdit" placeholder="Id editar" class="form-control" required>
                </div>
                <button type="submit" class="btn btn-dark">
                    Editar turnos
                </button>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    </body>
</html>
