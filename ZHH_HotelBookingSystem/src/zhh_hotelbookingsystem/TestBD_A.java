/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zhh_hotelbookingsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Honghui Zhang
 */

/**
 * 
 * This file is only used to test whether the database can be used, and has no actual relationship with the project!
 * This file is only used to test whether the database can be used, and has no actual relationship with the project!
 * This file is only used to test whether the database can be used, and has no actual relationship with the project!
 * This file is only used to test whether the database can be used, and has no actual relationship with the project!
 * This file is only used to test whether the database can be used, and has no actual relationship with the project!
 * This file is only used to test whether the database can be used, and has no actual relationship with the project!
 */
public class TestBD_A {
    public static Connection conn;
    public static String url = "jdbc:derby://localhost:1527/TestDB";
    public static String username = "pdc";
    public static String password = "pdc";
    
    public ResultSet getQuery(){
        ResultSet rs = null;
        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "SELECT * FROM BOOK";
            rs = statement.executeQuery(sqlQuery);
            
            while (rs.next()) {        
                String name = rs.getString("TITLE");
                String category = rs.getString("CATEGORY");
                String price = rs.getString("PRICE");
                System.out.println("name: " + name + "category: " + category + "price:" + price);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestBD_A.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public void establishMySQLConnection(){
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println(url+" connected...");
        } catch (SQLException ex) {
            Logger.getLogger(TestBD_A.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createTable(){
        try {
            Statement statement = conn.createStatement();
            String newTable = "finalTable";
            String sqlCreateTable = "CREATE TABLE " + newTable +" (BOOKID INT,TITLE VARCHAR(50),CATEGORY VARCHAR(20),PRICE FLOAT)";
            statement.executeUpdate(sqlCreateTable);
        } catch (SQLException ex) {
            Logger.getLogger(TestBD_A.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addSomething(){
        try {
            Statement statement = conn.createStatement();
            String sqlString = "INSERT INTO BOOK VALUES(9,'AAA','BBB',36.66)";
            statement.executeUpdate(sqlString);
        } catch (SQLException ex) {
            Logger.getLogger(TestBD_A.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void main(String[] args) {
        TestBD_A testBD_A = new TestBD_A();
        testBD_A.establishMySQLConnection();
        testBD_A.addSomething();
        testBD_A.getQuery();
    }   
}
