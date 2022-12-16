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

    public Partida() {
        premios = new ArrayList<Premio>();
    }

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

    public void anadirPremios(ArrayList<Premio> pPremios) {
        premios.addAll(pPremios);
    }
    
    public int obtenerPuntos() {
        return puntos;
    }

    public void addPuntos(int pPuntos) {
        puntos += pPuntos;
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

    public void addFilas(int filas) {
        filasEliminadas += filas;
    }

    public void addTetrises(int tetrises) {
        tetrisHechos += tetrises;
    }

    public void contarFicha() {
        fichasColocadas += 1;
    }
}
