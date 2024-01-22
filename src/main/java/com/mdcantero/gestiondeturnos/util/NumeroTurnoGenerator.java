package com.mdcantero.gestiondeturnos.util;

import java.util.Random;

public class NumeroTurnoGenerator {

    public String generarNumeroTurno() {
        // Obtener dos letras aleatorias del alfabeto
        String letrasAleatorias = generarLetrasAleatorias(2);

        // Obtener cinco números aleatorios del 0 al 9
        String numerosAleatorios = generarNumerosAleatorios(5);

        // Obtener otra letra aleatoria
        String letraAleatoriaFinal = generarLetrasAleatorias(1);

        // Combinar los elementos para formar el número de turno
        return letrasAleatorias + numerosAleatorios + letraAleatoriaFinal;
    }

    private String generarLetrasAleatorias(int cantidad) {
        Random random = new Random();
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < cantidad; i++) {
            char randomChar = (char) (random.nextInt(26) + 'A');
            resultado.append(randomChar);
        }

        return resultado.toString();
    }

    private String generarNumerosAleatorios(int cantidad) {
        Random random = new Random();
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < cantidad; i++) {
            int numeroAleatorio = random.nextInt(10);
            resultado.append(numeroAleatorio);
        }

        return resultado.toString();
    }
}
