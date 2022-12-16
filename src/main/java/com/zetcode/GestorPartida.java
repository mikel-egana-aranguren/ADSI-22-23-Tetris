package com.zetcode;

import java.util.ArrayList;

public class GestorPartida {

    public static Integer fichasColocadas(Partida partida) {
        return partida.fichasColocadas();
    }

    public static Integer filasEliminadas(Partida partida) {
        return partida.filasEliminadas();
    }

    public static Integer tetrisHechos(Partida partida) {
        return partida.tetrisHechos();
    }

    public static void anadirPremios(Partida partida, ArrayList<Premio> premios) {
        partida.anadirPremios(premios);
    }

    public static ArrayList<Premio> obtenerPremios(Partida partida) {
        return partida.obtenerPremios();
    }

    public static Integer obtenerPuntos(Partida partida) {
        return partida.obtenerPuntos();
    }

    public static void addFilas(Partida partida, int filas) {
        partida.addFilas(filas);
    }

    public static void addTetrises(Partida partida, int tetrises) {
        partida.addTetrises(tetrises);
    }

    public static void contarFicha(Partida partida) {
        partida.contarFicha();
    }

    public static void addPuntos(Partida partida, int puntos) {
        partida.addPuntos(puntos);
    }
}
