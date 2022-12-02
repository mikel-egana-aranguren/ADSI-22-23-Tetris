package com.zetcode;

import java.util.ArrayList;

public class Partida {
    private int fichasColocadas;
    private int filasEliminadas;
    private int tetrisHechos;
    private ArrayList<Premio> premios;
    private int puntos;
    private int idPartida;
    private ArrayList<Ficha> listaFichas;

    public int fichasColocadas() {
        int fichas = fichasColocadas;
        resetearContadorFichas();
        return fichas;
    }

    private void resetearContadorFichas() {
        fichasColocadas = 0;
    }

    public int filasEliminadas() {
        int filas = filasEliminadas;
        resetearContadorFilas();
        return filas;
    }

    private void resetearContadorFilas() {
        filasEliminadas = 0;
    }

    public int tetrisHechos() {
        int tetrises = tetrisHechos;
        resetearContadorTetris();
        return tetrises;
    }

    private void resetearContadorTetris() {
        tetrisHechos = 0;
    }

    public void anadirPremios(ArrayList<Premio> premios) {
        // TODO
    }
    
    public int obtenerPuntos() {
        return puntos;
    }

    public ArrayList<Premio> obtenerPremios() {
        return premios;
    }

    private int obtenerId() {
        // TODO
        return 0;
    }

    private String obtenerEstadoTablero() {
        // TODO
        return "";
    }

    private void setPuntosPartida(int i1) {
        // TODO
    }
    
    private void setIdPartida(int i1) {
        // TODO
    }

    private void anadirListaFichas(ArrayList<Ficha> listaFichas) {
        // TODO
    }
}
