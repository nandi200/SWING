/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erandi
 */
public class Conector {
    // String url="/Users/erandi/GitHub/SWING/SQLite/pruebaBD.db"; 
    //String url="/home/erandi/Documentos/erandi/SWING/SQLite/pruebaBD.db"; //cenac
    String url = "/home/erandi/Documents/SWING/SQLite/pruebaBD.db";  //cic-cubo
    
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

    public ArrayList<Alumno> buscarAlumnos() {
        ResultSet result = null;
        ArrayList<Alumno> listAlum= new ArrayList<>(); 
        try {
            PreparedStatement st = connect.prepareStatement("select * from Alumno");
            result = st.executeQuery();
            while (result.next()) {
                Alumno alum = new Alumno(result.getString("Nombre"),result.getString("Apellido"),
                result.getInt("Edad"),result.getString("EdoCivil"),result.getDouble("Promedio"));
                listAlum.add(alum);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return listAlum;
    }

    public void guardarAlumno(Alumno alumno) {
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
    
    
      public ArrayList<Alumno> buscaXPromedioAlumnos(Double score) {
        ResultSet result = null;
        ArrayList<Alumno> listAlum= new ArrayList<>(); 
        try {
            PreparedStatement st = connect.prepareStatement("select * from Alumno where Promedio >= ?");
            
           // set the value
            st.setDouble(1,score);
             result  = st.executeQuery();
            while (result.next()) {
                Alumno alum = new Alumno(result.getString("Nombre"),result.getString("Apellido"),
                result.getInt("Edad"),result.getString("EdoCivil"),result.getDouble("Promedio"));
                listAlum.add(alum);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return listAlum;
    }
      
      
       public boolean actualizaPromedioAlumno(int edad,String name,Double score) {
        
            boolean resul=false;
        try {
            String sql="UPDATE Alumno SET Nombre = ?,"
                    + " Promedio = ? "
                    + " WHERE Edad = ?";
            
            PreparedStatement st = connect.prepareStatement(sql);
            
           // set the value
           st.setString(1, name);
           st.setDouble(2,score);
           st.setDouble(3,edad);
           
           st.executeUpdate();           
           resul=true;
          
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resul;
    }

       public boolean borrarAlumno(String name) {
        
            boolean resul=false;
        try {
            String sql="DELETE FROM Alumno "
                    + " WHERE Nombre = ?";
            
            PreparedStatement st = connect.prepareStatement(sql);
            
           // set the value
           st.setString(1, name);                   
           st.executeUpdate();           
           resul=true;
          
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resul;
 
       }
       
        /**
     * Read the file and returns the byte array
     * @param file
     * @return the bytes of the file
     */
    private byte[] readFile(String file) {
        ByteArrayOutputStream bos = null;
        try {
            File f = new File(file);
            FileInputStream fis = new FileInputStream(f);
            byte[] buffer = new byte[1024];
            bos = new ByteArrayOutputStream();
            for (int len; (len = fis.read(buffer)) != -1;) {
                bos.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e2) {
            System.err.println(e2.getMessage());
        }
        return bos != null ? bos.toByteArray() : null;
    }
    /**
     * Update picture for a specific material
     *
     * @param materialId
     * @param filename
     */
    public void updatePicture(String nombre, String filename) {
        try {
            // update sql
            String updateSQL = "UPDATE Alumno "
                    + "SET fotografia = ? "
                    + "WHERE nombre=?";
            
            PreparedStatement pstmt = connect.prepareStatement(updateSQL);
            
            // set parameters
            pstmt.setBytes(1, readFile(filename));
            pstmt.setString(2, nombre);
 
            pstmt.executeUpdate();
            System.out.println("Stored the file in the BLOB column.");
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
 
      
    }
    
    
}
