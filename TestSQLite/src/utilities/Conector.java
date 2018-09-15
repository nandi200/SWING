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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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

   
  String url="/Users/erandi/GitHub/SWING/SQLite/sistemaRegistroBD.db"; //mac
    //String url="/home/erandi/Documentos/erandi/SWING/SQLite/sistemaRegistroBD.db"; //cenac
  //  String url = "/home/erandi/Documents/SWING/SQLite/sistemaRegistro.db";  //cic-cubo

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
            PreparedStatement st = connect.prepareStatement("insert into Usuarios "
                    + "(nombre,usuario,contraseña,fechaNac,dirección) values (?,?,?,?,?)");
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
            PreparedStatement st = connect.prepareStatement("SELECT * FROM Usuarios WHERE usuario = ? AND contraseña = ?  ");

            // set the value
            st.setString(1, usuario);
            st.setString(2, password);
            result = st.executeQuery();
            while (result.next()) {
                Usuario usu = new Usuario(result.getString("nombre"), result.getString("usuario"),
                        result.getString("contraseña"), result.getString("fechaNac"), result.getString("dirección"));
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
            PreparedStatement st = connect.prepareStatement("select * from Alumnos where promedio >= ?");

            // set the value
            st.setDouble(1, score);
            result = st.executeQuery();
            while (result.next()) {
                Alumno alum = new Alumno(result.getString("nombre"), result.getString("apellido"),
                        result.getDouble("promedio"),result.getString("grado"), result.getInt("edad"),
                        result.getString("beca"),result.getString("fechaNacimiento"),result.getBytes("imagen") );
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
            PreparedStatement st = connect.prepareStatement("select * from Alumnos");

           result = st.executeQuery();
            while (result.next()) {
                Alumno alum = new Alumno(result.getString("nombre"), result.getString("apellido"),
                        result.getDouble("promedio"),result.getString("grado"), result.getInt("edad"),
                        result.getString("beca"),result.getString("fechaNacimiento"),result.getBytes("imagen") );
                listAlum.add(alum);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return listAlum;
    }

    
     public void guardarAlumno(Alumno alumno) {
        try {
            PreparedStatement st = connect.prepareStatement("insert into Alumnos "
                    + "(nombre,apellido,promedio,grado,edad,beca,fechaNacimiento,imagen) values (?,?,?,?,?,?,?,?)");
            st.setString(1, alumno.getNombre());
            st.setString(2, alumno.getApellido());
            st.setDouble(3, alumno.getPromedio());
            st.setString(4, alumno.getGrado());
            st.setInt(5, alumno.getEdad());
            st.setString(6,alumno.getBeca());
            st.setString(7, alumno.getFechaNacimiento());
            st.setBytes(8,alumno.getAlumnoImagen());
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
    public boolean actualizaPromedioAlumno(int edad, String name, Double score) {

        boolean resul = false;
        try {
            String sql = "UPDATE Alumnos SET Nombre = ?,"
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
            String sql = "DELETE FROM Alumnos "
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
     * Update picture for a specific material
     *
     * @param materialId
     * @param filename
     */
    public void updatePicture(String nombre, String filename) {
        try {
            // update sql
            String updateSQL = "UPDATE Alumnos "
                    + "SET fotografia = ? "
                    + "WHERE nombre=?";

            PreparedStatement pstmt = connect.prepareStatement(updateSQL);
            ImageBlob img = new ImageBlob();    
            // set parameters
            pstmt.setBytes(1, img.readFile(filename));
            pstmt.setString(2, nombre);

            pstmt.executeUpdate();
            System.out.println("Stored the file in the BLOB column.");
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
/**
     * read the picture file and insert into the material master table
     *
     * @param materialId
     * @param filename
     */
    public void readPicture(int materialId, String filename) {
        // update sql
        String selectSQL = "SELECT picture FROM materials WHERE id=?";
        ResultSet rs = null;
        FileOutputStream fos = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
 
        try {
            
            pstmt = connect.prepareStatement(selectSQL);
            pstmt.setInt(1, materialId);
            rs = pstmt.executeQuery();
 
            // write binary stream into file
            File file = new File(filename);
            fos = new FileOutputStream(file);
 
            System.out.println("Writing BLOB to file " + file.getAbsolutePath());
            while (rs.next()) {
                InputStream input = rs.getBinaryStream("picture");
                byte[] buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    fos.write(buffer);
                }
            }
        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
 
                if (conn != null) {
                    conn.close();
                }
                if (fos != null) {
                    fos.close();
                }
 
            } catch (SQLException | IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
