package com.zetcode;
import java.sql.*;

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

    public crearPartida() {
        Class.forName("com.mysql.jdbc.Driver");
    }
}
