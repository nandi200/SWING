/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectsqlite;

 
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class CreateDBSQlite{
 
    /**
     * Creación de una BD
     *
     * @param fileName Nombre de la BD a crar
     */
    public static void crearBDSQLite(String fileName) {
 
        //String url = "jdbc:sqlite:C:/sqlite/db/" + fileName;
        String url = "jdbc:sqlite:C:/Users/erand/Documents/CursoDiplomanoJava_SWING/SWING/SQLite/"+fileName;
 
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("El nombre del manejador es:  " + meta.getDriverName());
                System.out.println("Uns nueva BD ha sido creada.");
            }
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        crearBDSQLite("nuevaDB.db");
    }
}
