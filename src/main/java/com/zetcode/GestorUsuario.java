package com.zetcode;

import java.sql.ResultSet;

public class GestorUsuario {
    private Usuario usuarioActual;
    private static GestorUsuario miGestor;
    
    public void registrarse(String usu, String email, String pwd1) {
	    //SGBD.inicializarTest();
	    String existe = String.format("SELECT nombreUsuario FROM USUARIO WHERE nombreUsuario = '%s'", usu);
	    ResultSet result = SGBD.execResultSQL(existe);
	    String consulta =  String.format("INSERT INTO USUARIO VALUES ('%s', '%s', '%s')", usu,pwd1,email);
		SGBD.execVoidSQL(consulta);
    }
    
    public boolean existeUsuario(String usu) {
    	String existe = String.format("SELECT nombreUsuario FROM USUARIO WHERE nombreUsuario = '%s'", usu);
	    ResultSet result = SGBD.execResultSQL(existe);
	    try {
	    	if (result.next()) {
	    		return true;
	    	} else {
				return false;
			}
    	} catch (Exception e) {
			System.exit(1);
			return false;
		}
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