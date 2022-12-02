package com.zetcode;

import java.util.ArrayList;

public class GestorPartida {

    public Integer fichasColocadas(Partida partida) {
        return partida.fichasColocadas();
    }

    public Integer filasEliminadas(Partida partida) {
        return partida.filasEliminadas();
    }

    public Integer tetrisHechos(Partida partida) {
        return partida.tetrisHechos();
    }

    public void anadirPremios(Partida partida, ArrayList<Premio> premios) {
        partida.anadirPremios(premios);
    }

    public ArrayList<Premio> obtenerPremios(Partida partida) {
        return partida.obtenerPremios();
    }

    public Integer obtenerPuntos(Partida partida) {
        return partida.obtenerPuntos();
    }
}
