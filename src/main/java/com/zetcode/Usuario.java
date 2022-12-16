package com.zetcode;

import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private Partida partida;

    public Usuario(String pNombre) {
        nombre = pNombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Partida obtenerPartida() {
        return partida;
    }

    public void setPartida(Partida pPartida) {
        partida = pPartida;
    }

    private int obtPuntosPartida() {
        // TODO
        return 0;
    }

    private String getNomrbe() {
        // TODO
        return "";
    }

    private ArrayList<Premio> obtListaPremios() {
        // TODO
        return null;
    }
}
