/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import model.Alumno;
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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;

/**
 *
 * @author erandi
 */
public class Conector {

    // String url="/Users/erandi/GitHub/SWING/SQLite/pruebaBD.db"; 
    //String url="/home/erandi/Documentos/erandi/SWING/SQLite/sistemaRegistroBD.db"; //cenac
    String url = "/home/erandi/Documents/SWING/SQLite/sistemaRegistro.db";  //cic-cubo

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


   

    public void guardarUsuario(Usuario usuario) {
        try {
            PreparedStatement st = connect.prepareStatement("insert into Usuarios2 "
                    + "(nombre,usuario,password,fechaNacimiento,direccion) values (?,?,?,?,?)");
            st.setString(1, usuario.getNombre());
            st.setString(2, usuario.getUsuario());
            st.setString(3, usuario.getPassword());
            st.setString(4, usuario.getFechaNacimiento());
            st.setString(5, usuario.getDireccion());
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public ArrayList<Usuario> buscaUsuario(String usuario, String password) {
        ResultSet result = null;
        ArrayList<Usuario> listUsu = new ArrayList<>();
        try {
            PreparedStatement st = connect.prepareStatement("SELECT * FROM Usuarios2 WHERE usuario = ? AND password = ?  ");

            // set the value
            st.setString(1, usuario);
            st.setString(2, password);
            result = st.executeQuery();
            while (result.next()) {
                Usuario usu = new Usuario(result.getString("nombre"), result.getString("usuario"),
                        result.getString("password"), result.getString("fechaNacimiento"), result.getString("direccion"));
                listUsu.add(usu);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return listUsu;
    }

    public ArrayList<Alumno> buscaXPromedioAlumnos(Double score) {
        ResultSet result = null;
        ArrayList<Alumno> listAlum = new ArrayList<>();
        try {
            PreparedStatement st = connect.prepareStatement("select * from Alumnos2 where promedio >= ?");

            // set the value
            st.setDouble(1, score);
            result = st.executeQuery();
            while (result.next()) {
                Alumno alum = new Alumno(result.getString("nombre"), result.getString("apellido"),
                        result.getDouble("promedio"),result.getInt("edad"),
                        result.getString("beca"),result.getString("fechaNacimiento") );
                listAlum.add(alum);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return listAlum;
    }
    public ArrayList<Alumno> buscarAlumnos() {
        ResultSet result = null;
        ArrayList<Alumno> listAlum = new ArrayList<>();
        try {
            PreparedStatement st = connect.prepareStatement("select * from Alumnos2");

           result = st.executeQuery();
            while (result.next()) {
                Alumno alum = new Alumno(result.getString("nombre"), result.getString("apellido"),
                        result.getDouble("promedio"), result.getInt("edad"),
                        result.getString("beca"),result.getString("fechaNacimiento") );
                listAlum.add(alum);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return listAlum;
    }

    
     public void guardarAlumno(Alumno alumno) {
        try {
            PreparedStatement st = connect.prepareStatement("insert into Alumnos2 "
                    + "(nombre,apellido,promedio,edad,beca,fechaNacimiento) values (?,?,?,?,?,?)");
            st.setString(1, alumno.getNombre());
            st.setString(2, alumno.getApellido());
            st.setDouble(3, alumno.getPromedio());;           
            st.setInt(4, alumno.getEdad());
            st.setString(5,alumno.getBeca());
            st.setString(6, alumno.getFechaNacimiento());
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
    public boolean actualizaPromedioAlumno(int edad, String name, Double score) {

        boolean resul = false;
        try {
            String sql = "UPDATE Alumnos2 SET Nombre = ?,"
                    + " Promedio = ? "
                    + " WHERE Edad = ?";

            PreparedStatement st = connect.prepareStatement(sql);

            // set the value
            st.setString(1, name);
            st.setDouble(2, score);
            st.setDouble(3, edad);

            st.executeUpdate();
            resul = true;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resul;
    }

    public boolean borrarAlumno(String name) {

        boolean resul = false;
        try {
            String sql = "DELETE FROM Alumnos2 "
                    + " WHERE Nombre = ?";

            PreparedStatement st = connect.prepareStatement(sql);

            // set the value
            st.setString(1, name);
            st.executeUpdate();
            resul = true;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resul;

    }

    /**
     * Read the file and returns the byte array
     *
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
            String updateSQL = "UPDATE Alumnos2 "
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
