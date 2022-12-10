package com.zetcode;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemploBDD {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        
        try {

            //STEP 2: Open a connection 
            System.out.println("Connecting to database..."); 
            conn = SGBD.getConnection();
            
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
            
            if (sin_inicializar) {
                //STEP 2: Open a connection 
                System.out.println("Connecting to database..."); 
                conn = SGBD.getConnection();
    
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
            conn = SGBD.getConnection();
    
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
            se.printStackTrace();
            try{ 
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            }
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se2){ 
                se2.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
