package com.zetcode;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.net.URLEncoder;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
Java Tetris game clone

Author: Jan Bodnar
Website: https://zetcode.com
 */
public class Tetris extends JFrame {
    private static final Logger logger = LogManager.getLogger(Tetris.class);
    private JLabel statusbar;
    private static Tetris miTetris = null;
    
    public static Tetris getTetris() {
    	if (miTetris == null) {
    		miTetris = new Tetris();
    	}
    	return miTetris;
    }
    
    public void start() {
        EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    miTetris.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }
    
    public void close() {
    	miTetris.dispose();
    }

    private Tetris() {
        initUI();
    }

    private void initUI() {
        statusbar = new JLabel(" 0");
        add(statusbar, BorderLayout.SOUTH);

        var board = new Board(this);
        add(board);
        board.start();

        setTitle("Tetris");
        setSize(200, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    JLabel getStatusBar() {
        return statusbar;
    }

    public static void main(String[] args) {
        logger.info("Playing");
        Boolean partida = true;
        try {
            String lanzadorDeExcepciones = args[0];

            SGBD.inicializarTest();
            SGBD.execVoidSQL("INSERT INTO USUARIO(nombreUsuario,contrasena,email) VALUES ('usuariotest','contr','test@gmail.com')");
            GestorUsuario gu = GestorUsuario.getGestor();
            Usuario usu = new Usuario("usuariotest");
            Partida par = new Partida();
            usu.setPartida(par);
            gu.setUsuario(usu);

            if (args[0].equals("test1")) {
                GestorPartida.addFilas(par, 50);
                Gestor.comprobarProgresoPremios();
                Gestor.comprobarProgresoPremiosFinalPartida();

                System.out.println("Compruebe que el premio \"Eliminador de filas\" se ha completado (y ningun otro)");
                partida = false;
                EventQueue.invokeLater(() -> {

                    var game = new MenuPremios();
                    game.setVisible(true);
                });
            } else if (args[0].equals("test2")) {
                System.out.println("No hagas nada, espera a perder la partida");
                System.out.println("Comprueba que el menu de fin de partida no menciona haber obtenido ningún premio");
                System.out.println("Luego ve al menu de premios");
                System.out.println("Comprueba que no hay progreso en ningún premio");

                par.addFilas(5000);
                par.addTetrises(15);
                par.obtenerPuntos();
            } else if (args[0].equals("test3")) {
                System.out.println("test3");
            }
        } catch(IndexOutOfBoundsException e) {

        }

        if (partida) {
            EventQueue.invokeLater(() -> {
    
                var game = new Tetris();
                game.setVisible(true);
            });
        }
    }
}
