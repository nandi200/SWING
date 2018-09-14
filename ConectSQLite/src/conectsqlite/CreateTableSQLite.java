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
import java.sql.SQLException;
import java.sql.Statement;
 
public class CreateTableSQLite{
    /**
     * Create a new table in the test database
     *
     */
    public static void creaNuevaTabla() {
        // Dirección de la BD
        // String url = "jdbc:sqlite:C:/Users/erand/Documents/CursoDiplomanoJava_SWING/SWING/SQLite/nuevaDB.db";
         String url = "jdbc:sqlite:/home/erandi/Documents/SWING/SQLite/sistemaRegistro.db";  //cic-cubo
        
        // SQL declaración para la nueva Tabla
        String sql = "CREATE TABLE IF NOT EXISTS Usuarios2 (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	nombre text NOT NULL,\n"
                + "	usuario text,\n"
                + "	password text,\n"
                + "	fechaNacimiento text,\n"
                + "	direccion text\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // crea la nueva tabla, ejecuta la declaración
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        creaNuevaTabla();
    }
 
}
