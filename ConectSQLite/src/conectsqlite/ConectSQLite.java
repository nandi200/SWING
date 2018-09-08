/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectsqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author erand
 */
public class ConectSQLite {

    public static void connect() {
        Connection conn = null;
        try {
            // parametros de la db
            //url
            //String url = "C:\\Users\\erand\\Documents\\CursoDiplomanoJava_SWING\\SWING\\SQLite\\pruebaBD.db";
            String url = "jdbc:sqlite:C:/Users/erand/Documents/CursoDiplomanoJava_SWING/SWING/SQLite/pruebaBD.db";
            //crea una conección con la bd
            conn = DriverManager.getConnection(url);

            System.out.println("La conección con SQLite ha sido establecida.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        connect();
    }
}
