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

    public JSONObject obtenerEstadoTablero() {
		JSONObject[] arrayDatosFichas = {};
		for (Ficha pFicha : listaFichas) {
			JSONObject datosFicha = pFicha.obtenerDatosFicha();
			arrayDatosFichas[arrayDatosFichas.length] = datosFicha;
		}
		JSONObject datosFichas = new JSONObject();
		datosFichas.put("estadoTablero", arrayDatosFichas);
		return datosFichas;
		
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

    public void setEstadoTablero(JSONObject pEstadoTableroJson) {
		JSONObject[] arrayFichasJson = (JSONObject[])pEstadoTableroJson.get("estadoTablero");
		for (JSONObject fichaJson : arrayFichasJson) {
			int posX = fichaJson.getInt("posX");
			int posY = fichaJson.getInt("posY");
			String color = fichaJson.getString("color"); 
			Ficha ficha = new Ficha(posX, posY, color);
			listaFichas.add(ficha);
		}
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
