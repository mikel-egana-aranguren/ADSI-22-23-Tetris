package com.zetcode;

public class GestorUsuarios {
    private static GestorUsuarios miGestorUsuarios;
    private GestorUsuarios() {
        miGestorUsuarios = new GestorUsuarios();
    }
    public static GestorUsuarios getMiGestorUsuarios() {
        if (miGestorUsuarios == null) {
            miGestorUsuarios = new GestorUsuarios();
        }
        return miGestorUsuarios;
    }

    public void anadirPartida(String nomUsuario, PARTIDA NO ES UNA CLASE) {

    }

    public Boolean comprobarUsuario(String nomUsu, String pwd){

    }
    public Boolean comprobarContrasena(String pwd, String pwd2){

    }

    public Boolean existeUsuario(String nomUsu){

    }
    public void personalizacion(String colorFondo, String colorBloques, int volumen, String sonidoAcciones){

    }

    public JsonObject obtenerRankingAbsPersonal(){

    }
    public JsonObject obtenerRankingAbsGlobal(){

    }
    public JsonObject obtenerRankingPorNivelPersonal(){

    }
    public JsonObject obtenerRankingPorNivelGlobal(){

    }
}
