package com.zetcode;

public class GestorBD {
    private static GestorBD miGestorBD;
    private GestorBD() {
        miGestorBD = new GestorBD();
    }
    public static GestorBD getMiGestorBD() {
        if (miGestorBD == null) {
            miGestorBD = new GestorBD();
        }
        return miGestorBD;
    }
}
