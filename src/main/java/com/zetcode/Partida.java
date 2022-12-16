package com.zetcode;

import java.util.ArrayList;

import org.json.JSONObject;

public class Partida {
    private int fichasColocadas;
    private int filasEliminadas;
    private int tetrisHechos;
    private ArrayList<Premio> premios;
    private int puntos;
    private int idPartida;
    private ArrayList<Ficha> listaFichas;
    private String estadoTablero;

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

    public int obtenerId() {
        return this.idPartida;
    }

    public String obtenerEstadoTablero() {
		return this.estadoTablero;
	}

    public void setPuntosPartida(int pPuntos) {
		this.puntos = pPuntos;
	}
    
    public void setIdPartida(int pIdPartida) {
		this.idPartida = pIdPartida;
	}

    private void anadirListaFichas(ArrayList<Ficha> listaFichas) {
        // TODO
    }

    public void setEstadoTablero(String pEstadoTablero) {
		this.estadoTablero = pEstadoTablero;
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
	
    public void anadirPremio(Premio pPremio) {
        this.premios.add(pPremio);
    }
}
