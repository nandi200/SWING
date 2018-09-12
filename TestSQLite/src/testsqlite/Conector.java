/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erandi
 */
public class Conector {
    // String url="/Users/erandi/GitHub/SWING/SQLite/pruebaBD.db"; 
    String url="/home/erandi/Documentos/erandi/SWING/SQLite/pruebaBD.db"; //cenac
  // String url = "C:\\Users\\erand\\Documents\\CursoDiplomanoJava_SWING\\SWING\\SQLite\\pruebaBD.db";
    Connection connect;

    public void connect() {
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:" + url);
            if (connect != null) {
                System.out.println("Conectado");
            }
        } catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos\n" + ex.getMessage());
        }
    }

    public void close() {
        try {
            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrarAlumnos() {
        ResultSet result = null;
        try {
            PreparedStatement st = connect.prepareStatement("select * from Alumno");
            result = st.executeQuery();
            while (result.next()) {

                System.out.print("Nombre: ");
                System.out.println(result.getString("Nombre"));

                System.out.print("Apellidos: ");
                System.out.println(result.getString("Apellido"));

                System.out.println("=======================");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void saveAlumno(Alumno alumno) {
        try {
            PreparedStatement st = connect.prepareStatement("insert into Alumno "
                    + "(Nombre,Apellido,EdoCivil,Promedio,Edad) values (?,?,?,?,?)");
            st.setString(1, alumno.getNombre());
            st.setString(2, alumno.getApellido());
            st.setString(3, alumno.getEdoCivil());
            st.setDouble(4, alumno.getPromedio());
            st.setInt(5, alumno.getEdad());
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

}
