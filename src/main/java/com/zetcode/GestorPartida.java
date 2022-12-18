package com.zetcode;

import java.util.ArrayList;

public class GestorPartida {

    public static int obtenerIdPartida(Partida pPartida) {
        return pPartida.obtenerId();
    }
    
    public static int obtenerPuntos(Partida pPartida) {
        return pPartida.obtenerPuntos();
    }
    
    public static String obtenerEstadoTablero(Partida pPartida) {
		return pPartida.obtenerEstadoTablero();
	}
    
    public static void setIdPartida(Partida pPartida, int pIdPartida) {
        pPartida.setIdPartida(pIdPartida);
    }
    
    public static void setPuntosPartida(Partida pPartida, int pPuntos) {
        pPartida.setPuntosPartida(pPuntos);
    }
    
    public static void setEstadoTablero(Partida pPartida, String pEstadoTablero) {
		pPartida.setEstadoTablero(pEstadoTablero);
	}

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
	
    public static void anadirPremioPartida(Partida pPartida, Premio premios) {
        pPartida.anadirPremio(premios);
    }

    public static ArrayList<Premio> obtenerPremios(Partida partida) {
        return partida.obtenerPremios();
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
