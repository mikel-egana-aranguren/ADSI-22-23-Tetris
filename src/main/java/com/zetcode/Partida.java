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
    
    }

    private int fichasColocadas() {
        // TODO
        return 0;
    }

    private void resetearContadorFichas() {
        // TODO
    }

    private int filasEliminadas() {
        // TODO
        return 0;
    }

    private void resetearContadorFilas() {
        // TODO
    }

    private int tetrisHechos() {
        // TODO
        return 0;
    }

    private void resetearContadorTetris() {
        // TODO
    }

    private void anadirPremios(ArrayList<Premio> premios) {
        // TODO
    }
    
    public int obtenerPuntos() {
        return this.puntos;
    }

    private ArrayList<Premio> obtenerPremios() {
        // TODO
        return null;
    }

    prublic int obtenerId() {
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
}
