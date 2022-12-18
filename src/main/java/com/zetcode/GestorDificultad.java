package com.zetcode;

public class GestorDificultad {
	
	// Devuelve la dificultad seleccionada 0, 1 o 2
	public static int getDificultad() {
		return MenuDificultad.dificultad;
	}
	
	// Cambia los valores de alto y ancho del tablero y la velocidad de las fichas en funcion de la dificultad
	public static void actualizarDificultad() {
    	if(getDificultad() == 0) {
    		Dificultad.setBOARD_WIDTH(15);
    	    Dificultad.setBOARD_HEIGHT(27);
    	    Dificultad.setPERIOD_INTERVAL(400);
    	} else if(getDificultad() == 1) {
    	    Dificultad.setBOARD_WIDTH(15);
    	    Dificultad.setBOARD_HEIGHT(22);
    	    Dificultad.setPERIOD_INTERVAL(300);
    	} else if(getDificultad() == 2) {
    		Dificultad.setBOARD_WIDTH(10);
    		Dificultad.setBOARD_HEIGHT(22);
    		Dificultad.setPERIOD_INTERVAL(150);
    	}
    }
}
