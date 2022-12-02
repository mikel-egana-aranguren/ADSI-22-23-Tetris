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
        // TODO
        return null;
    }

    public String getNombreUsuario(Usuario a1) {
        //TODO
        return "";
    }

    public Partida obtenerPartidaUsuario(Usuario a1) {
        // TODO
        return null;
    }
}
