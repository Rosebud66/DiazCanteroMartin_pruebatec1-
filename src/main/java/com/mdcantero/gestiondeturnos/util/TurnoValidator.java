package com.mdcantero.gestiondeturnos.util;

public class TurnoValidator {

    public static boolean isValidCiudadanoId(int ciudadanoId) {
        return ciudadanoId > 0;
    }

    public static boolean isValidFecha(String fecha) {       
        return true;
    }

    public static boolean isValidDescripcionTramite(String descripcionTramite) {
        return descripcionTramite != null && !descripcionTramite.trim().isEmpty();
    }


}

