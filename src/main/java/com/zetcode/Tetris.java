package com.zetcode;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
Java Tetris game clone

Author: Jan Bodnar
Website: https://zetcode.com
 */
public class Tetris extends JFrame {
	
	private static final Logger logger = LogManager.getLogger(Tetris.class);

    private JLabel statusbar;

    public Tetris() {

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
        // JDBC driver name and database URL 
        String JDBC_DRIVER = "org.h2.Driver";
        String DB_URL = "jdbc:h2:~/test";

        //  Database credentials 
        String USER = "sa";
        String PASS = "sa";
        Connection conn = null;
        Statement stmt = null;
        try { 
            // STEP 1: Register JDBC driver 
            Class.forName(JDBC_DRIVER); 
                
            //STEP 2: Open a connection 
            System.out.println("Connecting to database..."); 
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            //STEP 3: Execute a query 
            System.out.println("Creating table in given database..."); 
            stmt = conn.createStatement();
            String sql = null;
            boolean sin_inicializar = true;
            try {
                sql = "CREATE TABLE   REGISTRATION " +
                "(id INTEGER not NULL, " + 
                " first VARCHAR(255), " +  
                " last VARCHAR(255), " +  
                " age INTEGER, " +  
                " PRIMARY KEY ( id ))";  
                stmt.executeUpdate(sql);
                System.out.println("Created table in given database...");     
            } catch (Exception e) {
                sin_inicializar = false;
            }
            
            // STEP 4: Clean-up environment 
            stmt.close(); 
            conn.close(); 

            conn = DriverManager.getConnection(DB_URL,USER,PASS);  

            
            if (sin_inicializar) {
                //STEP 2: Open a connection 
                System.out.println("Connecting to database..."); 
                conn = DriverManager.getConnection(DB_URL,USER,PASS);

                //STEP 3: Execute a query 
                System.out.println("INSERTING..."); 
                stmt = conn.createStatement(); 
                sql =  "INSERT INTO REGISTRATION(id, age) VALUES (5, 19)";
                stmt.executeUpdate(sql);
                System.out.println("INSERTED...");
                
                // STEP 4: Clean-up environment 
                stmt.close();
                conn.close();
            }

            //STEP 2: Open a connection 
            System.out.println("Connecting to database..."); 
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 3: Execute a query 
            System.out.println("SELECTING..."); 
            stmt = conn.createStatement(); 
            sql =  "SELECT id, age FROM REGISTRATION WHERE id=5";
            ResultSet result = stmt.executeQuery(sql);
            System.out.println("SELECTED...");
            result.next();
            System.out.println(result.getInt("id"));
            System.out.println(result.getInt("age"));
            
            // STEP 4: Clean-up environment 
            stmt.close();
            conn.close();
        } catch(SQLException se) { 
            //Handle errors for JDBC 
            se.printStackTrace(); 
        } catch(Exception e) { 
            //Handle errors for Class.forName 
            e.printStackTrace(); 
        } finally { 
            //finally block used to close resources 
            try{ 
                if(stmt!=null) stmt.close(); 
            } catch(SQLException se2) { 
            } // nothing we can do 
            try { 
                if(conn!=null) conn.close(); 
            } catch(SQLException se){ 
                se.printStackTrace(); 
            } //end finally try 
        } //end try 
        System.out.println("Goodbye!");

    	logger.info("Playing");
        EventQueue.invokeLater(() -> {

            var game = new Tetris();
            game.setVisible(true);
        });
    }
}