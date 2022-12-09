package com.zetcode;
import java.awt.*;
import java.sql.*;

public class GestorBD {
    private static GestorBD miGestorBD;
    private String urlConexion = "jdbc:mysql://localhost:3306/Tetris";
    private String usuario = "admin";
    private String contrasena = "root";

    public static GestorBD getMiGestorBD() {
        if (miGestorBD == null) {
            miGestorBD = new GestorBD();
        }
        return miGestorBD;
    }


    public static void main(String[] args) {
        GestorBD g = getMiGestorBD();
        g.crearPartida();
    }


    public void crearPartida() {
        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    urlConexion,
                    usuario, contrasena);

            // mydb is database
            // mydbuser is name of database
            // mydbuser is password of database

            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(
                    "select * from Usuario");
            String code;
            String title;
            while (resultSet.next()) {
                code = resultSet.getString("NombreUsuario");
                //title = resultSet.getString("NombreUsuario").trim();
                System.out.println("Code : " + code);
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
