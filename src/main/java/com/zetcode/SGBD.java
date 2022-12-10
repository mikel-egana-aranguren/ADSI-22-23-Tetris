package com.zetcode;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

public class SGBD {
    static boolean inicializado = false;
    static String DB_URL = "jdbc:h2:~/test";
    static String USER = "sa";
    static String PASS = "sa";

    public static Connection getConnection() {
        if (!inicializado) {
            SGBD.inicializar();
        }

        try {
            return DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    private static void inicializar() {
        String JDBC_DRIVER = "org.h2.Driver";
        try {
            Class.forName(JDBC_DRIVER);
        } catch (Exception e) {
            System.err.println("Error con los drivers de la base de datos. Cerrando el programa.");
            System.exit(1);
        }
        try {
            DB_URL = "jdbc:h2:" + new File("test").getCanonicalPath();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
