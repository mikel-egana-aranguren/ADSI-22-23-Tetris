package com.zetcode;

public class GestorPartidas {
    private static GestorPartidas miGestorPartidas;
    private GestorPartidas() {
        miGestorPartidas = new GestorPartidas();
    }
    public static GestorPartidas getMiGestorPartidas() {
        if (miGestorPartidas == null) {
            miGestorPartidas = new GestorPartidas();
        }
        return miGestorPartidas;
    }

    public void crearPartida(int nivel, String nomUsuario) {

    }
    public int getMaximaPuntuacion(String codPartida, String nomUsuario) {

    }
    public int getResultadosPartida(String codPartida, String nomUsuario) {

    }

    public void recuperarPartida(){

    }

}
