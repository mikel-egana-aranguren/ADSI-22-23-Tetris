package com.zetcode;

import java.sql.ResultSet;

public class prueba {

	public static void main(String[] args) {
		//SGBD.inicializarTest();
		System.out.println("SELECTING..."); 
        ResultSet result = SGBD.execResultSQL("SELECT * FROM USUARIO");
        System.out.println("SELECTED...");
        try {
        	while (result.next()) {
        		System.out.println(result.getString("nombreUsuario"));
        		System.out.println(result.getString("contrasena"));
        		System.out.println(result.getString("email"));
			} 
        } catch(Exception e) {
            e.printStackTrace();
            System.err.println("Ha habido un problema");
        }
	}
}