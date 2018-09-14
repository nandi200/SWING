/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectsqlite;

/**
 *
 * @author erand
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
/**
 *
 * @author sqlitetutorial.net
 */
public class InsertDataSQLite {
 
    /**
     * Conección a nuevaBD.db
     *
     * @return the Connection object
     */
    private Connection connect() {
        // Conección a la DB
          // String url = "jdbc:sqlite:C:/Users/erand/Documents/CursoDiplomanoJava_SWING/SWING/SQLite/nuevaDB.db";
            String url = "jdbc:sqlite:/home/erandi/Documents/SWING/SQLite/nuevaDB.db";  //cic-cubo
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
 
    /**
     * Inserta un reglón a la BD de vendedores
     *
     * @param name
     * @param capacity
     */
    public void insert(String nombre, double edad, String plaza) {
        String sql = "INSERT INTO vendedores(nombre,edad,plaza) VALUES(?,?,?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setDouble(2, edad);
            pstmt.setString(3, plaza);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
        InsertDataSQLite nuevo = new InsertDataSQLite();
        // insert three new rows
        nuevo.insert("Luis", 30,"DCMX");
        nuevo.insert("Juan", 40,"Veracruz");
        nuevo.insert("Pedro",25,"San Luis");
    }
 
}