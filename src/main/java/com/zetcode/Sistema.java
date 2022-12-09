package com.zetcode;

public class Sistema {
    private static Sistema miSistema;
    private static GestorPremios miGestorPremios;
    private static GestorUsuarios miGestorUsuarios;
    private static GestorPartidas miGestorPartidas;

    // NO SE SI HACE FALTA PONER UN CONSTRUCTOR DE SISTEMA
    private Sistema() {
        GestorPremios miGestorPremios = GestorPremios.getMiGestorPremios();
        GestorUsuarios miGestorUsuarios = GestorUsuarios.getMiGestorUsuarios();
        GestorPartidas miGestorPartidas = GestorPartidas.getMiGestorPartidas();
    }
    public static Sistema getSistema() {
        if (miSistema == null) {
            miSistema = new Sistema();
        }
        return miSistema;
    }

    public void crearPartida(int nivel, String nomUsuario) {
        miGestorPartidas.crearPartida(2, "asd");
    }

}
