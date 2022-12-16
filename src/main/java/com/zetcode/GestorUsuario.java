package com.zetcode;

public class GestorUsuario {
    private Usuario usuarioActual;
    private static GestorUsuario miGestorUsuario;
    
    private GestorUsuario() {
        
    }
    
    public static GestorUsuario getGestor() {
        if (miGestorUsuario == null) {
            miGestorUsuario = new GestorUsuario();
        }

        return miGestorUsuario;
    }
    
    public String getNombreUsuario(Usuario pUsuario) {
        return pUsuario.getNombre();
    }
    
    public Partida obtenerPartidaUsuario(Usuario pUsuario) {
        return pUsuario.obtenerPartida();
    }
    
    public void setPartidaUsuario(Usuario pUsuario, Partida pPartida) {
        pUsuario.setPartida(pPartida);
    }

    public Usuario obtenerUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuario(Usuario usu) {
      // TODO: Esto lo he puesto para un test
      usuarioActual = usu;
    }
}
