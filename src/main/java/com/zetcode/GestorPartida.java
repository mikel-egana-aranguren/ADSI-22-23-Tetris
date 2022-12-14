package com.zetcode;

import org.json.JSONObject;

public class GestorPartida {
	private static GestorPartida miGestorPartida = null;
	
	private GestorPartida() {
		
	}
	
	public static GestorPartida getGestorPartida() {
		if (miGestorPartida == null) {
			miGestorPartida = new GestorPartida();
		}
		return miGestorPartida;
	}
	
	public int obtenerIdPartida(Partida pPartida) {
		return pPartida.obtenerId();
	}
	
	public int obtenerPuntos(Partida pPartida) {
		return pPartida.obtenerPuntos();
	}
	
	public JSONObject obtenerEstadoTablero(Partida pPartida) {
		return pPartida.obtenerEstadoTablero();
	}
	
	public void setIdPartida(Partida pPartida, int pIdPartida) {
		pPartida.setIdPartida(pIdPartida);
	}
	
	public void setPuntosPartida(Partida pPartida, int pPuntos) {
		pPartida.setPuntosPartida(pPuntos);
	}
	
	public void setEstadoTablero(Partida pPartida, JSONObject pEstadoTableroJson) {
		pPartida.setEstadoTablero(pEstadoTableroJson);
	}
}
