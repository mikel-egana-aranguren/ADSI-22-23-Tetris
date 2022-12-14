package com.zetcode;

import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private Partida partida;
    
    public Usuario(String pNombre) {
		this.nombre = pNombre;
	}
    
    public String getNombre() {
		return this.nombre;
	}

    public Partida obtenerPartida() {
		return this.partida;
	}

    public void setPartida(Partida pPartida) {
        this.partida = pPartida;
    }

    private int obtPuntosPartida() {
        // TODO
        return 0;
    }

    private ArrayList<Premio> obtListaPremios() {
        // TODO
        return null;
    }
}
