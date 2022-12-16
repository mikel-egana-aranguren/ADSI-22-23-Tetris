package com.zetcode;

public class GestorUsuario {
    private Usuario usuarioActual;
    private static GestorUsuario miGestor;

    private GestorUsuario() {

    }

    public static GestorUsuario getGestor() {
        if (miGestor == null) {
            miGestor = new GestorUsuario();
        }

        return miGestor;
    }

    public Usuario obtenerUsuarioActual() {
        return usuarioActual;
    }

    public String getNombreUsuario(Usuario a1) {
        //TODO
        return a1.getNombre();
    }

    public Partida obtenerPartidaUsuario(Usuario a1) {
        return a1.obtenerPartida();
    }

    public void setUsuario(Usuario usu) {
      // TODO: Esto lo he puesto para un test
      usuarioActual = usu;
    }
}
