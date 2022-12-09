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

    public void anadirPartida(String nomUsuario) {

    }

    public Boolean comprobarUsuario(String nomUsu, String pwd){
        return null;
    }
    public Boolean comprobarContrasena(String pwd, String pwd2){
        return null;
    }

    public Boolean existeUsuario(String nomUsu){
        return null;
    }
    public void personalizacion(String colorFondo, String colorBloques, int volumen, String sonidoAcciones){

    }

    public String obtenerRankingAbsPersonal(){
        // NO HE PEUSTO QUE DEVUELVE STRING PARA PODER EJECUTAR LAS OTRAS CLASES SIN HACER ESTA TODAVIA
        return null;
    }
    public String obtenerRankingAbsGlobal(){
        return null;
    }
    public String obtenerRankingPorNivelPersonal(){
        return null;
    }
    public String obtenerRankingPorNivelGlobal(){
        return null;
    }
}
