package com.zetcode;

public class GestorPremios {
    private static GestorPremios miGestorPremios;
    private GestorPremios() {
        miGestorPremios = new GestorPremios();
    }
    public static GestorPremios getMiGestorPremios() {
        if (miGestorPremios == null) {
            miGestorPremios = new GestorPremios();
        }
        return miGestorPremios;
    }

    public String premioPartida(String codPartida, String nomUsuario) {
        return null;
    }

    public Boolean hayLogros(){
        return true;
    }

    public String obtenerLogro(){
        return null;
    }
}
